package com.botaniac.accountsservice.controller;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RestUserController {
    @Autowired
    UserService userService=new UserService();
    @GetMapping("/accounts")
    public String showUserName(){
        log.info("I have visited accounts");
        return "Hello from accounts";
    }
    @GetMapping("/accounts/retrieve")
    public ForumPosterDTO getPosterInfo(@RequestParam String userID){
        log.info("Getting the user with id "+userID);
        ForumPosterDTO poster= userService.getForumPosterInfo(userID);
        if(poster==null){
            log.error("Couldn't get poster info");
        }else{
            log.info("Found user: "+poster.getUsername());
        }
        return poster;
    }
}
