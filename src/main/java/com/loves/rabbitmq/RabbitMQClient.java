package com.loves.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQClient {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public  void sendMessages(String messages){
        rabbitTemplate.convertAndSend("myQueue", messages);

    }
}
