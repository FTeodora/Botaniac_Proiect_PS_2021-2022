package com.botaniac.accountsservice.service;

import com.botaniac.accountsservice.components.ProfileMapper;
import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.dto.LoginDTO;
import com.botaniac.accountsservice.dto.ProfileDTO;
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
    ProfileMapper mapper;
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();
    private ValidationHandler validationHandler=new ValidationHandler();
    public boolean updateProfile(ProfileDTO dto) {
        User user= userRepo.findByUsername(dto.username);

        mapper.updateUserFromDTO(dto, user);
        user.setBirthday(dto.bringBirthday());
        log.info("Birthday: "+user.getBirthday()+" "+user.getUsername());
        try{
            userRepo.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
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
    public ProfileDTO getProfile(String username){
        return modelMapper.map(userRepo.findByUsername(username),ProfileDTO.class);
    }
}
