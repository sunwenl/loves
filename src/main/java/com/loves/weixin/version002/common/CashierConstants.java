package com.loves.weixin.version002.common;

/**
 * 收银台常量
 * @Author ：xiaoyijia.
 * @Date ：Created in 11:16 2018/12/6
 */
public class CashierConstants {

    //调用微信接口时,要传入的订单说明参数
    public static String DESCRIPTION_WEPAY = "WECHAT PAY";
    public static String DESCRIPTION_ALIPAY = "ALIPAY";
    /**
     * result message from wechat微信支付接口返回信息
     */
    public static String MSG_WECHAT_SUCCESS = "SUCCESS";

    /**
     * result message from alipay支付宝查询接口返回信息
     */
    //查询成功
    public static String MSG_ALIPAY_ISSUCCESS_T = "T";
    //订单交易成功
    public static String MSG_ALIPAY_TRADE_SUCCESS = "TRADE_SUCCESS";

    //spring mvc 返回success
    public static String MSG_RESULT_SUCCESS = "true";
    //spring mvc 返回error
    public static String MSG_RESULT_ERROR = "error";
    //spring mvc 返回failed
    public static String MSG_RESULT_FAILED = "failed";
    //spring mvc 返回exception
    public static String MSG_RESULT_EXCEPTION = "exception";
    //中断当前操作(当前操作已过期)
    public static String MSG_RESULT_BLOCK = "block";

    public static String URL = "http://www.xiaoyijia.com";
}
