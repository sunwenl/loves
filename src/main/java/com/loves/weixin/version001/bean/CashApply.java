package com.loves.weixin.version001.bean;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 提现申请表
 *
 * @author sunWenLong
 * @data 2018/8/1
 */
@Data
public class CashApply implements Serializable {
    /**
     * 主键
     */
    private Long id;
    /**
     * 商家ID
     */
    private Long sellerAccountId;
    /**
     * 分销员账户ID
     */
    private Long accountId;
    /**
     * 分销员用户名
     */
    private String userName;
    /**
     * 提现手机号
     */
    private String takeMobile;
    /**
     * 金额
     */
    private BigDecimal amount;
    /**
     * 申请时间 yyyyMM
     */
    private String applyDate;
    /**
     * 状态   5待审核/10审核通过/15审核驳回
     */
    private Integer status;
    /**
     * 结算方式 自动结算/人工结算
     */
    private Integer settlementType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
    private Date createdAt;

    private Date updatedAt;

    /**
     * 待审核/审核通过/审核驳回
     */
    @AllArgsConstructor
    @Getter
    public enum Status {
        /**
         * 待审核
         */
        WAIT_EXAMINE(5, "待审核"),
        /**
         * 审核通过
         */
        EXAMINE_ADOPT(10, "审核通过"),
        /**
         * 审核驳回
         */
        EXAMINE_REJECT(15, "审核驳回"),
        /**
         * 已到账
         */
        RECEIVED_MONEY(20, "已到账");

        private int code;

        private String name;
    }
}