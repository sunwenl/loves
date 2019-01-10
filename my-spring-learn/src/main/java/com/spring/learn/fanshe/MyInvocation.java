package com.spring.learn.fanshe;

import com.spring.learn.bean.User;

import java.lang.reflect.Constructor;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/9
 */
public class MyInvocation {
    public static void main(String[] args) throws  Exception{
        Class clazz= Class.forName("com.spring.learn.bean.User");
        // 创建此Class 对象所表示的类的一个新实例 调用了User的无参数构造方法.
        User user= (User)clazz.newInstance();
        System.out.println("user--"+user);

        Constructor constructor = clazz.getConstructor(int.class,String.class);
        User user2= (User)constructor.newInstance(12,"速度速度");
        System.out.println(user2.toString());

    }
}
