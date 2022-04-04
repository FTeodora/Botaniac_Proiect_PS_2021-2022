package com.botaniac.accountsservice.dto;


import com.botaniac.accountsservice.model.entity.User;
import javax.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class RegisterDTO {
    @NotBlank(message="Please pick an username")
    @Size(min=5, max=20,message = "Username must have between 5 and 20 characters")
    private String username;
    @NotBlank(message = "e-mail field is mandatory")
    @Pattern(regexp="^[^0-9]+[0-9]*([.|-|_][\\w]+)*@[\\w]+(-[\\w]+)*[.][\\w]+", message="Please provide a valid email address")
    private String email;
    @NotBlank(message = "Password cannot be empty")
    @Size(min=5, max=24,message = "Password must have between 5 and 24 characters")
    private String password;

    private String confirmPassword;
    private String birthday;
    public User toUser(){
        return User.builder().username(this.username).password(this.password).
                email(this.email).birthday(toDate()).build();
    }
    private LocalDate toDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        @Past LocalDate date=LocalDate.parse(this.birthday, formatter);
        return date;
    }
}
