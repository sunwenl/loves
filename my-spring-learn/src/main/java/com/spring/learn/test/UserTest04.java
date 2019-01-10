package com.spring.learn.test;
import com.spring.learn.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 *
 * 基于注解实现  注入
 * @Service 相当于<bean id="userService" class="com.spring.learn.services.UserService"/>
 @Service
 * @Repository 相当于<bean id="userDao" class="com.spring.learn.dao.UserDao" />
 */
public class UserTest04 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext  applicationContext= new ClassPathXmlApplicationContext("/spring-004.xml");
        System.out.println("spring 加载bean");

        //UserService userService= (UserService)applicationContext.getBean("userService");
        //userService.add();

        UserService userService= (UserService)applicationContext.getBean("userService");
        userService.add();
    }
}
