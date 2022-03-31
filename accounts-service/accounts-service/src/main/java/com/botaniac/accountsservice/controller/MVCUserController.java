package com.botaniac.accountsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MVCUserController {
    @GetMapping("/Register")
    public WebMvcProperties.View bringRegisterPage(){
        log.info("Getting the register page...");
        return new WebMvcProperties.View();
    }
}
