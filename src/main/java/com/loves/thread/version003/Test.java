package com.loves.thread.version003;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/4
 */
public class Test {
    //案例:需求现在有200张火车票，有两个窗口同时抢火车票，
    // 请使用多线程模拟抢票效果

    public static void main(String[] args) throws  Exception{
        System.out.println("抢票开始");
        ticket();
        System.out.println("抢票结束");
    }

    static void ticket() throws  Exception{
        ThreadTrain1 threadTrain = new ThreadTrain1();
        Thread thread = new Thread(threadTrain);
        thread.setName("窗口001");
        thread.start();

        Thread thread2 = new Thread(threadTrain);
        thread2.setName("窗口002");
        thread2.start();
    }
}
