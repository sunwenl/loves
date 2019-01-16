package com.loves.designModel.structureModel.proxy.version05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 * jdk 动态代理
 */
public class TargetTest implements InvocationHandler {
    private Object target;
    public TargetTest(Object target){
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备开始买房");
        Object obj = method.invoke(target,args);
        System.out.println("买房结束");
        return obj;
    }
}
class MainTest{
    public static void main(String[] args) {
        XiaoMing xm = new XiaoMing();
        TargetTest tt = new TargetTest(xm);
        //Hose hose  = (Hose)Proxy.newProxyInstance(TargetTest.class.getClassLoader(),new Class[]{Hose.class},tt);
        Hose hose  = (Hose)Proxy.newProxyInstance(xm.getClass().getClassLoader(),xm.getClass().getInterfaces(),tt);
        hose.sale();
    }
}
