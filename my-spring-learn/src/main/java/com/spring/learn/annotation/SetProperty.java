package com.spring.learn.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/11
 * 定义字段属性
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface SetProperty {
    //字段名称
    String name();

    //字段长度
    int length();
}
