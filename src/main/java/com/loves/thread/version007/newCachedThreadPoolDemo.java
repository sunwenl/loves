package com.loves.thread.version007;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * newCachedThreadPool创建线程池的 实例
 * newCachedThreadPool
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
 * 总结: 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 */
public class newCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i<10; i++){
            final int i1 =i;//1.8以后 final就可以省略 只要下面不再出现i1++这种操作
            ex.execute(new Runnable() {//创建一个线程  并执行 start();
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"----"+ i1);
                    if(i1 == 9){
                        //关闭线程
                        ex.shutdown();
                    }
                }
            });
        }

    }
}
