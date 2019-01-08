package com.loves.thread.version006;


class ThreadPriority extends  Thread{
    @Override
    public void run() {
        for(int i=0;i<30;i++){
            System.out.println("子线程执行---"+i+",当前线程名称是："+Thread.currentThread().getName());
        }
    }
}

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * 一、	优先级
 *   现代操作系统基本采用时分的形式调度运行的线程，线程分配得到的时间片的多少决定了线程使用处理器资源的多少，
 *   也对应了线程优先级这个概念。在JAVA线程中，通过一个int priority来控制优先级，范围为1-10，其中10最高，默认值为5
 */
public class TestPriority {
    public static void main(String[] args) {
        ThreadPriority th1 = new ThreadPriority();
        th1.setName("线程AAAAA");
        ThreadPriority th2= new ThreadPriority();
        th2.setName("线程BBBBB");

        // 注意设置了优先级， 不代表每次都一定会被执行。 只是CPU调度会有限分配
        th1.setPriority(1);
        th2.setPriority(10);
        //如果我们把优先级设置近点的话，发现优先级较高的线程不一定没一次都执行完，
        // 线程的优先级与打印的顺序无关，不要将这两点的关系相关联，他们的关系是不确定性和随机性。
        //
        //线程的优先级仍然无法保障线程的执行次序。只不过，优先级高的线程获取CPU资源的概率较大，优先级低的并非没机会执行。
        //
        //
        //线程的优先级具有继承性，比如A线程启动B线程，则A和B的线程优先级是一样的。

        th1.start();
        th2.start();

        //一、	Yield方法
        //
        //Thread.yield()方法的作用：暂停当前正在执行的线程，并执行其他线程。（可能没有效果）
        //yield()让当前正在运行的线程回到可运行状态，以允许具有相同优先级的其他线程获得运行的机会。
        // 因此，使用yield()的目的是让具有相同优先级的线程之间能够适当的轮换执行。
        // 但是，实际中无法保证yield()达到让步的目的，因为，让步的线程可能被线程调度程序再次选中。
        //结论：大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果。
    }
}
