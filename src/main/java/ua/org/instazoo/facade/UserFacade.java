package ua.org.instazoo.facade;

import ua.org.instazoo.dto.UserDTO;
import ua.org.instazoo.entity.User;

/**
 * @author Alex
 * @link https://intvw.me
 */
public class UserFacade {

  public UserDTO userToUserDTO(User user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setFirstname(user.getName());
    userDTO.setLastname(user.getLastname());
    userDTO.setUsername(user.getUsername());
    userDTO.setBio(user.getBio());
    return userDTO;
  }
}