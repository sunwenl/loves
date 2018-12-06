package com.loves.weixin.version002;

import com.loves.weixin.version002.bean.Account;
import com.loves.weixin.version002.common.CashierBaseController;
import com.loves.weixin.version002.common.CashierConstants;
import com.loves.weixin.version002.common.TradeCommonUtils;
import com.loves.weixin.version002.common.WechatPayConfig;
import com.loves.weixin.version002.services.WechatService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 17:10 2018/12/5
 */
@Controller
@RequestMapping("/wechatpay")
@Api(description = "微信", value = "WeChatPayController", tags ="weixin-pay")
public class WeChatPayController extends CashierBaseController {
    private final static Logger logger = LoggerFactory.getLogger(WeChatPayController.class);
    /**
     * 微信支付
     *
     * @param id 订单ID
     * @return 逻辑视图名
     */
    @RequestMapping(value = "/{id}/pay")
    public String weChatPay(Account account, HttpServletRequest request,
                            @PathVariable String id,
                            ModelMap modelMap) {
        Map<String, Object> resultMap = new HashMap<>();

        modelMap.put("nickName", account.getDisplayName());

        //处理订单相关信息
//        String redirectUrl = handleOrderInfoForPayment(id, account.getId(), Payment.WECHAT_PAY.getValue(), resultMap);
//        if (StringUtils.isNotBlank(redirectUrl)) {
//            return redirectUrl;
//        }
        //获取配置,如果为true, 走伪支付模式
        String payCondition = getPayCondition();
        if (payCondition.equals("true")) {
            return simulationPayment(id, resultMap);
        }
        String orderPaymentSn = resultMap.get("orderPaymentSn").toString();
        String totalAmount = resultMap.get("amount").toString();
        String orderNos = resultMap.get("orderNos").toString();
        String spbillCreateIp = TradeCommonUtils.getIpAddress(request);
        String notifyUrl = cashierDomain + "/wechatnotify/wechat_notify_url";

        String weChatPayUrl = WechatService.getCodeUrl(WechatPayConfig.WEPAY_TRADETYPE, orderPaymentSn, totalAmount, spbillCreateIp, orderNos, CashierConstants.DESCRIPTION_WEPAY, notifyUrl);
        logger.info(tradeCashierErrors.message("Y3460-100502", "param2->: WeChatPayController.weChatPay[purchaseOrderIds:" + id + "][notifyUrl:" + notifyUrl + "][weChatUrl:" + weChatPayUrl + "]"));

        if (StringUtils.isBlank(notifyUrl)) {
            return ("redirect:/" + id + "/pay");
        }

        modelMap.put("weChatPayUrl", weChatPayUrl);
        modelMap.put("orderIds", id);
        modelMap.putAll(resultMap);

        return "trade/wechatpay";
    }

    /**
     * 模拟支付功能-仅用于测试,不可用于线上环境
     */
    private String simulationPayment(String ids, Map resultMap) {
        /*
         *  构建微信回调关键数据--虚拟
         */
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("time_end", new Date());
        /*
         *  根据微信返回数据,修改本地数据库状态
         */
        String[] purchaseOrderIds = ids.split(",");

        try {
            for (String purchaseOrderId : purchaseOrderIds) {
                String orderPaymentSn = resultMap.get("orderPaymentSn").toString();
                Date time_end = (Date) paraMap.get("time_end");
                //处理买家和卖家订单
//                purchaseOrderManager.payOrder((long) Payment.WECHAT_PAY.getValue(), orderPaymentSn, purchaseOrderId, time_end);
//                publishEvent(orderPaymentSn);
//                //更新支付历史的状态
//                purchaseOrderManager.updateOrderPaymentHistoryPayStatus((long) Payment.WECHAT_PAY.getValue(), orderPaymentSn, purchaseOrderId, PaidStatus.PAID.getValue());
            }
        } catch (Exception e) {
            logger.error(tradeCashierErrors.message("Y3460-100021", e.getMessage()));
            return "exception";
        }
        return "redirect:/wechatpay/success";
    }
}
