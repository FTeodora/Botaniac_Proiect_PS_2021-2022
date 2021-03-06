package com.botaniac.plantsservice.DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ViewPlantDTO {
    private String id;
    private String commonName;
    private String scientificName;

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
