package com.loves.designModel.createModel.factory.version04;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/25
 * 邮箱发送消息
 */
public class MaileSender implements  Sender {

    @Override
    public  void send(){
        System.out.println("邮箱发送消息");
    }
}
