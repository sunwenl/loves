package com.loves.designModel.sixPrinciples.lsp.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class SomeoneClass {
    //有某一个方法，使用了一个父类类型
    public void someoneMethod(Parent parent){
        parent.method();
    }
}
