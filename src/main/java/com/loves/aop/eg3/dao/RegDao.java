package com.loves.aop.eg3.dao;

import org.springframework.stereotype.Component;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 20:34 2018/12/12
 */
@Component("dao")
public class RegDao {
    public void query() {
        System.err.println("我是dao--query方法");
    }
}
