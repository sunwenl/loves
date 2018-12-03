package com.loves.designModel.createModel.factory.version02;

/**
 *  可以看到，我们使用可以随意的在具体的工厂和产品之间切换，并且不需要修改任何代码，就可以让原来的程序正常运行，
 *  这也是工厂方法模式对扩展开放的表现，另外工厂方法模式弥补了简单工厂模式不满足开闭原则的诟病，当我们需要增加产品时，
 *  只需要增加相应的产品和工厂类，而不需要修改现有的代码。
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new BuildCreator();
        Light light = creator.createLight();
        light.turnOn();
        light.turnOff();

        creator = new TubeCreator();
        light = creator.createLight();
        light.turnOn();
        light.turnOff();
    }
}
/**
 * 从类关系上来说，它可以让客户端与具体的工厂与产品解耦，从业务角度来说，它让客户端与具体的产品解耦。
 *
 * 适用的场景就是我们需要一个产品帮我们完成一项任务，但是这个产品有可能有很多品牌（像这里的mysql，oracle），
 * 为了保持我们对产品操作的一致性，我们就可能要用到工厂方法模式。
 */
