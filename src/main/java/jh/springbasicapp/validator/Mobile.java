package jh.springbasicapp.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by lenovo on 19/02/2015.
 */
@Documented
@Constraint(validatedBy = MobileValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Mobile {

    String message() default "{Mobile}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
