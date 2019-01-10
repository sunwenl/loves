package com.spring.learn.test;
import com.spring.learn.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 */
public class UserTest01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext  applicationContext= new ClassPathXmlApplicationContext("/spring-002.xml");
        System.out.println("spring 加载bean");

        //UserService userService= (UserService)applicationContext.getBean("userService");
        //userService.add();

        UserService userService= (UserService)applicationContext.getBean("userService2");
        userService.add();
    }
}
