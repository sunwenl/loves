package com.loves.designModel.structureModel.proxy.version01;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

/**
 * 首先代理模式，可以分为两种，一种是静态代理，一种是动态代理。
 * 两种代理从虚拟机加载类的角度来讲，本质上都是一样的，都是在原有类的行为基础上，
 * 加入一些多出的行为，甚至完全替换原有的行为。
 * 静态代理采用的方式就是我们手动的将这些行为换进去，然后让编译器帮我们编译，
 * 同时也就将字节码在原有类的基础上加入一些其他的东西或者替换原有的东西，
 * 产生一个新的与原有类接口相同却行为不同的类型。
 * 说归说，我们来真实的去试验一下，实验的话需要找一个示例，就拿我们的数据库连接来做例子吧。
 * 我们都知道，数据库连接是很珍贵的资源，频繁的开关数据库连接是非常浪费服务器的CPU资源以及内存的，
 * 所以我们一般都是使用数据库连接池来解决这一问题，即创造一堆等待被使用的连接，
 * 等到用的时候就从池里取一个，不用了再放回去，数据库连接在整个应用启动期间，几乎是不关闭的，
 * 除非是超过了最大闲置时间。
 * 但是在程序员编写程序的时候，会经常使用connection.close()这样的方法，去关闭数据库连接，
 * 而且这样做是对的，所以你并不能告诉程序员们说，你们使用连接都不要关了，
 * 去调用一个其他的类似归还给连接池的方法吧。这是不符合程序员的编程思维的，也很勉强，
 * 而且具有风险性，因为程序员会忘的。
 * 解决这一问题的办法就是使用代理模式，因为代理模式可以替代原有类的行为，
 * 所以我们要做的就是替换掉connection的close行为。
 */
public interface Connection extends Wrapper {

    Statement createStatement() throws SQLException;

    void close() throws SQLException;
}
