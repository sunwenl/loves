package com.loves.designModel.structureModel.proxy.version05.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 * CGLIB动态代理
 *
 * CGLIB与JDK动态代理区别
 *   jdk动态代理是由Java内部的反射机制来实现的，cglib动态代理底层则是借助asm来实现的。
 *   总的来说，反射机制在生成类的过程中比较高效，而asm在生成类之后的相关执行过程中比较高效
 *   （可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）。
 *   还有一点必须注意：jdk动态代理的应用前提，必须是目标类基于统一的接口。如果没有上述前提，jdk动态代理不能应用。
 *   注:asm其实就是java字节码控制.
 */
public class Cglib implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是买房中介 ， 开始监听你买房了....");
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("我是买房中介 ， 开结束你买房了....");
        return invokeSuper;
    }
}
class MainTest{
    public static void main(String[] args) {
        Cglib cglib = new Cglib();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(xiaoming.class);
        enhancer.setCallback(cglib);
        Hose hose = (Hose) enhancer.create();
        hose.sale();
    }
}
