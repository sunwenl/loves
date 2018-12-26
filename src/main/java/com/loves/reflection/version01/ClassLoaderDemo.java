package com.loves.reflection.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/26
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {
        //classLoader的加载器
        //System.out.println(ClassLoaderDemo.class.getClassLoader());
        //System.out.println(ClassLoaderDemo.class.getClassLoader().getParent());
        //System.out.println(ClassLoaderDemo.class.getClassLoader().getParent().getParent());

        //MyClassLoader myClassLoader = new MyClassLoader();
        //Class<?> cls  = myClassLoader.loadClass("java.util.Date");
        //System.out.println(cls.newInstance());
        ////loadClass()方法 与Class.forName("");方法 作用一致
        //Class<?> claz = Class.forName("java.util.Date");
        //System.out.println(claz.newInstance());

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> cls = myClassLoader.loadFiles(" com.loves.reflection.version01.Student");
        System.out.println(cls.newInstance());

    }
}
