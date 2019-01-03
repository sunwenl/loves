package com.loves.aop.eg3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP学习
 * @Author ：xiaoyijia.
 * @Date ：Created in 10:05 2018/12/12
 */
//声明为配置类
@Configuration
//扫描包
@ComponentScan("com.loves.aop.eg3")
//支持AspectJ编码风格
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {

}
