package com.botaniac.plantsservice.controller.rest;

import com.botaniac.plantsservice.DTO.ViewPlantDTO;
import com.botaniac.plantsservice.fileManagers.readers.CSVPlantReader;
import com.botaniac.plantsservice.service.plantsService.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
public class PlantManagementController {
    @Autowired
    PlantService plantService=new PlantService();
    @GetMapping("/plants/hi")
    public String viewPlants(){
        log.info("I have reached the plants");
        return "Hello from plants service";
    }
    @RequestMapping(value = "/plants/getPlants",method = RequestMethod.GET)
    public List<ViewPlantDTO> showPlants(@RequestParam int page){
        log.info("Getting plants from page "+page);
        return plantService.browsePlants(page-1).getContent();
    }

}
