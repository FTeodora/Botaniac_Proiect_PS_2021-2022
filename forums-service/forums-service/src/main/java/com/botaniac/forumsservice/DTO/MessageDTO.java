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
    public LocalDateTime getDatePosted(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy at HH:mm");
        return LocalDateTime.parse(this.datePosted.toString(), formatter);
    }
}
