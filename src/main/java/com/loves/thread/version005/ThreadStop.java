package com.loves.thread.version005;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/6
 */
public class ThreadStop extends Thread{
    public boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println("子线程,当前线程名称"+Thread.currentThread().getName());
        }
    }
}
