package com.loves.shejimoshi.createModel.singleton.version04;

/**
 * 所以我们在语言级别无法完全避免错误的发生，我们只有将该任务交给JVM，所以有一种比较标准的单例模式。如下所示。
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class InnerClassSingleton {

    public static Singleton getInstance(){
        return Singleton.singleton;
    }
    private static class Singleton{
        static Singleton singleton = new Singleton();
    }
}

//总结：
//    首先来说一下，这种方式为何会避免了上面莫名的错误，主要是因为一个类的静态属性只会在第一次加载类时初始化，这是JVM帮我们保证的，
//所以我们无需担心并发访问的问题。所以在初始化进行一半的时候，别的线程是无法使用的，因为JVM会帮我们强行同步这个过程。
//另外由于静态变量只初始化一次，所以singleton仍然是单例的。