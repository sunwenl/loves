package com.loves.shejimoshi.createModel.singleton.version01;

/**
 *
 * 1.静态实例，带有static关键字的属性在每一个类中都是唯一的。
 * 2.限制客户端随意创造实例，即私有化构造方法，此为保证单例的最重要的一步。
 * 3.给一个公共的获取实例的静态方法，注意，是静态的方法，
 * 因为这个方法是在我们未获取到实例的时候就要提供给客户端调用的，
 * 所以如果是非静态的话，那就变成一个矛盾体了，因为非静态的方法必须要拥有实例才可以调用。
 * 4.判断只有持有的静态实例为null时才调用构造方法创造一个实例，否则就直接返回。
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Singleton {
    //一个静态的实例
    private static Singleton singleton;
    //私有化构造函数
    private Singleton(){}
    //给出一个公共的静态方法返回一个单一实例
    public static Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
//总结：
// 当并发访问的时候，第一个调用getInstance方法的线程A，在判断完singleton是null的时候，
//线程A就进入了if块准备创造实例，但是同时另外一个线程B在线程A还未创造出实例之前，
//就又进行了singleton是否为null的判断，这时singleton依然为null，
//所以线程B也会进入if块去创造实例，这时问题就出来了，有两个线程都进入了if块去创造实例，
//结果就造成单例模式并非单例。
