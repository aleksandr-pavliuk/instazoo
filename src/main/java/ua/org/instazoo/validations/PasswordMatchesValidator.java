package ua.org.instazoo.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ua.org.instazoo.annotations.PasswordMatches;
import ua.org.instazoo.payload.request.SignupRequest;

/**
 * @author Alex
 * @link https://intvw.me
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

  @Override
  public void initialize(PasswordMatches constraintAnnotation) {

  }

  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
    SignupRequest userSignupRequest = (SignupRequest) obj;
    return userSignupRequest.getPassword().equals(userSignupRequest.getConfirmPassword());
  }
}
