package com.loves.aop.eg2;

import com.loves.aop.eg1.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Java Proxy
 * 1. 首先实现一个InvocationHandler，方法调用会被转发到该类的invoke()方法
 * @Author ：SunWenLong
 * @Date ：2018/11/15
 */
public class LogInvocationHandler implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(LogInvocationHandler.class);

    private Hello hello;
    public LogInvocationHandler(Hello hello) {
        this.hello = hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("sayHello".equals(method.getName())) {
            logger.info("You said: " + Arrays.toString(args));
        }
        return method.invoke(hello, args);
    }

    //上述代码的关键是Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler handler)方法，
    // 该方法会根据指定的参数动态创建代理对象。三个参数的意义如下：
    //loader，指定代理对象的类加载器；
    //interfaces，代理对象需要实现的接口，可以同时指定多个接口；
    //handler，方法调用的实际处理者，代理对象的方法调用都会转发到这里（*注意1）。
    //newProxyInstance()会返回一个实现了指定接口的代理对象，对该对象的所有方法调用都会转发给InvocationHandler.invoke()方法。理解上述代码需要对Java反射机制有一定了解。动态代理神奇的地方就是：
    //
    //代理对象是在程序运行时产生的，而不是编译期；
    //        对代理对象的所有接口方法调用都会转发到InvocationHandler.invoke()方法，在invoke()方法里我们可以加入任何逻辑，比如修改方法参数，加入日志功能、安全检查功能等；之后我们通过某种方式执行真正的方法体，示例中通过反射调用了Hello对象的相应方法，还可以通过RPC调用远程方法。
    //注意1：对于从Object中继承的方法，JDK Proxy会把hashCode()、equals()、toString()这三个非接口方法转发给InvocationHandler，其余的Object方法则不会转发。详见JDK Proxy官方文档。
    //
    //如果对JDK代理后的对象类型进行深挖，可以看到如下信息：
    //
    //        # Hello代理对象的类型信息
    //class=class jdkproxy.$Proxy0
    //superClass=class java.lang.reflect.Proxy
    //interfaces:
    //interface jdkproxy.Hello
    //        invocationHandler=jdkproxy.LogInvocationHandler@a09ee92
    //代理对象的类型是jdkproxy.$Proxy0，这是个动态生成的类型，类名是形如$ProxyN的形式；父类是java.lang.reflect.Proxy，所有的JDK动态代理都会继承这个类；同时实现了Hello接口，也就是我们接口列表中指定的那些接口。
    //
    //如果你还对jdkproxy.$Proxy0具体实现感兴趣，它大致长这个样子：
    //
    //// JDK代理类具体实现
    //public final class $Proxy0 extends Proxy implements Hello{
    //    public $Proxy0(InvocationHandler invocationhandler){
    //        super(invocationhandler);
    //    }
    //    @Override
    //    public final String sayHello(String str){
    //        return super.h.invoke(this, m3, new Object[] {str});// 将方法调用转发给invocationhandler
    //    }
    //}
}
