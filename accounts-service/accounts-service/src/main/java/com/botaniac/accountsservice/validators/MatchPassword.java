package com.botaniac.accountsservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy=MatchPasswordValidator.class)
public @interface MatchPassword {
    String message() default "Please make sure the passwords match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
