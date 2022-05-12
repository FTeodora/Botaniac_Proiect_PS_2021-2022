package com.botaniac.plantsservice.DTO;

import com.botaniac.plantsservice.fileManagers.writers.FileGenerator;
import com.botaniac.plantsservice.fileManagers.writers.PlantPDFGenerator;
import com.botaniac.plantsservice.fileManagers.writers.PlantTxtGenerator;
import com.botaniac.plantsservice.model.entity.plants.Plant;
import com.botaniac.plantsservice.model.entity.plants.PlantRequirements;
import com.botaniac.plantsservice.model.enums.PlantType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.FileWriter;
import java.lang.reflect.Type;

@Getter
@Setter
@NoArgsConstructor
public class PlantPageDTO {
    private String id;
    private String commonName;
    private String scientificName;
    private String description;
    private String nativeContinent;
    private PlantType type;
   private PlantRequirements requirements;
   private FileType fileType;
    @Override
    public String toString() {
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    public FileGenerator<PlantPageDTO> generateWriter(){
        if(fileType.equals(FileType.TXT))
            return new PlantTxtGenerator();
        return new PlantPDFGenerator();
    }
}
