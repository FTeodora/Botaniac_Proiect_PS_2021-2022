package com.botaniac.forumsservice.DTO;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class OriginalPostDTO {
    private Long id;
    private String title;
    private String textContent;
    private String author;
    @Getter(AccessLevel.NONE)
    private LocalDateTime dateAdded;
    public LocalDateTime getDateAdded(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy at HH:mm");
        return LocalDateTime.parse(this.dateAdded.toString(), formatter);
    }
}
