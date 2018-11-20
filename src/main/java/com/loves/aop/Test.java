package com.loves.aop;

import com.loves.aop.eg1.Hello;
import com.loves.aop.eg1.HelloImpl;
import com.loves.aop.eg1.StaticProxiedHello;
import com.loves.aop.eg2.LogInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
public class Test {

    public static void main(String[] args) {
        //StaticProxiedHello staticProxiedHello=new StaticProxiedHello();
        //staticProxiedHello.sayHello("静态代理");

        //eg2
        new Test().say("I love you!");
    }

    private void say(String str){
        // 2. 然后在需要使用Hello的时候，通过JDK动态代理获取Hello的代理对象。
        Hello hello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(), // 1. 类加载器
                new Class<?>[] {Hello.class}, // 2. 代理需要实现的接口，可以有多个
                new LogInvocationHandler(new HelloImpl()));// 3. 方法调用的实际处理者
        hello.sayHello(str);
    }
}
