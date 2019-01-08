package com.loves.thread.version004;

import com.loves.thread.version004.lock.InputThread;
import com.loves.thread.version004.lock.OutThread;
import com.loves.thread.version004.lock.Student;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/5
 *
 * 多线程间的通讯
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("******线程开始********");
        Student student = new Student();

        InputThread inputThread = new InputThread(student);
        inputThread.setName("Input Thread");
        inputThread.start();

        OutThread outThread = new OutThread(student);
        outThread.setName("Out Thread");
        outThread.start();
        System.out.println("******线程结束********");

    }
}
