package com.botaniac.accountsservice.controller.rest;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.dto.ProfileDTO;
import com.botaniac.accountsservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ForumPosterDTO> getPosterInfo(@RequestParam String userID){
        log.info("Getting the user with id "+userID);
        ForumPosterDTO poster= userService.getForumPosterInfo(userID);
        if(poster==null){
            log.error("Couldn't get poster info");
        }else{
            log.info("Found user: "+poster.getUsername());
        }
        return ResponseEntity.ok(poster);
    }
    @PostMapping("/accounts/Profile")
    public ResponseEntity<String> editUser(@ModelAttribute("siteUser")ProfileDTO siteUser){
        log.info(siteUser.getUsername()+" attempting to change their settings...");
        if(userService.updateProfile(siteUser))
            return ResponseEntity.ok("Your information has been updated! Refresh to see changes");
        return ResponseEntity.badRequest().body("There has been an error processing your information");
    }
}
