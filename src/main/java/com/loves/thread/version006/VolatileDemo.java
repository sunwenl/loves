package com.loves.thread.version006;

class VolatileThread extends Thread{
    public static volatile boolean flag = true;
    @Override
    public void run() {
        System.out.println("子线程开始");
        int i=0;
        while(flag){
            //System.out.println("子线程执行中"+i);
            //i++;
        }
    }
    public void isRun(boolean flag){
        this.flag  = flag;
        System.out.println("子线程结束");
    }
}

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * Volatile 关键字的作用是变量在多个线程之间可见。
 */
public class VolatileDemo {
    public static void main(String[] args) throws  Exception{
        VolatileThread v1 = new VolatileThread();
        v1.start();
        Thread.sleep(300);
        v1.isRun(false);
        System.out.println("flag:"+v1.flag);

        //已经将结果设置为fasle为什么？还一直在运行呢。
        //原因:线程之间是不可见的，读取的是副本，没有及时读取到主内存结果。
        //解决办法使用Volatile关键字将解决线程之间可见性, 强制线程每次读取该值的时候都去“主内存”中取值

    }
}
