package com.loves.thread.version001;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/3
 *
 * 实现Runnable类 重写run()方法
 */
public class MyRunnable implements Runnable {
    public void run() {
        for(int i=0;i<20;i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        System.out.println("开始");
        MyRunnable myRunnable =new MyRunnable();
        Thread thread= new Thread(myRunnable);
        thread.start();
        System.out.println("结束");

    }

}
