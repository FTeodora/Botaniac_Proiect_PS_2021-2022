package com.botaniac.plantsservice.controller.rest;

import com.botaniac.plantsservice.DTO.PlantPageDTO;
import com.botaniac.plantsservice.service.plantsService.PlantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@RestController
@Slf4j
public class PlantViewController {
    @Autowired
    PlantService plantService;
    @GetMapping("/plants/generateTxt")
    public ResponseEntity<File> makeTxt(@ModelAttribute("plant")PlantPageDTO plant){
        log.info("Generating file in "+plant.getFileType());
        File f=plantService.generateTxt(plant);
        return ResponseEntity.ok().body(f);
    }


}
