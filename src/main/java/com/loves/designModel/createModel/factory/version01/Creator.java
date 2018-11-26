package com.loves.designModel.createModel.factory.version01;

public class Creator {
    private Creator(){}

    public static IProduct createProduct(String productName){
        if (productName == null) {
            return null;
        }
        if (productName.equals("A")) {
            return new ProductA();
        }else if (productName.equals("B")) {
            return new ProductB();
        }else {
            return null;
        }
    }
}

class Client{
    public static void main(String[] args) {
        IProduct product1 = Creator.createProduct("A");
        product1.method();

        IProduct product2 = Creator.createProduct("B");
        product2.method();
    }
}
