package ua.org.instazoo.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Data
public class UserDTO {
  private Long id;
  @NotEmpty
  private String firstname;
  @NotEmpty
  private String lastname;
  private String username;
  private String bio;


}
