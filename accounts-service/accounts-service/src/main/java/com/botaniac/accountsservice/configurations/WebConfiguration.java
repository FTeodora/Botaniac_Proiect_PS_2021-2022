package com.botaniac.accountsservice.configurations;

import com.botaniac.accountsservice.validators.UniqueEmailValidator;
import com.botaniac.accountsservice.validators.UniqueUsernameValidator;
import com.botaniac.accountsservice.validators.UserExists;
import com.botaniac.accountsservice.validators.UserExistsValidator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@Configuration
@EnableSpringConfigured
public class WebConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
