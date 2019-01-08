package com.loves.thread.version006;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadJoin extends Thread {
    @Override
    public void run() {
        try {
            //1：让main线程先执行
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 30; i++) {
            System.out.println("子线程执行---" + i);
        }
    }
}

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * join作用是让其他线程变为等待
 */
public class TestJoin {

    /**
     * 创建一个线程，子线程执行完毕后，主线程才能执行
     */
    //public static void main(String[] args) throws Exception {
    //    //ThreadJoin threadJoin = new ThreadJoin();
    //    //threadJoin.start();
    //    //
    //    //threadJoin.join();//2：让子线程先执行
    //    //
    //    //for (int i=0;i<10;i++){
    //    //    System.out.println("main线程---"+i);
    //    //}
    //
    //    Integer a = 12, b = 29;
    //    System.out.println("a=" + a + ",b=" + b);
    //    swap(a, b);
    //    System.out.println("a=" + a + ",b=" + b);
    //}
    //static void swap(Integer a, Integer b) throws Exception {
    //    Field filed = Integer.class.getDeclaredField("value");
    //    filed.setAccessible(true);
    //    Integer c= new Integer(a);
    //    filed.set(a,b);
    //    filed.set(b,c);
    //}

    //使list插入排序
    private static List list = new ArrayList();
    public static void main(String[] args) {
        for (int i=10;i>0;i--){
            addList(i);
        }
        System.out.println(list);
    }
    static void addList(int i){
        list.add(i);
        Collections.sort(list);
    }
}
