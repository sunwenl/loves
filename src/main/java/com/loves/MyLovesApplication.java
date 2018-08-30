package com.loves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class MyLovesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyLovesApplication.class, args);
    }

}
