package ua.org.instazoo.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Data
public class CommentDTO {

  private Long id;
  @NotEmpty
  private String message;
  private String username;
}
