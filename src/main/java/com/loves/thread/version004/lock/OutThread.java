package com.loves.thread.version004.lock;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/5
 * <p>
 * 读取信息
 */
public class OutThread extends Thread {
    private Student student;

    public OutThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int i = 1000;
        while (i > 0) {
            try {
                student.lock.lock();
                if(!student.getFlag()){
                    try {
                        student.condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(student.toString());
                i--;

                student.setFlag(false);
                student.condition.signal();
            }catch (Exception e){
                System.out.println("报错了");
            }finally {
                student.lock.unlock();
            }
        }
    }
}