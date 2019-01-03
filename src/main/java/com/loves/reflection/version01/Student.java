package com.loves.reflection.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/26
 *
 * 自定义学生类
 */
public class Student {

    public  Student(){
        System.err.println("*******学生被初始化*******");
    }


    @Override
    public String toString() {
        System.err.println("*******学生的toString方法*******");
        return super.toString();
    }
}
