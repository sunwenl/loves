package com.loves.designModel.createModel.factory.version02;

/**
 * 定义：工厂方法(Factory Method)模式的意义是定义一个创建产品对象的工厂接口，
 * 将实际创建工作推迟到子类当中。核心工厂类不再负责产品的创建，这样核心类成为一个抽象工厂角色，
 * 仅负责具体工厂子类必须实现的接口，这样进一步抽象化的好处是使得工厂方法模式可以使系统在不修改
 * 具体工厂角色的情况下引进新的产品。
 *
 * 可以看到工厂方法模式中定义了一个工厂接口，而具体的创建工作推迟到具体的工厂类，
 * 它是对简单工厂模式中的工厂类进一步抽象化，从而产生一个工厂类的抽象和实现体系，
 * 从而弥补简单工厂模式对修改开放的诟病。
 */
public  interface Light {

    public void turnOn();

    public void turnOff();

}