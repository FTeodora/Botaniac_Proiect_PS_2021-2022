package com.botaniac.forumsservice.configurations;

import com.botaniac.forumsservice.model.enums.StringToEnumConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToEnumConverter());
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}