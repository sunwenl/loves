package com.loves.designModel.behaviorModel.chainOfResponsibility;

public class Client {

    Client() {

    }

    PurchaseRequest sendRequst(int Type, int Number, float Price) {
        return new PurchaseRequest(Type, Number, Price);
    }
}
