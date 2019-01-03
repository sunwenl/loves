package com.loves.aop.eg3;

import com.loves.aop.eg3.config.AppConfig;
import com.loves.aop.eg3.dao.IndexDao;
import com.loves.aop.eg3.dao.RegDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 10:05 2018/12/12
 */
public class Test {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext an = new AnnotationConfigApplicationContext(AppConfig.class);
        RegDao regDao = (RegDao)an.getBean("dao");
        regDao.query();
    }
}
