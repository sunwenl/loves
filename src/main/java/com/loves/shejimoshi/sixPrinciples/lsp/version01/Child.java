package com.loves.shejimoshi.sixPrinciples.lsp.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Child extends Parent{
    //结果某一个子类重写了父类的方法，说不支持该操作了
    public void method() {
        throw new UnsupportedOperationException();
    }
}
