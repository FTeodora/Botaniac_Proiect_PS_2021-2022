package com.botaniac.accountsservice.validators;

import com.botaniac.accountsservice.dto.RegisterDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchPasswordValidator implements ConstraintValidator<MatchPassword, RegisterDTO> {
    @Override
    public void initialize(MatchPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(RegisterDTO registerDTO, ConstraintValidatorContext constraintValidatorContext) {

        //if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
           // return false;
        //}
        return false;
    }
}
