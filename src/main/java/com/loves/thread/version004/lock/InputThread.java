package com.loves.thread.version004.lock;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/5
 * 写如信息
 */
public class InputThread extends Thread {

    private Student student;

    public InputThread(Student student) {
        this.student = student;
    }

    @Override
    public void run() {
        int i = 1000;
        int count = 0;
        while (i > 0) {
            try {
                student.lock.lock();
                if(student.getFlag()){
                    try {
                        student.condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (count == 0) {
                    student.setId(1);
                    student.setName("孫文");
                    student.setSex("男");
                } else {
                    student.setId(2);
                    student.setName("阿苒");
                    student.setSex("女");
                }
                count = (count + 1) % 2;
                i--;
                student.setFlag(true);

                student.condition.signal();
            }catch (Exception e){
                System.out.println("报错");
            }finally {
                student.lock.unlock();
            }
        }
    }
}
