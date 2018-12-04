package com.loves.ioc.version002;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class School {
    public static void main(String[] args) {

        //从容器中取回的对象默认是单例的：
        //IoC容器
        ApplicationContext ctx=
                new ClassPathXmlApplicationContext("ioc/version002/beans01.xml","ioc/version002/beans02.xml");
        //从容器中获取对象
        Person tom=ctx.getBean("tom",Person.class);
        Person tom2=ctx.getBean("tom",Person.class);

        System.out.println(tom == tom2);
    }
}
