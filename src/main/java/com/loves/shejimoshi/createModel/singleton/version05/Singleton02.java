package com.loves.shejimoshi.createModel.singleton.version05;

/**
 * 饿汉式加载
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Singleton02 {
    private static Singleton02 singleton = new Singleton02();

    private Singleton02(){}

    public static Singleton02 getInstance(){
        return singleton;
    }
}

//总结：
//    上述方式与我们最后一种给出的方式类似，只不过没有经过内部类处理，这种方式最主要的缺点就是一旦我访问了Singleton的任何其他的静态域，
//就会造成实例的初始化，而事实是可能我们从始至终就没有使用这个实例，造成内存的浪费。
//    不过在有些时候，直接初始化单例的实例也无伤大雅，对项目几乎没什么影响，比如我们在应用启动时就需要加载的配置文件等，
//就可以采取这种方式去保证单例。
//    第二种我就不贴了，与双重锁定一模一样，只是给静态的实例属性加上关键字volatile，标识这个属性是不需要优化的。
//    这样也不会出现实例化发生一半的情况，因为加入了volatile关键字，就等于禁止了JVM自动的指令重排序优化，
//并且强行保证线程中对变量所做的任何写入操作对其他线程都是即时可见的。这里没有篇幅去介绍volatile以及JVM中变量访问时所做的具体动作，
//总之volatile会强行将对该变量的所有读和取操作绑定成一个不可拆分的动作。
//    不过值得注意的是，volatile关键字是在JDK1.5以及1.5之后才被给予了意义，所以这种方式要在JDK1.5以及1.5之后才可以使用，
//但仍然还是不推荐这种方式，一是因为代码相对复杂，二是因为由于JDK版本的限制有时候会有诸多不便。
//
