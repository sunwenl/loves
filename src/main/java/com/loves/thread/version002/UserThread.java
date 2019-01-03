package com.loves.thread.version002;

import java.util.List;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/3
 */
public class UserThread extends Thread{
    private List<User> list ;
    public UserThread(List<User> list){
        this.list= list;
    }
    @Override
    public void run() {
        for (User user : list){
            System.out.println("threadName:" + Thread.currentThread().getName()+"\n \t 发送学员信息："+"学员Id:"+user.getId()+",学员name:"+user.getName());
        }
    }
}