package jh.springbasicapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Jahangir on 26/02/2015.
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {


        if (password == null)
        {
            return false;
        }
        else if (password.matches(PASSWORD_PATTERN))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
