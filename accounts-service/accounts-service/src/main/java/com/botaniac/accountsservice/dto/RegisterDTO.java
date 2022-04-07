package com.botaniac.accountsservice.dto;


import com.botaniac.accountsservice.model.entity.User;
import javax.validation.constraints.*;

import com.botaniac.accountsservice.validators.MatchPassword;
import com.botaniac.accountsservice.validators.UniqueMail;
import com.botaniac.accountsservice.validators.UniqueUsername;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class RegisterDTO {
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private ModelMapper modelMapper=new ModelMapper();
    @NotBlank(message="Please pick an username")
    @Size(min=5, max=20,message = "Username must have between 5 and 20 characters")
    //@UniqueUsername
    private String username;
   // @UniqueMail
    @NotBlank(message = "e-mail field is mandatory")
    @Pattern(regexp="^[^0-9]+[0-9]*([.|-|_][\\w]+)*@[\\w]+(-[\\w]+)*[.][\\w]+", message="Please provide a valid email address")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    @Size(min=5, max=24,message = "Password must have between 5 and 24 characters")
    private String password;
    //private String confirmPassword;
    @Setter(AccessLevel.NONE)
    @Past(message = "Are you a time traveler?")
    private LocalDate birthday;
    public void setBirthday(String birthday){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try{
            this.birthday=LocalDate.parse(birthday, formatter);
        }catch (Exception e){
            this.birthday=null;
        }
    }
    public User toUser(){
        return modelMapper.map(this,User.class);
    }
}
