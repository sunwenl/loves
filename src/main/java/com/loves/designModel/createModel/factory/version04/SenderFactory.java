package com.loves.designModel.createModel.factory.version04;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/25
 *
 *
 */
public class SenderFactory {

    /**
     * 普通工厂模式
     */
    public static Sender genSender(String type){
        if(type.equals("sms")){
          return new SmsSender();
        }else if(type.equals("mail")){
            return new MaileSender();
        }
        return null;
    }

    /**
     * 多个工厂方法模式
     */
    public  Sender getSmsSender(){
        return new SmsSender();
    }
    public  Sender getMaileSender(){
        return new MaileSender();
    }

    /**
     * 静态工厂方法模式
     */
    public static  Sender proveSmsSender(){
        return new SmsSender();
    }
    public static  Sender proveMaileSender(){
        return new MaileSender();
    }

}
