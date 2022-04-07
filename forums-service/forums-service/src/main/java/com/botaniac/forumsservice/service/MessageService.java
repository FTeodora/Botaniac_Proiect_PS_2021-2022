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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class MessageService {
    private final int MAX_MESSAGES=10;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    private ModelMapper modelMapper=new ModelMapper();

    /**
     * Gets a chunk of 10 messages from a specified discussion, starting from a certain page
     * @param discussion
     * @param offset
     * @return
     */
    public List<MessageDTO> getDiscussionMessages(Discussion discussion,int offset){
        return messageRepository.findByParentDiscussion(discussion, PageRequest.of(offset,MAX_MESSAGES, Sort.by("datePosted").descending())).
                getContent().stream().map(x->modelMapper.map(x, MessageDTO.class)).collect(Collectors.toList());
    }

    /**
     * Gets all the pages starting from a specified offset
     * @param discussion
     * @param offset
     * @return
     */
    public Page<MessageDTO> getDiscussionMessagesByPage(Discussion discussion,int offset){
        Page<Message> entities = messageRepository.findByParentDiscussion(discussion, PageRequest.of(0,MAX_MESSAGES, Sort.by("datePosted").descending()));
        Page<MessageDTO> dtoPage = entities.map(obj -> {
            return modelMapper.map(obj,MessageDTO.class);
        });
        return dtoPage;
    }
    public void postNewMessage(Discussion parent,NewMessageDTO messageDTO){
        messageRepository.save(MessageFactory.createDummyMessage(parent,messageDTO));
    }
}
