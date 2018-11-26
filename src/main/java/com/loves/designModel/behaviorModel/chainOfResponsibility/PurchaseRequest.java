package com.loves.designModel.behaviorModel.chainOfResponsibility;

/**
 * 物品请求类
 */
public class PurchaseRequest {
    private int Type = 0;
    private int Number = 0;
    private float Price = 0;
    private int ID = 0;

    PurchaseRequest(int Type, int Number, float Price) {
        this.Type = Type;
        this.Number = Number;
        this.Price = Price;
    }

    public int GetType() {
        return Type;
    }

    float GetSum() {
        return Number * Price;
    }

    int GetID() {
        return (int) (Math.random() * 1000);
    }
}
