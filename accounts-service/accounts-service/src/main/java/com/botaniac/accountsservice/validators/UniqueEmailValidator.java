package com.botaniac.accountsservice.validators;

import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.repository.UserRepo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueMail,String>{
    @Autowired
    UserRepo userRepo;
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
