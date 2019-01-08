package com.loves.thread.version005;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/6
 *
 * 线程停止
 */
public class Test {
    public static void main(String[] args) {
        ThreadStop threadStop1 = new ThreadStop();
        threadStop1.setName("线程11111");
        threadStop1.start();
        ThreadStop threadStop2 = new ThreadStop();
        threadStop2.setName("线程22222");
        threadStop2.start();
        for (int i=0;i<30;i++){
            System.out.println("mian  线程----");
            if(i == 28){
                threadStop1.flag =false;
                threadStop2.flag =false;
                System.out.println("线程终止");
            }
        }
    }
}
