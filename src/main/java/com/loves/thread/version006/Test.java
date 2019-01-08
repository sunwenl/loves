package com.loves.thread.version006;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/6
 * 守护线程
 */
class ThreadDaemon extends  Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=0;i<100;i++){
            System.out.println("子线程的名称："+Thread.currentThread().getName()+",当前"+i);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        ThreadDaemon threadDaemon =new ThreadDaemon();
        //设置为守护线程
        threadDaemon.setDaemon(true);
        threadDaemon.start();

        for (int i=0;i<30;i++){

            System.out.println("main函数执行"+i);
        }
    }
}
