package com.botaniac.accountsservice.controller;

import com.botaniac.accountsservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RestUserController {
    UserService userService=new UserService();
    @GetMapping("/accounts")
    public String showUserName(){
        log.info("I have visited accounts");
        return "Hello from accounts";
    }

}
