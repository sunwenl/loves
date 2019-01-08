package com.loves.thread.version007;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * newSingleThreadExecutor 线程池
 */
public class newSingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService e1= Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){
            int j=i;
            e1.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"---"+j);
                }
            });
        }
    }
}
