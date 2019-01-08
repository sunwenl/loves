package com.loves.thread.version004;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/5
 *
 * 读取信息
 */
public class OutThread extends Thread{
    private Student student;

    OutThread(Student student){
        this.student = student;
    }
    @Override
    public void run() {
        int i = 1000;
        //while(i > 0){
        while(true){
            //System.out.println("当前线程的名字是"+Thread.currentThread().getName());
            synchronized (student){
                if(student.getFlag()){//为true开始读取值
                    System.out.println(student.toString());
                    i--;
                    student.setFlag(false);//读取完 修改为false
                }

            }
        }
    }
}