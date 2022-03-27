package com.botaniac.forumsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
public class ForumController {
    Logger logger= LoggerFactory.getLogger(ForumController.class);
    @GetMapping("/forums")
    public String showUserName(){
        logger.info("I have visited the forums");
        return "Hello from the forums";
    }
}

