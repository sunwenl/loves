package com.loves.designModel.createModel.factory.version03;

public class Client {

    public static void main(String[] args) throws Exception {
        Creator creator = new ConcreteCreator1();
        ProductA productA = creator.createProductA();
        ProductB productB = creator.createProductB();
        productA.methodA();
        productB.methodB();

        creator = new ConcreteCreator2();
        productA = creator.createProductA();
        productB = creator.createProductB();
        productA.methodA();
        productB.methodB();
    }
}
