//package com.loves.weixin.version001.services;
//
//import com.loves.weixin.version001.TransferController;
//import com.loves.weixin.version001.common.WXPayUtil;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.xml.sax.SAXException;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.IOException;
//import java.security.KeyManagementException;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.UnrecoverableKeyException;
//import java.security.cert.CertificateException;
//import java.util.Map;
//
///**
// * @Author ：xiaoyijia.
// * @Date ：Created in 15:39 2018/12/5
// */
//public class WechatService {
//    private Logger logger = LoggerFactory.getLogger(TransferController.class);
//    /**
//     * 转账
//     */
//    public Map<String, Object> transfer(Map<String, Object> paramMap, byte[] certByteAry) {
//
//        logger.info("*** paramMap:{} ***", paramMap);
//
//        Map<String, Object> responseMap;
//        try {
//            paramMap.put("nonce_str", WXPayUtil.generateNonceStr(32));
//            paramMap.put("spbill_create_ip", WXPayUtil.getLocalIpAddr());
//
//            String mchid = paramMap.get("mchid").toString();
//
//            String sign = WXPayUtil.generateSign(paramMap);
//            logger.info("*** sign:{} ***", sign);
//            paramMap.put("sign", sign);
//
//            CloseableHttpClient httpclient = WXPayUtil.getSSLHttpClient(certByteAry, mchid);
//            responseMap = WXPayUtil.post(httpclient, paramMap, WXPayUtil.TRANSFERS_URL);
//            logger.info("*** responseMap:{} ***", responseMap);
//            return responseMap;
//        } catch (CertificateException | ClassNotFoundException | NoSuchAlgorithmException | ParserConfigurationException | UnrecoverableKeyException | KeyStoreException | SAXException | KeyManagementException | IOException e) {
//            logger.error(e.getMessage(), e);
//            return null;
//        }
//    }
//
//    /**
//     * 查询申请转账信息
//     *
//     * @param paramMap 参数Map
//     * @return
//     */
//    public Map<String, Object> findTransferInfo(Map<String, Object> paramMap, byte[] certByteAry) {
//
//        String mchid = paramMap.get("mchid").toString();
//
//        CloseableHttpClient httpclient;
//        try {
//            String sign = WXPayUtil.generateSign(paramMap);
//            paramMap.put("sign", sign);
//            httpclient = WXPayUtil.getSSLHttpClient(certByteAry, mchid);
//            Map<String, Object> responseMap = WXPayUtil.post(httpclient, paramMap, WXPayUtil.GET_TRANSFER_INFO_URL);
//            return responseMap;
//        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | ClassNotFoundException | KeyManagementException | UnrecoverableKeyException | SAXException | ParserConfigurationException e) {
//            logger.error(e.getMessage(), e);
//            return null;
//        }
//    }
//}
