package com.botaniac.emailservice;

import com.botaniac.emailservice.model.BasicEmail;
import com.botaniac.emailservice.model.MailTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Slf4j
public class RabbitConsumer {
    @Autowired
    BasicEmail basicEmail;
    @RabbitListener(queues = "${myqueue.rabbitmq.queue}")
    public void receiveMessage(MailTemplate template) {
        ObjectMapper objectMapper=new ObjectMapper();
        log.info("Sending message to: "+template.getRecipient()+" with template from "+template.getTemplatePath());
        try{
            basicEmail.send(template);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Bean
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

}
