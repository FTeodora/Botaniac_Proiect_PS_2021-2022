package com.botaniac.plantsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlantManagementController {
    @GetMapping("/plants")
    public String viewPlants(){
        log.info("I have reached the plants");
        return "Hello from plants service";
    }
}
