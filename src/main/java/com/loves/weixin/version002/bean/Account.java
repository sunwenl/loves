package com.loves.weixin.version002.bean;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;
import java.util.Date;

/**
 * 账户管理
 * @Author ：xiaoyijia.
 * @Date ：Created in 17:12 2018/12/5
 */
@Data
public class Account implements Serializable {
    /**
     * ID
     */
    private Long id;
    /**
     * 账户的UUID
     */
    private String uuid;
    /**
     * 父账号的ID
     */
    private Long parentId;
    /**
     * 邀请人ID
     */
    private Long inviterId;
    /**
     * 邀请码
     */
    private String invitationCode;
    /**
     * 用户名
     */
    private String nickName;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;

    /**
     * 认证角色
     */
    private String authoritiesText;
    /**
     * 是否可以用
     */
    private boolean enabled;
    /**
     * 登录错误次数
     */
    private Integer errorCount;
    /**
     * 通过手机重置密码(密码找回)
     * 备注: 卖家运营账户,手机是基本信息,不作为登录使用
     */
    private String mobileResetPassword;
    /**
     * 通过邮箱重置密码(密码找回)
     * 备注: 卖家运营账户,邮箱是基本信息,不作为登录使用
     */
    private String emailResetPassword;
    /**
     * 标签位
     */
    private Long flag;
    /**
     * status
     *
     * @see AccountStatus
     */
    private Integer status;
    /**
     * 邀请时间
     */
    private Date invitedAt;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 修改时间
     */
    private Date updatedAt;

    /**
     * 上一次登录时间
     */
    private Date lastLoginAt;

    /**
     * APP设备标识，注册时候用，不保存数据库
     */
    private String deviceUniqueKey;

    /**
     * 账号的状态
     */
    public enum AccountStatus {
        /**
         * 正常
         */
        NORMAL("正常", 0),
        /**
         * 注册(未验证邮箱)
         */
        REGISTER("注册", 1),

        /**
         * 禁用(系统禁用)
         */
        DISABLE("禁用", 2),

        /**
         * 异常(多次登录失败)
         */
        ABNORMAL("异常", 3),
        /**
         * 废弃的（如：seller角色的account，却根据id找不到seller）
         */
        DISUSED("废弃", -11),
        /**
         * 入驻中
         */
        ENTERING("入驻中", -1),
        /**
         * 子账号被商家停用
         */
        STOPPED("停用", -2);


        // 成员变量
        private String name;
        private int index;

        // 构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
        AccountStatus(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 普通方法
        public static String getName(int index) {
            for (AccountStatus c : AccountStatus.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        // get set 方法
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public String getDisplayName() {
        if (StringUtils.isNotBlank(nickName)) {
            return nickName;
        } else if (StringUtils.isNotBlank(email)) {
            return email.substring(0, email.indexOf("@"));
        } else if (StringUtils.isNotBlank(mobile)) {
            return mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
        } else {
            return "匿名";
        }
    }

    /**
     * 获取父账户id，如果没有父账户 ，则返回自己的id
     * 适用情况：例，根据父账户的id才能查找Seller
     * Seller seller = sellerManager.findByParentId(account.getParentAccountId);
     *
     * @return 返回主账户id
     */
    public Long getMainAccountId() {
        return parentId == null ? id : parentId;
    }

}

