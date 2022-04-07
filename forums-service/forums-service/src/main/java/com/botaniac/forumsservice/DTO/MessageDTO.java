package com.botaniac.forumsservice.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Long id;
    private String content;
    private String poster;
    @Getter(AccessLevel.NONE)
    private LocalDateTime datePosted;
    public String getDatePosted(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return this.datePosted.format(formatter);
    }
}
