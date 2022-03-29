package com.Botaniac.homepageservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomepageController {
    Logger logger= LoggerFactory.getLogger(Logger.class);
    @GetMapping("/Homepage")
    public WebMvcProperties.View getHomepage(){
        logger.info("Getting the homepage...");
        return new WebMvcProperties.View();
    }
}
