package com.loves.designModel.structureModel.decoratorPattern;

import com.loves.designModel.structureModel.decoratorPattern.version01.DecInterface;
import com.loves.designModel.structureModel.decoratorPattern.version01.Decorator;
import com.loves.designModel.structureModel.decoratorPattern.version01.Source;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/25
 *
 * 装饰器模式
 */
public class Test {


    public static void main(String[] args) {
        DecInterface source = new Source();

        DecInterface decorator = new Decorator(source);

        decorator.doSomeThing();
    }
}
