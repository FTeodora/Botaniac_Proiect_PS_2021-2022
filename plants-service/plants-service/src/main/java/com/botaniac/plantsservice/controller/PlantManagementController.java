package com.botaniac.plantsservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PlantManagementController {
    Logger logger= LoggerFactory.getLogger(PlantManagementController.class);
    @GetMapping("/plants")
    public String viewPlants(){
        logger.info("I have reached the plants");
        return "Hello from plants service";
    }
}
