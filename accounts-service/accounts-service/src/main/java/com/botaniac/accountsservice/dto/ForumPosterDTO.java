package com.botaniac.accountsservice.dto;

import com.botaniac.accountsservice.model.entity.User;
import com.botaniac.accountsservice.model.enums.UserRole;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ForumPosterDTO {
    private String username;
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private String role;
    public ForumPosterDTO(User user){
        this.role=user.getRole().toString();
        this.username=user.getUsername();
    }
    public void setRole(UserRole role){
        this.role=role.toString();
    }
    public void setRole(String role){
        this.role=role;
    }
    public String getRole(){ return this.role;}
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
