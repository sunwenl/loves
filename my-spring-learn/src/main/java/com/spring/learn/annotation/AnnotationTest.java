package com.spring.learn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/10
 * 自定义注解学习
 * @Target 表示可以使用在方法，类，或者接口上。。
 * @Retention() 表示允许反射获取信息
 */
@Target(ElementType.METHOD)
public @interface AnnotationTest {
    String name() default "维生素";
    int id() default 1;
    String [] arr();
}
