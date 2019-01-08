package com.loves.thread.version004;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/5
 * 写如信息
 */
public class InputThread extends Thread{

    private Student student;

    InputThread(Student  student){
        this.student = student;
    }
    @Override
    public void run() {
        int i = 1000;
        int count = 0;
        //while (i > 0){
        while (true){
            //System.out.println("当前线程的名字是"+Thread.currentThread().getName());
            synchronized (student){
                if(!student.getFlag()){//为false  开始写入值
                    if(count == 0){
                        student.setId(1);
                        student.setName("孫文");
                        student.setSex("男");
                    }else{
                        student.setId(2);
                        student.setName("一佳");
                        student.setSex("女");
                    }
                    count = (count+1) % 2;
                    i--;
                    student.setFlag(true);
                }
            }
        }
    }
}
