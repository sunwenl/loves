//package com.loves.weixin.version002.services;
//
//import com.loves.weixin.version002.bean.TenpayUtil;
//import com.loves.weixin.version002.bean.WeChatPayDto;
//import com.loves.weixin.version002.bean.WechatProperties;
//import com.loves.weixin.version002.common.GetWeChatOrderno;
//import com.loves.weixin.version002.common.RequestHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.codahale.metrics.MetricRegistry;
//import java.util.SortedMap;
//import com.codahale.metrics.Timer;
//import java.util.TreeMap;
//
///**
// * @Author ：xiaoyijia.
// * @Date ：Created in 18:02 2018/12/5
// */
//public class WechatService {
//    private final static Logger logger = LoggerFactory.getLogger(WechatService.class);
//    @Autowired
//    private MetricRegistry metrics;
//
//    @Autowired
//    private WechatProperties wechatProperties;
//
//    /**
//     * 获取微信支付订单二维码生成url
//     *
//     * @param tradeType       交易类型(JSAPI--公众号支付、NATIVE--原生扫码支付、APP--ap支付，统一下单接口trade_type的传参可参考这里MICROPAY--刷卡支付)
//     * @param pucharseOrderId 买家订单ID(多笔订单合并支付以","分割)
//     * @param totalFee        总费用
//     * @param spbillCreateIp  终端IP
//     * @param body            描述内容
//     * @param attach          附加信息
//     * @param notifyUrl       回调地址
//     * @return 二维码生成url
//     */
//    public static String getCodeUrl(String tradeType, String pucharseOrderId, String totalFee, String spbillCreateIp, String body, String attach, String notifyUrl) {
//        WeChatPayDto tpWxPay = new WeChatPayDto();
//        tpWxPay.setBody(body);
//        tpWxPay.setOrderId(pucharseOrderId);
//        tpWxPay.setSpbillCreateIp(spbillCreateIp);
//        tpWxPay.setTotalFee(totalFee);
//        tpWxPay.setTradeType(tradeType);
//        tpWxPay.setAttach(attach);
//        tpWxPay.setNotifyUrl(notifyUrl);
//
//        return new WechatService().takeCodeUrl(tpWxPay);
//    }
//
//    /**
//     * 获取微信扫码支付二维码连接
//     */
//    String takeCodeUrl(WeChatPayDto tpWxPayDto) {
//        final Timer timer = metrics.timer("wechat.trade.QRCode");
//        final Timer.Context timerContext = timer.time();
//
//        //商户号
//        String mchId = wechatProperties.getMchid();
//
//        //合作者appId
//        String appId = wechatProperties.getAppid();
//
//        //商户key
//        String partnerKey = wechatProperties.getPartnerkey();
//
//        //生成微信支付下单地址
//        String createOrderUrl = wechatProperties.getCreateorderurl();
//
//        //这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
//        String notifyUrl = tpWxPayDto.getNotifyUrl();
//
//        //订单号
//        String orderId = tpWxPayDto.getOrderId();
//
//        //附加数据 原样返回
//        String attach = tpWxPayDto.getAttach();
//
//        //总金额以分为单位，不带小数点
//        String totalFee = TenpayUtil.getMoney(tpWxPayDto.getTotalFee());
//
//        //订单生成的机器 IP
//        String spbillCreateIp = tpWxPayDto.getSpbillCreateIp();
//
//        //交易类型
//        String tradeType = tpWxPayDto.getTradeType();
//
//        //商品描述
//        String body = tpWxPayDto.getBody();
//
//        //随机字符串
//        String nonceStr = TenpayUtil.getNonceStr();
//
//        //封装map
//        SortedMap<String, String> packageParams = new TreeMap<>();
//        packageParams.put("appid", appId);
//        packageParams.put("attach", attach);
//        packageParams.put("body", body);
//        packageParams.put("mch_id", mchId);
//        packageParams.put("nonce_str", nonceStr);
//        packageParams.put("notify_url", notifyUrl);
//        packageParams.put("out_trade_no", orderId);
//        packageParams.put("spbill_create_ip", spbillCreateIp);
//        packageParams.put("total_fee", totalFee);
//        packageParams.put("trade_type", tradeType);
//        RequestHandler reqHandler = new RequestHandler();
//        reqHandler.init(appId, mchId, partnerKey);
//        String sign = reqHandler.createSign(packageParams);
//        StringBuilder xml = new StringBuilder();
//        xml.append("<xml>")
//                .append("<appid>").append(appId).append("</appid>")
//                .append("<attach>").append(attach).append("</attach>")
//                .append("<body><![CDATA[").append(body).append("]]></body>")
//                .append("<mch_id>").append(mchId).append("</mch_id>")
//                .append("<nonce_str>").append(nonceStr).append("</nonce_str>")
//                .append("<notify_url>").append(notifyUrl).append("</notify_url>")
//                .append("<out_trade_no>").append(orderId).append("</out_trade_no>")
//                .append("<spbill_create_ip>").append(spbillCreateIp).append("</spbill_create_ip>")
//                .append("<total_fee>").append(totalFee).append("</total_fee>")
//                .append("<trade_type>").append(tradeType).append("</trade_type>")
//                .append("<sign>").append(sign).append("</sign>")
//                .append("</xml>");
//
//        logger.info("##INFO:YtxWechatPay.takeCodeUrl[xml:" + xml + "]");
//        String result = GetWeChatOrderno.getCodeUrl(createOrderUrl, xml.toString());
//        timerContext.stop();
//        if (result == null || result.isEmpty()) {
//            metrics.counter("wechat.trade.QRCode.fail");
//        } else {
//            metrics.counter("wechat.trade.QRCode.success");
//        }
//        return result;
//    }
//}
