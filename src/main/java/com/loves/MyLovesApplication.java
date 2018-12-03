package com.loves;

import com.loves.rabbitmq.RabbitMQClient;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.StopWatch;
import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableAsync
public class MyLovesApplication{

    @Autowired
    private RabbitMQClient rabbitMQClient;

    public static void main(String[] args) {
        SpringApplication.run(MyLovesApplication.class, args);
    }

    @Bean
    public Queue regQueue(){
        return new Queue("myQueue");
    }

    @PostConstruct
    public void init(){
        StopWatch stopwatch=new StopWatch();
        stopwatch.start();

        for(int i=0;i<1000;i++){
            rabbitMQClient.sendMessages("发送消息----myQueue---第"+i+"个消息了");
        }
        stopwatch.stop();

        System.out.println("发送消息耗时:"+stopwatch.getTotalTimeMillis());
    }
}
