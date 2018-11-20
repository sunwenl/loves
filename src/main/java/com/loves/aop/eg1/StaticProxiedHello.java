package com.loves.aop.eg1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 静态代理方式
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
public class StaticProxiedHello implements Hello {

    private Logger logger = LoggerFactory.getLogger(StaticProxiedHello.class);

    private Hello hello = new HelloImpl();

    @Override
    public void sayHello(String str) {
        logger.info("You said: " + str);
        hello.sayHello(str);
    }
}
