package com.loves.aop.eg3.dao.impl;

import com.loves.aop.eg3.dao.IndexDao;
import org.springframework.stereotype.Component;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 10:08 2018/12/12
 */
@Component
public class IndexDaoImpl implements IndexDao {
    @Override
    public void query() {
        System.err.println("我是dao--query方法");
    }
}
