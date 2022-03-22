package ua.org.instazoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alex
 * @link https://intvw.me
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserExistException extends RuntimeException {

  public UserExistException(String message) {
    super(message);
  }
}
