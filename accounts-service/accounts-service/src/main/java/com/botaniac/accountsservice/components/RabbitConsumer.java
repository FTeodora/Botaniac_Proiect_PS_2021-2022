package com.botaniac.accountsservice.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitConsumer {
    @RabbitListener(queues = "${myqueue.rabbitmq.queue}")
    public void receiveMessage(String id) {
        log.info("Recieved Message From RabbitMQ: " + id);
    }
}
