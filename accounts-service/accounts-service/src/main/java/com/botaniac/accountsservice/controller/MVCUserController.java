package com.botaniac.accountsservice.controller;

import com.botaniac.accountsservice.dto.LoginDTO;
import com.botaniac.accountsservice.dto.RegisterDTO;
import com.botaniac.accountsservice.service.UserService;
import com.botaniac.accountsservice.service.ValidationHandler;
import com.sun.net.httpserver.HttpContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public String submitUser(@Valid @ModelAttribute("newUser") RegisterDTO newUser, BindingResult result){
        log.info("Register info submitted. Creating account for user "+newUser.getUsername()+"...");
        if(!result.hasErrors()){
            log.info("No errors found! Creating account");
            userService.registerAccount(newUser);
            return "/Login";
        }
        log.error("The user you want to insert doesn't have valid data");
        ValidationHandler handler=new ValidationHandler();
        handler.showErrors(newUser);
        result.getAllErrors().forEach(x->log.warn(x.toString()));
        return "/Register";
    }
    @GetMapping("/Login")
    public ModelAndView login(){
        ModelAndView mav= new ModelAndView();
        mav.addObject("credentials",new LoginDTO());
        return mav;
    }
    @PostMapping("/Login")
    public String login(@Valid @ModelAttribute("credentials")LoginDTO credentials, BindingResult result){
        if(userService.logIn(credentials))
            return "redirect:http://localhost:8420/Welcome?username="+credentials.getUsername();
        else
            return "/Login";
    }
}
