package com.spring.learn.mySpring;

import com.spring.learn.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/9
 * spring 读取xml配置文件  加载bean
 */
public class Test {
    /**
     * spring 自己实现
     */
    public static void main(String[] args) throws  Exception{
        ClassPathXmlApplicationContext clazz = new ClassPathXmlApplicationContext("/spring-006.xml");
        User user = (User)clazz.getBean("user1");
        System.out.println(user.toString());
    }

    //手写spring bean xml实现
    //public static void main(String[] args) throws  Exception{
    //    MyClassPathXmlApplicationContext2 myClazz = new MyClassPathXmlApplicationContext2("spring-006.xml");
    //    User user = (User)myClazz.getBean("user2");
    //    System.out.println(user.toString());
    //}

}
