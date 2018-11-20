package com.loves.aop.eg1;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
public class HelloImpl implements Hello {

    @Override
    public void sayHello(String str) {
        System.out.println("helloImpl:"+str);
    }
}
