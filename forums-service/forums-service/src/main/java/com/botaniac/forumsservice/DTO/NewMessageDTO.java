package com.botaniac.forumsservice.DTO;

import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.entity.Message;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Size;

@Setter
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class NewMessageDTO {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Autowired
    ModelMapper modelMapper;
    @Size(min=5,message = "Message must have at least 5 characters")
    private String content;
    private String poster;
    @Getter(AccessLevel.NONE)
    private Long parentDiscussion;
    public Discussion getParentDiscussion(){
        return Discussion.builder().id(parentDiscussion).build();
    }
    public Message toMessage(){
        return modelMapper.map(this,Message.class);
    }

}
