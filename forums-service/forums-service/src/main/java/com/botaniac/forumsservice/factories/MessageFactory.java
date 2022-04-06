package com.botaniac.forumsservice.factories;

import com.botaniac.forumsservice.DTO.NewMessageDTO;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.entity.Message;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Slf4j
public class MessageFactory {
    /**
     * Creates a new message to be inserted in the db having a dummy user ID as default
     * @param messageDTO the message info from the front end form
     * @return a Message class entity with "0" as poster ID
     */
    public static Message createDummyMessage(Long discussionID,NewMessageDTO messageDTO){
    ModelMapper modelMapper=new ModelMapper();
    messageDTO.setParentDiscussion(discussionID);
    return modelMapper.map(messageDTO,Message.class).toBuilder().poster("0").build();
    }
}
