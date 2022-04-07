package com.Botaniac.homepageservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class HomepageController {
    @GetMapping("/Homepage")
    public WebMvcProperties.View getHomepage(){
        log.info("Getting the homepage...");
        return new WebMvcProperties.View();
    }
    @GetMapping("/Welcome")
    public ModelAndView getHomepageForUser(@RequestParam String username){
        log.info("Getting the homepage for user "+username+" ...");
        ModelAndView mav=new ModelAndView();
        mav.addObject("username",username);
        return mav;
    }
}
