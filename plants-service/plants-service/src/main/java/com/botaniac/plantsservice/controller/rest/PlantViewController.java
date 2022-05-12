package com.botaniac.plantsservice.controller.rest;

import com.botaniac.plantsservice.DTO.PlantPageDTO;
import com.botaniac.plantsservice.service.plantsService.PlantService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@Slf4j
public class PlantViewController {
    @Autowired
    private ServletContext servletContext;
    @Autowired
    PlantService plantService;
    @GetMapping("/plants/generateTxt")
    public ResponseEntity<InputStreamResource> makeTxt(HttpServletResponse response, @ModelAttribute("plant")PlantPageDTO plant){
        log.info("Generating file in "+plant.getFileType());

        File f=plantService.generateTxt(plant);
        String mimeType = servletContext.getMimeType(f.getName());
        MediaType mediaType;
        log.info("type: "+mimeType);
        try {
            mediaType = MediaType.parseMediaType(mimeType);
        } catch (Exception e) {
            mediaType= MediaType.APPLICATION_OCTET_STREAM;
        }
        InputStreamResource resource=null;
        try{
            resource = new InputStreamResource(new FileInputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + f.getName())
                .contentType(mediaType)
                .contentLength(f.length())
                .body(resource);
    }


}
