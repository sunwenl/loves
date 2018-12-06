package com.loves.weixin.version001.services

import com.loves.weixin.version001.TransferController
import com.loves.weixin.version001.bean.TransferJournal
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

/**
 * @Author     ：xiaoyijia.
 * @Date       ：Created in 15:30 2018/12/5
 */
class WxTransferService @Autowired constructor(val wechatService: WechatService){

    private val logger = LoggerFactory.getLogger(TransferController::class.java)

    fun transfer(paramMap: Map<String, Any>, certByteAry: ByteArray): Boolean {

        logger.info("*** transfer paramMap:{} ***", paramMap)

        val cashApplyId = paramMap["partner_trade_no"].toString().toLong()
        val mchid = paramMap["mchid"].toString()

        //转账请求操作
        val resultMap = wechatService.transfer(paramMap, certByteAry)
        if ("SUCCESS".equals(resultMap["return_code"].toString(), ignoreCase = true) && "SUCCESS".equals(resultMap["result_code"].toString(), ignoreCase = true)) {
            saveSuccessTransferJournal(cashApplyId, mchid, resultMap)
            //此处修改提现申请流程逻辑
//            cashApplyService.handleWeChatReceivedMoney(cashApplyId)
            return true
        }
        if ("FAIL".equals(resultMap["result_code"].toString(), ignoreCase = true) && "SYSTEMERROR".equals(resultMap["err_code"].toString(), ignoreCase = true)) {

            val infoParamMap = TreeMap<String, Any?>()
            infoParamMap["nonce_str"] = paramMap["nonce_str"]
            infoParamMap["partner_trade_no"] = paramMap["partner_trade_no"]
            infoParamMap["mch_id"] = paramMap["mch_id"]
            infoParamMap["appid"] = paramMap["mch_appid"]

            val findResultMap = wechatService.findTransferInfo(paramMap, certByteAry)
            logger.info("*** findResultMap:{} ***", findResultMap)
            val status = findResultMap["status"]
            if (null != status && status == "SUCCESS") {
                saveSuccessTransferJournal(cashApplyId, mchid, resultMap)
                //此处修改提现申请流程逻辑
//                cashApplyService.handleWeChatReceivedMoney(cashApplyId)
                return true
            }
        }
        saveFailTransferJournal(cashApplyId, mchid, resultMap)
        return false
    }

    private fun saveSuccessTransferJournal(cashApplyId: Long, mchId: String, resultMap: Map<*, *>) {
        logger.info("*** saveTransferJournal cashApplyId:{},resultMap:{} ***", cashApplyId, resultMap)

        val amount = resultMap["amount"].toString()

        val paymentNo = resultMap["payment_no"].toString()
        //返回信息
        val msg = resultMap["return_msg"].toString()

        val transferJournal = TransferJournal()
        transferJournal.cashApplyId = cashApplyId
        transferJournal.msg = msg
        transferJournal.remark = "转账成功:mchId=$mchId paymentNo=$paymentNo amount=$amount"
        //此处保存转账成功流水
//        transferJournalRepository.save(transferJournal)

    }

    /**
     * 保存失败记录
     */
    private fun saveFailTransferJournal(cashApplyId: Long, mchId: String, resultMap: Map<*, *>) {

        logger.info("*** saveTransferJournal cashApplyId:{},resultMap:{} ***", cashApplyId, resultMap)

        //状态码
        val code = resultMap["err_code"].toString()
        //返回信息
        val msg = resultMap["return_msg"].toString()
        //错误代码
        val errCode = resultMap["err_code"]?.toString()
        //错误代码描述
        val errCodeDes = resultMap["err_code_des"]?.toString()

        val transferJournal = TransferJournal()
        transferJournal.cashApplyId = cashApplyId
        transferJournal.code = code
        transferJournal.msg = msg
        transferJournal.des = errCode + " " + errCodeDes
        transferJournal.remark = "转账失败:mchId=" + mchId
        //此处保存失败记录至数据库
//        transferJournalRepository.save(transferJournal)
    }
}