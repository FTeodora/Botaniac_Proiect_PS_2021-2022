package com.botaniac.plantsservice.controller.rest;

import com.botaniac.plantsservice.DTO.CreatePlantDTO;
import com.botaniac.plantsservice.DTO.NewPlantsListResponseDTO;
import com.botaniac.plantsservice.fileManagers.readers.CSVPlantReader;
import com.botaniac.plantsservice.model.entity.plants.Plant;
import com.botaniac.plantsservice.service.plantsService.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CreatePlantController {
    @Autowired
    private PlantService plantService=new PlantService();
    List<Plant> csvPlants=null;
    @PostMapping("/plants/uploadPlants")
    public ResponseEntity<NewPlantsListResponseDTO> uploadFile(@RequestParam("file") MultipartFile file) {
        log.info("Received file "+file.getOriginalFilename());
        if (CSVPlantReader.hasCSVFormat(file)) {
            try {
                log.info("Parsing plants");
                this.csvPlants=plantService.parsePlants(file);
                log.info("Plants: "+this.csvPlants);
                return ResponseEntity.status(HttpStatus.OK).
                        body(new NewPlantsListResponseDTO("Uploaded the file successfully: " + file.getOriginalFilename(),this.csvPlants));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).
                body(new NewPlantsListResponseDTO("Could not upload the file: " + file.getOriginalFilename() + "!",this.csvPlants));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                body(new NewPlantsListResponseDTO("Please select a csv file",new ArrayList<>()));
    }
    @PostMapping("/plants/savePlant")
    public String submitPlant(@Valid @ModelAttribute("newPlant") CreatePlantDTO newPlant, BindingResult result){
        log.info("Info submitted. Creating plant "+newPlant.getCommonName()+"...");
        if(!result.hasErrors()){
            log.info("No errors found! Creating plant");
            plantService.addPlant(newPlant);
            return "redirect:http://localhost:8420/plants/plant_types";
        }
        log.error("The data you're attempting to insert is invalid");
        result.getAllErrors().forEach(x->log.warn(x.toString()));
        return "/plants/create_plant_form";
    }
}
