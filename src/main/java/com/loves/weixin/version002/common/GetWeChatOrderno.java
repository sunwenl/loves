package com.loves.weixin.version002.common;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jdom.input.SAXBuilder;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 11:05 2018/12/6
 */
public class GetWeChatOrderno {
    private final static Logger logger = LoggerFactory.getLogger(GetWeChatOrderno.class);


    private static SSLConnectionSocketFactory webSSlConnectionSocketFactory;
    private static SSLConnectionSocketFactory appSSlConnectionSocketFactory;

    //SSLConnectionSocketFactory
    private static SSLConnectionSocketFactory socketFactory = null;
    private static PoolingHttpClientConnectionManager connectionManager = null;
    private static RequestConfig defaultRequestConfig = null;

    //重写验证方法，取消检测SSL
    private static TrustManager manager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    /**
     * 获取扫码支付链接
     *
     * @param url      微信支付下单url
     * @param xmlParam xml参数
     * @return 扫码支付链接
     */
    public static String getCodeUrl(String url, String xmlParam) {
        if (socketFactory == null) {
            initSocketFactory();
        }

        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(defaultRequestConfig).build();

        HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
        HttpResponse response = null;
        String code_url = "";
        try {
            httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            response = httpClient.execute(httpost);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            if (jsonStr.contains("FAIL")) {
                logger.error("##ERROR:wechat generating faile[return_msg:" + jsonStr + "][xmParam:" + xmlParam + "]");
                return code_url;
            }
            Map map = doXMLParse(jsonStr);
            code_url = (String) map.get("code_url");
        } catch (Exception e) {
            logger.error("##ERROR:wechat url generating failed[xmParam:" + xmlParam + "]", e);

        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("微信接口调用失败", e);
                }
            }
        }

        return code_url;
    }

    /**
     * to send request, and analysis response
     *
     * @param url      : request url
     * @param xmlParam : request packages
     * @return map by analysis response
     * @since 2016.03.31.22.13
     */
    public static Map sendRequest(String url, String xmlParam) {

        if (socketFactory == null) {
            initSocketFactory();
        }
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(defaultRequestConfig).build();

        HttpPost httpost = HttpClientConnectionManager.getPostMethod(url);
        Map map = null;
        CloseableHttpResponse response = null;

        try {
            httpost.setEntity(new StringEntity(xmlParam, "UTF-8"));
            response = httpClient.execute(httpost);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info("##ERROR:jsonStr:" + jsonStr);
            if (jsonStr.contains("FAIL")) {
                return null;
            }
            map = doXMLParse(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("微信接口调用失败", e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("微信接口调用失败", e);
                }
            }
        }
        return map;
    }

    public static String sendGetRequest(String url) {
        if (socketFactory == null) {
            initSocketFactory();
        }
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(defaultRequestConfig).build();

        HttpGet httpGet = HttpClientConnectionManager.getGetMethod(url);
        String jsonStr = "";
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpGet);
            jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            logger.info("##WXAPP_INFO:jsonStr:" + jsonStr);

            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("微信接口调用失败", e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("微信接口调用失败", e);
                }
            }
        }
        return jsonStr;
    }

    public static synchronized Map sendRefundRequest(Integer paymentType, String url, String mchId, String xmlParam) {
        CloseableHttpClient proxyHttpClient;
        if (paymentType.equals(2)) {
            //原生扫码支付 账号证书文件
            InputStream inputStream = null;
            try {
                if (webSSlConnectionSocketFactory == null) {
                    KeyStore keyStore = KeyStore.getInstance("PKCS12");
                    //读取本机存放的PKCS12证书文件
                    //inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("cert/apiclient_cert_native.p12");
                    //阿里云ClassLoader取不到,用相对路径
                    inputStream = new FileInputStream(new File("cert/apiclient_cert_native.p12"));
                    keyStore.load(inputStream, mchId.toCharArray());
                    SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
                    webSSlConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
                }
                proxyHttpClient = HttpClients.custom().setSSLSocketFactory(webSSlConnectionSocketFactory).build();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("微信读取原生证书失败", e);
                return null;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("微信读取原生证书失败", e);
                    }
                }
            }

        } else {
            //APP支付 账号证书文件
            InputStream inputStream = null;
            try {
                if (appSSlConnectionSocketFactory == null) {
                    KeyStore keyStore = KeyStore.getInstance("PKCS12");
                    //读取本机存放的PKCS12证书文件
                    //inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("/cert/apiclient_cert_app.p12");
                    //阿里云ClassLoader取不到,用相对路径
                    inputStream = new FileInputStream(new File("cert/apiclient_cert_app.p12"));
                    keyStore.load(inputStream, mchId.toCharArray());
                    SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
                    appSSlConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
                }
                proxyHttpClient = HttpClients.custom().setSSLSocketFactory(appSSlConnectionSocketFactory).build();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("微信读取移动证书失败", e);
                return null;
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error("微信读取移动证书失败", e);
                    }
                }
            }
        }

        HttpPost httPost = new HttpPost(url); // 设置响应头信息
        Map map = null;
        CloseableHttpResponse response = null;
        try {
            StringEntity stringEntity = new StringEntity(xmlParam, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httPost.setEntity(stringEntity);
            response = proxyHttpClient.execute(httPost);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            map = doXMLParse(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("微信接口调用失败", e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("微信接口调用失败", e);
                }
            }
        }
        return map;
    }

    public static synchronized Map sendRefundRequestForMp(String url, String mchId, String xmlParam, byte[] keyByte) {
        CloseableHttpClient proxyHttpClient;

        //APP支付 账号证书文件
        InputStream inputStream = null;
        try {
            if (appSSlConnectionSocketFactory == null) {
                KeyStore keyStore = KeyStore.getInstance("PKCS12");
                //读取本机存放的PKCS12证书文件
                inputStream = new ByteArrayInputStream(keyByte);
                keyStore.load(inputStream, mchId.toCharArray());
                SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
                appSSlConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
            }
            proxyHttpClient = HttpClients.custom().setSSLSocketFactory(appSSlConnectionSocketFactory).build();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("商家独立小程序微信读取移动证书失败", e);
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("商家独立小程序微信读取移动证书失败", e);
                }
            }
        }

        HttpPost httPost = new HttpPost(url); // 设置响应头信息
        Map map = null;
        CloseableHttpResponse response = null;
        try {
            StringEntity stringEntity = new StringEntity(xmlParam, "UTF-8");
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/x-www-form-urlencoded");
            httPost.setEntity(stringEntity);
            response = proxyHttpClient.execute(httPost);
            String jsonStr = EntityUtils.toString(response.getEntity(), "UTF-8");
            map = doXMLParse(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("商家独立小程序微信接口调用失败", e);
        } finally {
            if (response != null) {
                try {
                    EntityUtils.consume(response.getEntity());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("商家独立小程序微信接口调用失败", e);
                }
            }
        }
        return map;
    }

    /**
     * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
     *
     * @param strxml XML
     * @return MAP
     * @throws Exception e
     */
    public static Map doXMLParse(String strxml) throws Exception {
        if (null == strxml || "".equals(strxml)) {
            return null;
        }

        Map m = new HashMap();
        InputStream in = String2Inputstream(strxml);
        SAXBuilder builder = new SAXBuilder();
        //微信支付商户，如果你在使用支付业务回调通知中，存在以下场景，有使用XML解析的情况，
        //请务必检查是否对XML外部实体注入漏洞(XML External Entity Injection，简称 XXE)进行了防范。
        //@see https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=23_5
        //@see https://www.owasp.org/index.php/XML_External_Entity_(XXE)_Prevention_Cheat_Sheet#C.2FC.2B.2B
        builder.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        builder.setFeature("http://xml.org/sax/features/external-general-entities", false);
        builder.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        Document doc = builder.build(in);
        Element root = doc.getRootElement();
        List list = root.getChildren();
        for (Object aList : list) {
            Element e = (Element) aList;
            String k = e.getName();
            String v;
            List children = e.getChildren();
            if (children.isEmpty()) {
                v = e.getTextNormalize();
            } else {
                v = getChildrenText(children);
            }

            m.put(k, v);
        }

        //关闭流
        in.close();

        return m;
    }

    /**
     * 获取子结点的xml
     *
     * @param children List
     * @return String
     */
    public static String getChildrenText(List children) {
        StringBuilder sb = new StringBuilder();
        if (!children.isEmpty()) {
            for (Object aChildren : children) {
                Element e = (Element) aChildren;
                String name = e.getName();
                String value = e.getTextNormalize();
                List list = e.getChildren();
                sb.append("<").append(name).append(">");
                if (!list.isEmpty()) {
                    sb.append(getChildrenText(list));
                }
                sb.append(value);
                sb.append("</").append(name).append(">");
            }
        }

        return sb.toString();
    }

    public static InputStream String2Inputstream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    /**
     * 初始化SocketFactory
     */
    private static void initSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{manager}, null);
            socketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

        RequestConfig.Builder builder = RequestConfig.custom();
        //设置连接超时时间;从connect Manager获取Connection;超时时间请求获取数据的超时时间;单位毫秒
        builder.setConnectTimeout(10000).setConnectionRequestTimeout(10000).setSocketTimeout(10000);
        defaultRequestConfig = builder.setCookieSpec(CookieSpecs.STANDARD_STRICT).build();
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", PlainConnectionSocketFactory.INSTANCE).register("https", socketFactory).build();
        connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        //配置最大连接数
        connectionManager.setMaxTotal(100);
        //并发数
        connectionManager.setDefaultMaxPerRoute(50);
    }

}