package com.loves.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 16:51 2018/12/17
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(Object targ){
        this.target = targ;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().startsWith("test")){
            System.out.println("*********目标对象*********");
        }
        return method.invoke(target,args);
    }

    public static void main(String[] args) {
        MyInvocationHandler handler = new MyInvocationHandler(new UserServiceImpl());
        UserService userService = (UserService)Proxy.newProxyInstance(MyInvocationHandler.class.getClassLoader(),
                new Class[]{UserService.class}, handler);
        userService.test("aba");
        userService.test1();
        userService.abc();
    }
}
