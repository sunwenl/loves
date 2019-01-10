package com.spring.learn.factory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 * aop切面xml配置方式   模拟spring事物
 */
//开启切面
public class AopXml {

    public void before(){
        System.out.println("准备开始执行方法。。。。");
    }

    public void afterReturning(){
        System.out.println("运行通知");
    }

    public void after(){
        System.out.println("执行方法结束。。。。。");
    }

    public void afterThrowing(){
        System.out.println("异常通知");
    }

    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知-前");
        proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知-后");
    }

}
