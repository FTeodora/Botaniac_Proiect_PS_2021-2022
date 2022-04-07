package com.botaniac.forumsservice.factories;

import com.botaniac.forumsservice.DTO.NewMessageDTO;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.entity.Message;
import com.botaniac.forumsservice.repository.DiscussionRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class MessageFactory {
    /**
     * Creates a new message to be inserted in the db having a dummy user ID as default
     * @param messageDTO the message info from the front end form
     * @return a Message class entity with "0" as poster ID
     */
    public static Message createDummyMessage(Discussion discussion,NewMessageDTO messageDTO){
    ModelMapper modelMapper=new ModelMapper();
    Message message=modelMapper.map(messageDTO,Message.class).toBuilder().poster("0").build();
    discussion.getMessages().add(message);
    message.setParentDiscussion(discussion);
    return message;
    }
}
