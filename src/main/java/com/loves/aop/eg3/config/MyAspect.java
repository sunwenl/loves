package com.loves.aop.eg3.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 11:29 2018/12/12
 */
@Component
//声明为切面类
@Aspect
public class MyAspect {

    //Pointcut切点 execution切入的方法
    @Pointcut("execution(* com.loves.aop.eg3..*.*(..)) ")
    public void pointCut(){
        System.err.println("pointCut----");
    }

    @Before("pointCut()")
    public void before(){
        System.err.println("before-----");
    }

//    @After("query")
//    public void after(){
//        System.out.println("after-----");
//    }
//    @AfterReturning("query")
//    public void afterReturning(){
//        System.out.println("afterReturning-----");
//    }
//    @Around("query")
//    public void around() throws Throwable {
//        System.out.println("Around-----");
//    }
}
