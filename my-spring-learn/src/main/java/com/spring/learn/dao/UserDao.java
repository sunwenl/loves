package com.spring.learn.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 */
//相当于 <bean id="userDao" class="com.spring.learn.dao.UserDao" />
@Repository
public class UserDao {
    public void add(){
        System.out.println("user dao add");
    }
}
