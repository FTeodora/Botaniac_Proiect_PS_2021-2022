package com.botaniac.forumsservice.service;

import com.botaniac.forumsservice.DTO.BrowseDiscussionsDTO;
import com.botaniac.forumsservice.DTO.MessageDTO;
import com.botaniac.forumsservice.DTO.NewMessageDTO;
import com.botaniac.forumsservice.factories.MessageFactory;
import com.botaniac.forumsservice.model.entity.Discussion;
import com.botaniac.forumsservice.model.entity.Message;
import com.botaniac.forumsservice.repository.MessageRepository;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class MessageService {
    private final int MAX_MESSAGES=20;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();
    public List<MessageDTO> getDiscussionMessages(Long discussionID,int offset){
        Discussion discussion=Discussion.builder().id(discussionID).build();
        return messageRepository.findByParentDiscussion(discussion, PageRequest.of(offset,MAX_MESSAGES)).
                getContent().stream().map(x->modelMapper.map(x, MessageDTO.class)).collect(Collectors.toList());
    }
    public Page<MessageDTO> getDiscussionMessagesByPage(Long discussionID,int offset){
        Discussion discussion=Discussion.builder().id(discussionID).build();
        Page<Message> entities = messageRepository.findByParentDiscussion(discussion, PageRequest.of(0,MAX_MESSAGES));
        Page<MessageDTO> dtoPage = entities.map(obj -> {
            return modelMapper.map(obj,MessageDTO.class);
        });
        return dtoPage;
    }
    public void postNewMessage(Long discussionID,NewMessageDTO messageDTO){
        messageRepository.save(MessageFactory.createDummyMessage(discussionID,messageDTO));
    }
}
