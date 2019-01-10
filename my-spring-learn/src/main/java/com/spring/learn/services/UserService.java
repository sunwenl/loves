package com.spring.learn.services;

import com.spring.learn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 */
//相当于<bean id="userService" class="com.spring.learn.services.UserService"/>
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    //public void setUserDao(UserDao userDao) {
    //    this.userDao = userDao;
    //}

    public void add(){
        System.out.println("user service add()");
        userDao.add();
    }

    public void add2(){
        System.out.println("user service add222()");
        userDao.add();
    }
}
