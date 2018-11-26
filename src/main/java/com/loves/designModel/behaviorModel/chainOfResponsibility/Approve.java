package com.loves.designModel.behaviorModel.chainOfResponsibility;

public abstract class Approve {
    Approve successor;
    String Name;

    Approve(String Name) {
        this.Name = Name;
    }

    public abstract void ProcessRequest(PurchaseRequest request);

    void SetSuccessor(Approve successor) {
        this.successor = successor;
    }
}
