package ua.org.instazoo.payload.request;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Data
public class LoginRequest {

  @NotEmpty(message = "Username cannot be empty")
  private String username;
  @NotEmpty(message = "Password cannot be empty")
  private String password;

}
