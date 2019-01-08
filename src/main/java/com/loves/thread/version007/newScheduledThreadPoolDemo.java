package com.loves.thread.version007;

import sun.plugin2.message.GetNameSpaceMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * newScheduledThreadPool线程池 定时的线程池
 */
public class newScheduledThreadPoolDemo {
    public static void main(String[] args) {
        //声明3个线程
        ScheduledExecutorService s1= Executors.newScheduledThreadPool(3);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //for (int i=0;i<10;i++){
            System.out.println("当前时间："+df.format(new Date()));
            int j = 1;
            s1.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行线程前的时间为："+df.format(new Date()));
                    System.out.println(Thread.currentThread().getName()+"子线程执行---"+j);
                }
            },3, TimeUnit.SECONDS);
        //}
    }
}
