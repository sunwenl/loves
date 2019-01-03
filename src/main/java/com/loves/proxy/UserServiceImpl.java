package com.loves.proxy;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 16:50 2018/12/17
 */
public class UserServiceImpl implements UserService {
    @Override
    public void test(String str) {
        System.out.println("********test**********"+str);
    }

    @Override
    public void test1() {
        System.out.println("********test1**********");
    }

    @Override
    public void abc() {
        System.out.println("********abc**********");
    }
}
