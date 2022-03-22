package ua.org.instazoo.service;

import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.org.instazoo.dto.UserDTO;
import ua.org.instazoo.entity.User;
import ua.org.instazoo.entity.enums.ERole;
import ua.org.instazoo.exceptions.UserExistException;
import ua.org.instazoo.payload.request.SignupRequest;
import ua.org.instazoo.repository.UserRepository;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Service
public class UserService {

  public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;


  @Autowired
  public UserService(UserRepository userRepository,
      BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public User createUser(SignupRequest userIn) {

    User user = new User();
    user.setEmail(userIn.getEmail());
    user.setName(userIn.getFirstname());
    user.setLastname(userIn.getLastname());
    user.setUsername(userIn.getUsername());
    user.setPassword(passwordEncoder.encode(userIn.getPassword()));
    user.getRoles().add(ERole.ROLE_USER);

    try {
      LOG.info("Saving User {}", userIn.getEmail());
      return userRepository.save(user);
    } catch (Exception ex) {
      LOG.error("Error during registration. {}", ex.getMessage());
      throw new UserExistException(
          "The user " + user.getUsername() + " already exist. Please check credentials");
    }
  }

  public User updateUser(UserDTO userDTO, Principal principal) {
    User user = getUserByPrincipal(principal);
    user.setName(userDTO.getFirstname());
    user.setLastname(userDTO.getLastname());
    user.setBio(userDTO.getBio());

    return userRepository.save(user);
  }


  private User getUserByPrincipal(Principal principal) {
    String username = principal.getName();
    return userRepository.findUserByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found with username " + username));

  }


}