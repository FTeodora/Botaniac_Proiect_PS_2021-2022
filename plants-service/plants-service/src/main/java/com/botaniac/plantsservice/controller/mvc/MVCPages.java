package com.botaniac.plantsservice.controller.mvc;

import com.botaniac.plantsservice.DTO.CreatePlantDTO;
import com.botaniac.plantsservice.DTO.PlantPageDTO;
import com.botaniac.plantsservice.DTO.ViewPlantDTO;
import com.botaniac.plantsservice.model.enums.PlantType;
import com.botaniac.plantsservice.service.plantsService.PlantService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class MVCPages {
    @Autowired
    PlantService plantService=new PlantService();
    @Autowired
    ModelMapper modelMapper;
    @GetMapping("/plants")
    public WebMvcProperties.View viewPlants(){
        log.info("I have reached the plants");
        return new WebMvcProperties.View();
    }
    @GetMapping("/plants/plant_types")
    public WebMvcProperties.View browsePlants(){
        log.info("Fetching plants page ");
        ModelAndView mav=new ModelAndView();
        int totalPages=plantService.browsePlants(0).getTotalPages();
        log.info("Total pages: "+totalPages);
        mav.addObject("totalPages",totalPages);
        return new WebMvcProperties.View();
    }
    @GetMapping("/plants/create_plant_form")
    public ModelAndView bringCreatePage(){
        log.info("Getting the plant creation by form page...");
        ModelAndView mav=new ModelAndView();
        mav.addObject("newPlant",new CreatePlantDTO());
        //mav.addObject("plantTypes", PlantType.values());
        return mav;
    }
    @GetMapping("/plants/create_plant_csv")
    public ModelAndView bringCreateCSVPage(){
        log.info("Getting the plant creation by form page...");
        ModelAndView mav=new ModelAndView();
        return mav;
    }
    @GetMapping("/plants/plant_page")
    public ModelAndView getPlantPage(@RequestParam String plantID){
        ModelAndView mav=new ModelAndView();
        mav.addObject("plant",modelMapper.map(plantService.getPlant(plantID), PlantPageDTO.class));
        return mav;
    }


}
