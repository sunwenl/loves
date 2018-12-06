package com.loves.weixin.version001.bean;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 转账流水
 * @Author ：xiaoyijia.
 * @Date ：Created in 16:18 2018/12/5
 */
@Data
public class TransferJournal implements Serializable {

    /**
     * ID
     */
    private Long id;
    /**
     * 提现申请ID
     */
    private Long cashApplyId;
    /**
     * 状态码
     */
    private String code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 描述
     */
    private String des;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date createdAt;
}

