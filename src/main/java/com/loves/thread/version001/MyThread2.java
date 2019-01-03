package com.loves.thread.version001;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/3
 * 多线程创建方式三：
 * 匿名内部类
 */
public class MyThread2 {
    public static void main(String[] args) {
        System.out.println("开始");
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<20;i++){
                    System.out.println(i);
                }
            }
        });
        thread.start();
        System.out.println("结束");
    }
}
