package com.botaniac.accountsservice.controller;

import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class MVCUserController {
    @Autowired
    private UserService userService=new UserService();
    @GetMapping("/Register")
    public ModelAndView bringRegisterPage(){
        log.info("Getting the register page...");
        ModelAndView mav=new ModelAndView();
        mav.addObject("newUser",new RegisterDTO());
        return mav;
    }
    @PostMapping("/Register")
    public String submitUser(@ModelAttribute("newUser") RegisterDTO newUser){
        log.info("Register info submitted. Creating account for user "+newUser.getUsername()+"...");
        userService.registerAccount(newUser);
        return "Register";
    }
}
