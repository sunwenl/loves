package com.loves.weixin.version001.bean;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

/**
 * 商家小程序退款授权信息
 *
 * @Author ：xiaoyijia.
 * @Date ：Created in 15:27 2018/12/5
 */
@Data
public class WechatRefundAuth implements Serializable {

    /**
     * ID
     */
    private Long id;
    /**
     * 账户ID
     */
    private Long sellerAccountId;
    /**
     * 授权文件路径，保存文件名
     */
    private byte[] authFile;
    /**
     * 授权文件名称
     */
    private String fileName;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 修改时间
     */
    private Date updatedAt;

    /**
     * 状态 0授权失败 1授权成功
     */
    public enum Status {

        /**
         * 授权失败
         */
        FAILED(0, "授权失败"),

        /**
         * 授权成功
         */
        ACTIVE(1, "授权成功");


        @Getter
        @Setter
        private int code;

        @Getter
        @Setter
        private String name;

        Status(int code, String name) {
            this.code = code;
            this.name = name;
        }
    }
}
