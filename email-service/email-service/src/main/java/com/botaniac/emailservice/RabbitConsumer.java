package com.botaniac.emailservice;

import com.botaniac.emailservice.model.BasicEmail;
import com.botaniac.emailservice.model.MailTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
@Slf4j
public class RabbitConsumer {
    @Value("${mytoken.hardcoded.beloved.token}")
    String accountsToken;
    @Autowired
    BasicEmail basicEmail;
    @RabbitListener(queues = "${myqueue.rabbitmq.queue}")
    public void receiveMessage(MailTemplate template, @Header("Authorisation")String token) {
        log.info("Checking if "+token+" and "+accountsToken+" match");
        if(token!=null&&token.equals(accountsToken)){
            ObjectMapper objectMapper=new ObjectMapper();
            log.info("Sending message to: "+template.getRecipient()+" with template from "+template.getTemplatePath());
            try{
                basicEmail.send(template);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else log.info("Authorization failed");
    }
    @Bean
    public Jackson2JsonMessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

}
