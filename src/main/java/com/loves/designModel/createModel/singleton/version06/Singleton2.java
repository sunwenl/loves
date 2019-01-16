package com.loves.designModel.createModel.singleton.version06;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/13
 *
 * 饿汉式 单例
 */
public class Singleton2 {
    private static final Singleton2 SINGLETON_2 = new Singleton2();
    private Singleton2(){}
    public static Singleton2  getSingleton2(){
        return SINGLETON_2;
    }
}
class MyThread2 extends Thread{
    public void run() {
        for (int i=0;i<100;i++){
            Singleton2 singleton = Singleton2.getSingleton2();
            System.out.println("当前线程:"+Thread.currentThread().getName()+"---"+singleton);
        }
    }
}
class MainTest2{
    public static void main(String[] args) {
        MyThread2 [] myThreads = new MyThread2[10];
        for (int i=0;i<myThreads.length;i++){
            myThreads[i] = new MyThread2();
            myThreads[i].start();
        }
    }
}
