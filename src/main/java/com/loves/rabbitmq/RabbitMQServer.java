package com.loves.rabbitmq;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQServer {

    @RabbitListener(queues = "myQuery")
    public void receive(String messages){
        System.out.println("收到的消息是" + messages);
    }

}
