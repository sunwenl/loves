package com.loves.weixin.version002.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 微信Properties
 *
 * @Author ：xiaoyijia.
 * @Date ：Created in 09:49 2018/12/6
 */
@ConfigurationProperties(prefix = "spring.wechat")
@Data
public class WechatProperties {
    /**
     * APPID:
     * 解释:appid是微信公众账号或开放平台APP的唯一标识，在公众平台申请公众账号或者在开
     * 放平台申请APP账号后，微信会自动分配对应的appid，用于标识该应用。可在微信公众
     * 平台-->开发者中心查看，商户的微信支付审核通过邮件中也会包含该字段值。
     */
    private String appid = "ss001";
    /**
     * 移动端APPID
     */
    private String mobileAppid = "ss002";
    /**
     * 微信支付商户号:
     * 商户申请微信支付后，由微信支付分配的商户收款账号。
     */
    private String mchid = "ss003";

    /**
     * 移动端mchId
     */
    private String mobileMchid = "ss004";
    /**
     * 小程序mchId
     */
    private String smallMchid = "ss005";


    /**
     * 小程序appid
     */
    private String wxappid="ss006";
    /**
     * 小程序密钥
     */
    private String wxsecret="ss007";
    /**
     * API密钥:
     * 交易过程生成签名的密钥，仅保留在商户系统和微信支付后台，不会在网络中传播。商户
     * 妥善保管该Key，切勿在网络中传输，不能在其他客户端中存储，保证key不会被泄漏。
     * 商户可根据邮件提示登录微信商户平台进行设置。也可按一下路径设置：微信商户平台
     * (pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置。
     */
    private String partnerkey = "ss008";
    private String mobileSecret = "ss009";
    /**
     * 移动端API_KEY
     */
    private String mobileKey = "ss0010";
    private String smallKey = "ss0011";
    /**
     * 微信订单操作时,TRADETYPE
     */
    private String wepaytradetype = "ss0012";
    /**
     * 生成微信支付下单地址
     */
    private String createorderurl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 订单状态查询URL
     */
    private String queryorderurl = "https://api.mch.weixin.qq.com/pay/orderquery";
    /**
     * 微信申请退款地址
     */
    private String refundurl = "https://api.mch.weixin.qq.com/secapi/pay/refund";
    /**
     * 退款状态查询URL
     */
    private String queryrefundurl = "https://api.mch.weixin.qq.com/pay/refundquery";
    /**
     * 退款资金来源:未结算
     */
    private String refundAccountUnsettled = "REFUND_SOURCE_UNSETTLED_FUNDS";
    /**
     * 退款资金来源:余额
     */
    private String refundAccountRecharge = "REFUND_SOURCE_RECHARGE_FUNDS";

    /**
     * 开发者服务器使用登录凭证 code 获取 session_key 和 openid。其中 session_key 是对用户数据进行加密签名的密钥。为了自身应用安全，session_key 不应该在网络上传输。
     * for 小程序
     */
    private String getSessionKeyUrl = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
}