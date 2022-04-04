package com.botaniac.accountsservice.service;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Iterator;
import java.util.Set;

@Service
@Slf4j
public class UserService {
    UserRepo userRepo;
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();
    public ForumPosterDTO getUserUsername(String id){
        return new ForumPosterDTO(userRepo.findById(id).get());
    }
    public boolean registerAccount(RegisterDTO account){
        log.info("Validating data...");

        Set<ConstraintViolation<RegisterDTO>> constraintViolations=validator.validate(account);
        for (ConstraintViolation<RegisterDTO> curr : constraintViolations) {
            log.info(curr.getMessage());
        }
        return true;
    }
}
