package com.loves.thread.version001;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/3
 *
 * 多线程创建方式一
 * 继承Thread类 重写run()方法
 */
public class MyThread extends Thread{

    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("开始");
        MyThread myThread =new MyThread();
        myThread.start();
        System.out.println("结束");

    }

}
