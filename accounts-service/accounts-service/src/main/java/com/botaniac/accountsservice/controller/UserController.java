package com.botaniac.accountsservice.controller;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class UserController {
    Logger logger=LoggerFactory.getLogger(UserController.class);
    UserService userService=new UserService();
    @GetMapping("/accounts")
    public String showUserName(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("username","Hello from accounts");
        logger.info("I have visited accounts");
        return "Hello from accounts";
    }
}
