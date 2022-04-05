package com.botaniac.accountsservice.service;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.dto.LoginDTO;
import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.factories.UserFactory;
import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepo userRepo;
    private ValidationHandler validationHandler=new ValidationHandler();
    public ForumPosterDTO getUserUsername(String id){
        return new ForumPosterDTO(userRepo.findById(id).get());
    }
    public boolean logIn(LoginDTO credentials){
        log.info("Logging in as user "+credentials.getUsername());
        return userRepo.existsByUsernameAndPassword(credentials.getUsername(),credentials.getPassword());
    }
    public void registerAccount(RegisterDTO account){
        log.info("Registering "+account.getUsername()+" ...");
        User newAccount=UserFactory.createDefaultUser(account);
        if(validationHandler.hasErrors(newAccount)) {
            validationHandler.showErrors(newAccount);
        }
        else{
            userRepo.save(newAccount);
        }
    }
}
