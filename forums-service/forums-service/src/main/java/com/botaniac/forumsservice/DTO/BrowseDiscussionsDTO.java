package com.botaniac.forumsservice.DTO;

import com.botaniac.forumsservice.model.entity.Discussion;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrowseDiscussionsDTO {
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();
    private Long id;
    private String title;
    private Boolean isLocked;
    @Getter(AccessLevel.NONE)
    private LocalDateTime dateAdded;
    public Discussion toDiscussion(){
        return modelMapper.map(this,Discussion.class);
    }
    public String getDateAdded(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy, HH:mm");
        return this.dateAdded.format(formatter);
    }
}
