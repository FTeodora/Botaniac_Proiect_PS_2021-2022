package com.botaniac.accountsservice.service;

import com.botaniac.accountsservice.dto.RegisterDTO;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Slf4j
public class ValidationHandler {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    public <T> void showErrors(T obj){
        Set<ConstraintViolation<T>> constraintViolations=validator.validate(obj);
        for (ConstraintViolation<T> curr : constraintViolations) {
            log.info(curr.getMessage());
        }
    }
    public <T> Boolean hasErrors(T obj){
        Set<ConstraintViolation<T>> constraintViolations=validator.validate(obj);
        return !constraintViolations.isEmpty();
    }
}
