package com.botaniac.plantsservice.DTO;

import com.botaniac.plantsservice.model.entity.plants.PlantRequirements;
import com.botaniac.plantsservice.model.enums.PlantType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CreatePlantDTO {
    @NotBlank
    private String scientificName;
    @NotBlank
    private String commonName;
    private String description;
    @Getter(AccessLevel.NONE)
    private String nativeContinent;
    private PlantType type;
    private PlantRequirements requirements;
    public String getNativeContinent(){
        if(nativeContinent==null)
            return "N/A";
        return nativeContinent;
    }
    @Override
    public String toString() {
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
