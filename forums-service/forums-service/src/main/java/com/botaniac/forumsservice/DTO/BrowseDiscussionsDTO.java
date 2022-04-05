package com.botaniac.forumsservice.DTO;

import com.botaniac.forumsservice.model.entity.Discussion;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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
    private Long discussionId;
    private String title;
    private Boolean isLocked;
    private LocalDateTime dateAdded;
    public Discussion toDiscussion(){
        return modelMapper.map(this,Discussion.class);
    }
}
