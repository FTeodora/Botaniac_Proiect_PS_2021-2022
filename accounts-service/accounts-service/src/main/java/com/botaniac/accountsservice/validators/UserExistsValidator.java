package com.botaniac.accountsservice.validators;

import com.botaniac.accountsservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserExistsValidator implements ConstraintValidator<UserExists,String> {
    @Autowired
    private UserRepo userRepo;
    @Override
    public void initialize(UserExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(String user, ConstraintValidatorContext constraintValidatorContext) {
        return userRepo.existsByUsername(user);
    }
}
