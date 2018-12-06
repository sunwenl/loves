package com.loves.weixin.version001.common;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.springframework.util.ObjectUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.net.ssl.SSLContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.*;

/**
 * 微信支付工具类
 *
 * @Author ：xiaoyijia.
 * @Date ：Created in 15:43 2018/12/5
 */
public class WXPayUtil {
    private WXPayUtil() {
    }

    /**
     * 默认字符集
     */
    private static final String DEFAULT_ChARSET = "UTF-8";
    /**
     * 转账URL
     */
    public static final String TRANSFERS_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
    /**
     * 查询装账信息URL
     */
    public static final String GET_TRANSFER_INFO_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo";

    /**
     * 生成随机字符串 nonce_str
     */
    public static String generateNonceStr(int length) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").substring(0, length);
    }

    /**
     * 获取本机IP地址
     */
    public static String getLocalIpAddr() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }

    /**
     * 生成签名 sign
     *
     * @return 签名
     */
    public static String generateSign(Map<String, Object> paramMap) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        String key = paramMap.get("key").toString();
        StringBuffer buffer = new StringBuffer();
        Collection<String> keySet = paramMap.keySet();
        List<String> list = new ArrayList<>(keySet);
        //对key键值按字典升序排序
        Collections.sort(list);
        for (String k : list) {
            Object value = paramMap.get(k);
            if (ObjectUtils.isEmpty(value) || "sign".equals(k) || "key".equals(k)) {
                continue;
            }
            buffer.append(k).append("=").append(value).append("&");
        }
        //最后拼接KEY
        buffer.append("key").append("=").append(key);
        return MD5Utils.getMD5(buffer.toString(), DEFAULT_ChARSET).toUpperCase();
    }

    /**
     * 获取证书请求客户端
     */
    public static CloseableHttpClient getSSLHttpClient(byte[] certByteAry, String pwd) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, ClassNotFoundException {

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(new ByteArrayInputStream(certByteAry), pwd.toCharArray());
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, pwd.toCharArray()).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    /**
     * 转换为xml字符串
     */
    private  static String convertMapToXml(Map<String, Object> map) {

        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml>");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            buffer.append("<").append(entry.getKey()).append(">").append(entry.getValue()).append("</").append(entry.getKey()).append(">");
        }
        buffer.append("</xml>");
        return buffer.toString();
    }

    /**
     * post 请求
     */
    public static Map<String, Object> post(CloseableHttpClient httpClient, Map<String, Object> paramMap, String wxapiURL) throws IOException, ParserConfigurationException, SAXException {

        HttpPost httpPost = new HttpPost(wxapiURL);
        System.out.println("executing request" + httpPost.getRequestLine());
        httpPost.setEntity(new StringEntity(convertMapToXml(paramMap), DEFAULT_ChARSET));

        CloseableHttpResponse response = null;
        String jsonStr;
        try {
            response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            EntityUtils.consume(httpEntity);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return xmlToMap(jsonStr);
    }

    private static Map<String, Object> xmlToMap(String xmlStr) throws ParserConfigurationException, IOException, SAXException {

        Map<String, Object> data = new HashMap<>();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        try (InputStream stream = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"))) {
            Document doc = documentBuilder.parse(stream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int id = 0; id < nodeList.getLength(); id++) {
                Node node = nodeList.item(id);
                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                Element element = (Element) node;
                data.put(element.getNodeName(), element.getTextContent());
            }
        }
        return data;

    }

}
