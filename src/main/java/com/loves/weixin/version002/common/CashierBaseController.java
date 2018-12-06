package com.loves.weixin.version002.common;

import lombok.Value;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 17:15 2018/12/5
 */
public class CashierBaseController {

    @Value("${spring.pay.test}")
    protected String payCondition;

    @Value("${info.cashier.domain}")
    protected String cashierDomain;

    @ModelAttribute("payCondition")
    public String getPayCondition() {
        return payCondition;
    }

    @Autowired
    protected TradeCashierErrors tradeCashierErrors;

    /**
     * 校验支付是否成功
     *
     * @param orderPaymentSn 支付单号
     * @param paymentTypeId  支付方式
     * @return 校验结果
     */
    protected Boolean checkPayment(String orderPaymentSn, Integer paymentTypeId) {
        Boolean result = true;
        //修改为从支付历史中进行判断是否支付成功和修改订单状态
        //获取该支付单号的支付历史信息
//        List<OrderPaymentHistory> orderPaymentHistoryList = purchaseOrderManager.findPaymentHistoryByPaymentSn(orderPaymentSn);
//        if (orderPaymentHistoryList != null && orderPaymentHistoryList.size() > 0) {
//            //再次查询校验是否支付成功
//            Map checkResult = checkPaymentStatus(orderPaymentSn, paymentTypeId);
//            //是否付款成功
//            if (checkResult != null && checkResult.get("success") != null &&
//                    CashierConstants.MSG_RESULT_SUCCESS.equalsIgnoreCase(checkResult.get("success").toString())) {
//                //校验支付金额跟实际订单金额是否一致,如果不一致,则退款操作
//                String totalAmount = (String) checkResult.get("totalAmount");
//                if (StringUtils.isBlank(totalAmount)) {
//                    return false;
//                }
//
//
//                String outTradeNo = (String) checkResult.get("outTradeNo");
//                Date paidTime = (Date) checkResult.get("paidTime");
//                //处理订单
//                logger.info("支付成功！支付历史次数:{} ,outTradeNo:{} ,支付单号(orderPaymentSn):{},支付时间", orderPaymentHistoryList.size(), outTradeNo, orderPaymentSn);
//                //每个支付历史,若已经支付成功的，则该笔退款
//                checkOrderPayment(orderPaymentHistoryList, paymentTypeId, outTradeNo, paidTime, totalAmount);
//            } else {
//                result = false;
//            }
//        }
        return result;
    }
}
