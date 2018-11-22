package com.loves.shejimoshi.sixPrinciples.isp.version01;

/**
 * 非智能手机
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public interface NonSmartPhone extends Mobile{
    public void call();//手机可以打电话

    public void sendMessage();//手机可以发短信

}
