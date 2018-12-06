package com.loves.weixin.version002.bean;

import lombok.Data;

/**
 * 微信参数封装Object类
 *
 * @Author ：xiaoyijia.
 * @Date ：Created in 18:03 2018/12/5
 */
@Data
public class WeChatPayDto {
    private String orderId;//订单号
    private String totalFee;//金额
    private String spbillCreateIp;//订单生成的机器 IP
    private String notifyUrl;//这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等
    private String body;// 商品描述根据情况修改
    private String openId;//微信用户对一个公众号唯一
    private String tradeType;//交易类型
    private String attach;//商品附加信息
}
