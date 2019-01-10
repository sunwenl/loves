package com.spring.learn.test;
import com.spring.learn.bean.User;
import com.spring.learn.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 */
public class UserTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext  applicationContext= new ClassPathXmlApplicationContext("/spring-001.xml");

        System.out.println("spring 加载bean");

        //User user1= (User)applicationContext.getBean("user");
        //User user2= (User)applicationContext.getBean("user");
        ////证明spring加载bean默认是单利的(节约jvm内存)，线程不安全
        //System.out.println(user1==user2);

        //// <!--调用有参构造函数-->
        //User user1= (User)applicationContext.getBean("user1");
        //System.out.println(user1.toString());

        //<!-- 通过实例工厂方法创建 -->
        User user1= (User)applicationContext.getBean("user2");
        System.out.println(user1.toString());

        //<!-- 通过静态工厂方法创建 -->
        User user3= (User)applicationContext.getBean("user3");
        System.out.println(user3.toString());
    }
}
