package com.loves.thread.version003;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/4
 */
public class ThreadTrain implements Runnable {
    //出售100张火车票
    private static volatile int trainCount = 200;
    private Object object = new Object();

    @Override
    public void run() {
        while (trainCount > 0) {
            try {
                //休息一会
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //原始写法
            System.out.println("当前线程名称："+Thread.currentThread().getName()+
                    ",正在出售第"+(200-trainCount+1)+"张火车票");
            trainCount--;

            //第一种解决方案：同步代码块
            synchronized (object) {
                System.out.println("当前线程名称：" + Thread.currentThread().getName() +
                        ",正在出售第" + (200 - trainCount + 1) + "张火车票");
                trainCount--;
            }

            //第三种写法   同步函数  同步方法
            show();
        }
    }

    //第三种写法   同步函数  同步方法
    public static synchronized void show() {
        try {
            //休息一会
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名称：" + Thread.currentThread().getName() +
                ",正在出售第" + (200 - trainCount + 1) + "张火车票");
        trainCount--;
    }
}
