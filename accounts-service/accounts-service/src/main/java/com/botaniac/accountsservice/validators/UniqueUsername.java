package com.botaniac.accountsservice.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy= UniqueUsernameValidator.class)
public @interface UniqueUsername {
    String message() default "Username is already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}