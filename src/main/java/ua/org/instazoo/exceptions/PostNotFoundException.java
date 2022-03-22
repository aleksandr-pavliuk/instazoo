package ua.org.instazoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Alex
 * @link https://intvw.me
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostNotFoundException extends RuntimeException {
  public PostNotFoundException(String msg) {
    super(msg);
  }
}
