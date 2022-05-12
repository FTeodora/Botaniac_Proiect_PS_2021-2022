package com.botaniac.forumsservice.DTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForumPosterDTO {
    private String username;
    private String role;
    public ForumPosterDTO toPosters(String src){
        ObjectMapper objectMapper=new ObjectMapper();

        try{
            objectMapper.readValue(src,ForumPosterDTO.class);
            return objectMapper.readValue(src,ForumPosterDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
