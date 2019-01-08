package com.loves.thread.version006;

import java.util.concurrent.atomic.AtomicInteger;

class AtomicIntegerThread extends Thread{
    private static volatile int count =0;

    private static AtomicInteger a1=new AtomicInteger(0);
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            count++;
            a1.incrementAndGet();
        }
        System.out.println(getName()+"--11111--"+a1);
        //System.out.println(getName()+"--22222--"+count);
    }
}

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * Volatile不用具备原子性
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicIntegerThread[] a1s = new AtomicIntegerThread[10];
        for (int i=0;i<a1s.length;i++){
            a1s[i]= new AtomicIntegerThread();
        }
        for (int i=0;i<a1s.length;i++){
            a1s[i].start();
        }
    }
}
