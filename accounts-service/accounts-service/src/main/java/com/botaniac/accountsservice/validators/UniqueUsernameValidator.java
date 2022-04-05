package com.botaniac.accountsservice.validators;

import com.botaniac.accountsservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {
    @Autowired
    private UserRepo userRepo;
    @Override
    public void initialize(UniqueUsername constraintAnnotation) {
    }

    @Override
    public boolean isValid(String user, ConstraintValidatorContext constraintValidatorContext) {

        if(userRepo.existsByUsername(user)) {
            return false;
        }
        return true;
    }
}
