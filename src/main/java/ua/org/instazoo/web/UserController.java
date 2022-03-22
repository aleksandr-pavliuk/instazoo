package ua.org.instazoo.web;

import java.security.Principal;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.org.instazoo.dto.UserDTO;
import ua.org.instazoo.entity.User;
import ua.org.instazoo.facade.UserFacade;
import ua.org.instazoo.service.UserService;
import ua.org.instazoo.validations.ResponseErrorValidation;

/**
 * @author Alex
 * @link https://intvw.me
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {

  @Autowired
  private UserService userService;
  @Autowired
  private UserFacade userFacade;
  @Autowired
  private ResponseErrorValidation responseErrorValidation;

  @GetMapping("/")
  public ResponseEntity<UserDTO> getCurrentUser(Principal principal) {
    User user = userService.getCurrentUser(principal);
    UserDTO userDTO = userFacade.userToUserDTO(user);

    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) {
    User user = userService.getUserById(Long.parseLong(userId));
    UserDTO userDTO = userFacade.userToUserDTO(user);

    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  }

  @PostMapping("/update")
  public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDTO userDTO,
      BindingResult bindingResult, Principal principal) {
    ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
    if (!ObjectUtils.isEmpty(errors)) {
      return errors;
    }

    User user = userService.updateUser(userDTO, principal);

    UserDTO userUpdated = userFacade.userToUserDTO(user);
    return new ResponseEntity<>(userUpdated, HttpStatus.OK);
  }


}
