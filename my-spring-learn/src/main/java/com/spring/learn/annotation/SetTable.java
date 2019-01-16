package com.spring.learn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/11
 * 自定义表映射注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetTable {
    //对应数据库表名称
    String value();
}
