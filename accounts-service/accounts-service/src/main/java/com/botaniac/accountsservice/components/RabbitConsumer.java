package com.botaniac.accountsservice.components;

import com.botaniac.accountsservice.dto.ForumPosterDTO;
import com.botaniac.accountsservice.repository.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RabbitConsumer {
    @Autowired
    UserRepo repo;
    @Autowired
    ModelMapper modelMapper;
    @RabbitListener(queues = "${myqueue.rabbitmq.queue}")
    public String receiveMessage(Set<String> ids) {
        log.info("Recieved Message From RabbitMQ: " + ids);
        HashMap<String,ForumPosterDTO> l=new HashMap<>();
         ids.forEach(id->l.put(id,new ForumPosterDTO(repo.findById(id).get())));
         try{
             ObjectMapper objectMapper=new ObjectMapper();
             return objectMapper.writeValueAsString(l);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        return null;
    }

}
