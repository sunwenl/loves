package com.loves.thread.version007;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * newFixedThreadPool线程池 可定长的线程池
 */
public class newFixedThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService e1=Executors.newFixedThreadPool(3);//每次只会创建3个线程  多余的等待
        for (int i=0;i<10;i++){
            int j = i;
            e1.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"---"+j);
                    if(j==9){
                        e1.shutdown();
                    }
                }
            });
        }
    }
}
