package com.loves.designModel.structureModel.decoratorPattern.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/25
 * 装饰器
 */
public class Decorator implements  DecInterface{

    private DecInterface source;

    public Decorator(DecInterface source){
        this.source = source;
    }


    @Override
    public void doSomeThing() {
        System.out.println("准备做事");
        source.doSomeThing();
        System.out.println("做事结束");
    }
}
