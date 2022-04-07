package com.botaniac.accountsservice.dto;

import com.botaniac.accountsservice.validators.UserExists;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {
   // @UserExists
    private String username;
    private String password;
}
