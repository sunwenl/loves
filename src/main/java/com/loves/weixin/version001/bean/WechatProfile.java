package com.loves.weixin.version001.bean;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信个人信息
 * @Author ：xiaoyijia.
 * @Date ：Created in 15:22 2018/12/5
 */
@Data
public class WechatProfile implements Serializable {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long accountId;
    /**
     * 是否订阅
     */
    private Boolean subscribe;
    /**
     * openId
     */
    private String openId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private String sex;
    /**
     * 语言
     */
    private String language;
    /**
     * 城市
     */
    private String city;
    /**
     * 省份
     */
    private String province;
    /**
     * 国家
     */
    private String country;
    /**
     * 头像
     */
    private String headImgUrl;
    /**
     * 订阅时间
     */
    private Long subscribeTime;
    /**
     * 唯一标示
     */
    private String unionId;
    /**
     * 性别
     */
    private Integer sexId;
    /**
     * 备注
     */
    private String remark;
    /**
     * 组号
     */
    private Integer groupId;
}
