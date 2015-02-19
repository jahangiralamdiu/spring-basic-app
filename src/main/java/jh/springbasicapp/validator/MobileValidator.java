package jh.springbasicapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by lenovo on 19/02/2015.
 */
public class MobileValidator implements ConstraintValidator<Mobile, String> {
    @Override
    public void initialize(Mobile mobile) {

    }

    @Override
    public boolean isValid(String mobileNo, ConstraintValidatorContext constraintValidatorContext) {

        if (mobileNo == null) {
            return false;
        } else if (mobileNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return true;
        }
        //validating phone number with extension length from 3 to 5
        else if (mobileNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            return true;
        }

        //validating phone number where area code is in braces ()
        else if (mobileNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            return true;
        }
        //return false if nothing matches the input
        else {
            return false;
        }
    }
}
