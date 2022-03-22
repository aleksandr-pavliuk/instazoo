package ua.org.instazoo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Data
@AllArgsConstructor
public class JWTTokenSuccessResponse {

  private boolean success;
  private String token;
}
