package com.spring.learn.factory;

import com.spring.learn.bean.User;
import org.apache.poi.ss.formula.functions.T;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 */
public class ObjectFactory {
    public User getUser(){
        return new  User(1,"暗示法");
    }

    public static User getStaticUser(){
        return new  User(1,"暗示法ghjkl");
    }
}
