package com.loves.weixin.version001.bean;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 15:13 2018/12/5
 * 商家小程序相关信息
 */
@Data
public class SellerMiniApp implements Serializable {

    /**
     * ID
     */
    private Long id;
    /**
     * 账户ID
     */
    private Long accountId;
    /**
     * 小程序ID
     */
    private String appId;
    /**
     * 应用秘钥
     */
    private String appSecret;
    /**
     * 微信支付商户号
     */
    private String mchid;
    /**
     * API密钥
     */
    private String apiKey;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 修改时间
     */
    private Date updatedAt;

}
