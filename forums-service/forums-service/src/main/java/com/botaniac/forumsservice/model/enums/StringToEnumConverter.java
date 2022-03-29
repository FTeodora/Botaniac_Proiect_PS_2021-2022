package com.botaniac.forumsservice.model.enums;

import org.springframework.core.convert.converter.Converter;
public class StringToEnumConverter implements Converter<String, ForumSection> {
    @Override
    public ForumSection convert(String source) {
        return ForumSection.valueOf(source.toUpperCase());
    }
}