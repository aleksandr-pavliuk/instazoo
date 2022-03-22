package ua.org.instazoo.payload.response;

import lombok.Getter;

/**
 * @author Alex
 * @link https://intvw.me
 */
@Getter
public class InvalidLoginResponse {

  private String username;
  private String password;

  public InvalidLoginResponse(){
    this.username = "Invalid Username";
    this.password = "Invalid Password";
  }
}
