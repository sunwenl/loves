package com.loves.weixin.version001

import com.loves.weixin.version001.bean.CashApply
import com.loves.weixin.version001.bean.SellerMiniApp
import com.loves.weixin.version001.bean.WechatProfile
import com.loves.weixin.version001.bean.WechatRefundAuth
import com.loves.weixin.version001.services.WxTransferService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

/**
 * @Author     ：xiaoyijia.
 * @Date       ：Created in 15:06 2018/12/5
 *
 * 企业付款到个人零钱
 * https://pay.weixin.qq.com/wiki/doc/api/tools/mch_pay.php?chapter=14_2
 */
@RestController
@RequestMapping("/kt/loves")
class TransferController @Autowired constructor(val wxTransferService: WxTransferService){
    private val logger = LoggerFactory.getLogger(TransferController::class.java)

    @RequestMapping("/pay")
    fun pay(){
        //要转账的 订单申请信息
        val cashApplyHasChuList = mutableListOf<CashApply>()
        handlerTransfer(cashApplyHasChuList)
    }

    private fun handlerTransfer(cashApplyList: List<CashApply>) {
        cashApplyList.forEach({
            val wxInfo = findSellerMiniAppBySellerAccountId(it.sellerAccountId)
            val wecharProfile = findWechatProfileByAccountId(it.accountId)
            val wra = findWechatRefundAuthByAccountId(it.sellerAccountId)

            logger.info("*** sellerAccountId:{},accountId:{},wra:{} ***", it.sellerAccountId, it.accountId, wra.authFile.size)

            //判断证书
            if (null != wra.authFile) {
                //组装数据
                //2.0 生成map集合
                val paramMap = TreeMap<String, Any>()
                paramMap["mch_appid"] = wxInfo.appId                                    //微信公众号的appid
                paramMap["mchid"] = wxInfo.mchid                                        //商务号
                paramMap["partner_trade_no"] = it.id.toString()                         //生成商户订单号
                paramMap["openid"] = wecharProfile.openId                               // 支付给用户openid
                paramMap["check_name"] = "NO_CHECK"                                  //是否验证真实姓名呢
                paramMap["amount"] = it.amount.multiply(BigDecimal(100)).toInt()    //企业付款金额，单位为分
                paramMap["desc"] = "提现"

                paramMap["key"] = wxInfo.apiKey
                paramMap["openid"] = wecharProfile.openId

                logger.info("*** transfer ***")
                //执行打款操作
                wxTransferService.transfer(paramMap, wra.authFile)
            }
        })
    }

    /**
     * 模拟 根据商家Id 查询 商家小程序相关信息
     */
    private fun findSellerMiniAppBySellerAccountId(sellerAccountId: Long): SellerMiniApp {
        val sellerMiniApp = SellerMiniApp()
        sellerMiniApp.accountId = sellerAccountId
        sellerMiniApp.appId = "2001"
        sellerMiniApp.mchid = "weixin001"
        sellerMiniApp.apiKey = "weixinapikey"

        //浪一下
        if(sellerMiniApp.accountId == sellerAccountId) return sellerMiniApp
        return sellerMiniApp
    }

    /**
     *通过账户id查找公众号微信帐号信息
     */
    private fun findWechatProfileByAccountId(accountId: Long): WechatProfile {
        val wechatProfile = WechatProfile()
        wechatProfile.accountId = accountId
        wechatProfile.openId = "openId"

        //再浪一下
        if(wechatProfile.accountId == accountId) return wechatProfile
        return wechatProfile
    }

    /**
     * 通过账户ID查询售后授权信息
     */
    private fun findWechatRefundAuthByAccountId(sellerAccountId: Long): WechatRefundAuth {
        val wechatRefundAuth = WechatRefundAuth()
        wechatRefundAuth.sellerAccountId = sellerAccountId

        //最后浪一次
        if(wechatRefundAuth.sellerAccountId == sellerAccountId) return wechatRefundAuth
        return wechatRefundAuth
    }
}