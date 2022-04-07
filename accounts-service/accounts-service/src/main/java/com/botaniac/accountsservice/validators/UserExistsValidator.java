package com.botaniac.accountsservice.validators;

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
public class UserExistsValidator implements ConstraintValidator<UserExists,String>{
    @Autowired
    UserRepo userRepo;
    @Override
    public void initialize(UserExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(String user, ConstraintValidatorContext constraintValidatorContext) {
        return this.userRepo.existsByUsername(user);
    }
}
