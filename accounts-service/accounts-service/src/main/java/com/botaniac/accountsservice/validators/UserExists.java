package com.botaniac.accountsservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy= UserExistsValidator.class)
public @interface UserExists {
    String message() default "Username is does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
