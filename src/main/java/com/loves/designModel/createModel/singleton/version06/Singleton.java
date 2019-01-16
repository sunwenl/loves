package com.loves.designModel.createModel.singleton.version06;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/13
 *
 * 懒汉式设计模式
 */
public class Singleton {
    private Singleton(){}
    private static Singleton singleton;
    public static Singleton getSingleton(){
        if (singleton == null){
            synchronized (Singleton.class){
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
class MyThread extends Thread{
    public void run() {
        for (int i=0;i<100;i++){
            Singleton singleton = Singleton.getSingleton();
            System.out.println("当前线程:"+Thread.currentThread().getName()+"---"+singleton);
        }
    }
}
class MainTest{
    public static void main(String[] args) {
        MyThread [] myThreads = new MyThread[10];
        for (int i=0;i<myThreads.length;i++){
            myThreads[i] = new MyThread();
            myThreads[i].start();
        }
    }
}
