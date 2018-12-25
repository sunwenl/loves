package com.loves.designModel.createModel.factory.version04;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/25
 */
public class Test {

    //工厂模式是最常用的模式
    public static void main(String[] args) {
        Sender sender = SenderFactory.genSender("sms");
        sender.send();

    }
}