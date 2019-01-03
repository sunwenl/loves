package com.loves.designModel.createModel.factory.version04;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/25
 *  短信发送消息
 */
public class SmsSender implements  Sender {

    @Override
    public  void send(){
        System.out.println("短信发送消息");
    }
}
