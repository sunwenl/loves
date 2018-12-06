package com.loves.weixin.version002;

import com.loves.weixin.version002.bean.Payment;
import com.loves.weixin.version002.common.CashierBaseController;
import io.swagger.annotations.Api;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.InputSource;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 14:45 2018/12/6
 */
@Controller
@RequestMapping("/wechatnotify")
@Api(description = "微信通知", value = "WeChatNotifyController", tags = "weixin-pay")
public class WeChatNotifyController extends CashierBaseController {
    private final static Logger logger = LoggerFactory.getLogger(WeChatNotifyController.class);

    /**
     * 微信支付回调地址
     *
     * @return 逻辑视图
     */
    @RequestMapping(value = "/wechat_notify_url")
    @ResponseBody
    public String wechatNotifyUrl(HttpServletRequest request) {

        String inputLine;
        StringBuilder notifyXml = new StringBuilder();
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notifyXml.append(inputLine);
            }
            request.getReader().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.error(tradeCashierErrors.message("Y3460-100501", notifyXml.toString()));
        Map<String, String> m = parseXmlToList2(notifyXml.toString());

        return handleResponseInfos(m);
    }

    /**
     * to handle response inf
     *
     * @param paraMap : response parameters map
     * @return error/success
     * @since 2016.03.31.22.36
     */
    private String handleResponseInfos(Map<String, String> paraMap) {
        if (paraMap == null || paraMap.size() == 0) {
            logger.error(tradeCashierErrors.message("Y3460-100018", "##WeChatNotifyController callbak: parseXmlToList2(notityXml) return empty map[/wechatnotify/wechat_notify_url]"));
            return "error";
        }

        String orderPaymentSn = paraMap.get("out_trade_no");
        //验证支付回调信息是否支付成功
//        if (ytxWechatService.verifyNotify(paraMap)) {
//            if (!checkPayment(orderPaymentSn, Payment.WECHAT_PAY.getValue())) {
//                CounterService.increment("alipay error");
//                return "error";
//            }
//        }

        return "success";
    }

    /**
     * description: 解析微信通知xml
     *
     * @param xml xml 参数
     * @return 解析后的map集合
     */
    private Map<String, String> parseXmlToList2(String xml) {
        Map retMap = new HashMap();
        try {
            StringReader read = new StringReader(xml);
            InputSource source = new InputSource(read);
            SAXBuilder sb = new SAXBuilder();
            //微信支付商户，如果你在使用支付业务回调通知中，存在以下场景，有使用XML解析的情况，
            //请务必检查是否对XML外部实体注入漏洞(XML External Entity Injection，简称 XXE)进行了防范。
            //@see https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=23_5
            //@see https://www.owasp.org/index.php/XML_External_Entity_(XXE)_Prevention_Cheat_Sheet#C.2FC.2B.2B
            sb.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            sb.setFeature("http://xml.org/sax/features/external-general-entities", false);
            sb.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            Document doc = sb.build(source);
            Element root = doc.getRootElement();
            List<Element> es = root.getChildren();
            if (es != null && es.size() > 0) {
                for (Element element : es) {
                    retMap.put(element.getName(), element.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retMap;
    }
}
