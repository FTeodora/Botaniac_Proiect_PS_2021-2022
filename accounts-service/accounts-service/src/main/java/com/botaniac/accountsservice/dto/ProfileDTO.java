package com.botaniac.accountsservice.dto;

import com.botaniac.accountsservice.model.enums.UserRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
public class ProfileDTO {
    public String username;
    public String email;
    public String birthday;
    @Getter(AccessLevel.NONE)

   // public LocalDateTime joinedAt;
    public UserRole userRole;
    //public String getJoinedAt(){
   //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
   //     return joinedAt.format(formatter);
  //  }
    public LocalDate bringBirthday(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            return LocalDate.parse(birthday, formatter);
        }catch (Exception e){
            return null;
        }
    }
}
