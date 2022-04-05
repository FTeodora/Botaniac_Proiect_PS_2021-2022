package com.botaniac.accountsservice.validators;

import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueMail,String>{
    @Autowired
    private UserRepo userRepo;
    @Override
    public void initialize(UniqueMail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String eMail, ConstraintValidatorContext constraintValidatorContext) {

        if(userRepo.existsByEmail(eMail)) {
            return false;
        }
        return true;
    }
}
