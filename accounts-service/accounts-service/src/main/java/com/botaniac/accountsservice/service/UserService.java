package com.botaniac.accountsservice.service;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.dto.LoginDTO;
import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.factories.UserFactory;
import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();
    private ValidationHandler validationHandler=new ValidationHandler();

    /**
     * Searches for the user with the given username and password
     * @param credentials
     * @return
     */
    public boolean logIn(LoginDTO credentials){
        log.info("Logging in as user "+credentials.getUsername());
        return userRepo.existsByUsernameAndPassword(credentials.getUsername(),credentials.getPassword());
    }

    /**
     * Useful for getting user data in the forums-service
     * @param id
     * @return
     */
    public ForumPosterDTO getForumPosterInfo(String id){
        User u=userRepo.findById(id).get();
        return new ForumPosterDTO(u);
    }

    /**
     * Registers an account with valid data. Validation is done via java constraints
     * @param account
     */
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
