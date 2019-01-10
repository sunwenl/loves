package com.spring.learn.factory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/8
 * aop切面   模拟spring事物
 */
//开启切面
@Aspect
@Component
public class Aop {

    @Before("execution(* com.spring.learn.services.UserService.add(..))")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget());
        System.out.println("准备开始执行方法。。。。");
    }

    @AfterReturning("execution(* com.spring.learn.services.UserService.add(..))")
    public void afterReturning(){
        System.out.println("运行通知");
    }

    @After("execution(* com.spring.learn.services.UserService.add(..))")
    public void after(){
        System.out.println("执行方法结束。。。。。");
    }

    @AfterThrowing("execution(* com.spring.learn.services.UserService.add(..))")
    public void afterThrowing(){
        System.out.println("异常通知");
    }


    @Around("execution(* com.spring.learn.services.UserService.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("我是环绕通知-前");
        proceedingJoinPoint.proceed();
        System.out.println("我是环绕通知-后");
    }

}
