package com.loves.thread.version006;

//class Res{
//    private int count=0;
//    public int addCount(){
//        count =count+1;
//        return count;
//    }
//}
class Res{
    //使用ThreadLocal 声明一个本地线程变量  并幅值0
    private  ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };
    public int addCount(){
        int count = threadLocal.get()+1;
        //执行+1操作  并返回设置回ThreadLocal
        threadLocal.set(count);

        return count;
    }
}
class ThreadLocalDemo extends Thread{
    private Res res;
    ThreadLocalDemo(Res res){
        this.res=res;
    }
    @Override
    public void run() {
        for (int i=0;i<3;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName()+"---"+i+"---"+res.addCount());
        }
    }
}

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/7
 * ThreadLoca的使用
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal=new ThreadLocal();

        Res res = new Res();
        threadLocal.set(res);
        ThreadLocalDemo t1=new ThreadLocalDemo(res);
        ThreadLocalDemo t2=new ThreadLocalDemo(res);
        ThreadLocalDemo t3=new ThreadLocalDemo(res);
        t1.start();
        t2.start();
        t3.start();
    }
}
