//package com.loves.weixin.version002.bean;
//
//import lombok.Getter;
//import lombok.Setter;
//
///**
// * 支付方式
// * @Author ：xiaoyijia.
// * @Date ：Created in 14:49 2018/12/6
// */
//public enum Payment {
//    /**
//     * 免单
//     */
//    NO_CHARGE(0, "免单"),
//    /**
//     * 支付宝
//     */
//    ALI_PAY(1, "支付宝"),
//    /**
//     * 微信扫码
//     */
//    WECHAT_PAY(2, "微信(扫码)"),
//    /**
//     * 微信APP支付
//     */
//    WECHAT_PAY_APP(3, "微信(APP)"),
//    /**
//     * 微信(小程序)
//     */
//    WECHAT_SMALL(4, "微信(小程序)");
//
//    @Getter
//    @Setter
//    private int value;
//    @Getter
//    @Setter
//    private String name;
//
//    Payment(int value, String name) {
//        this.value = value;
//        this.name = name;
//    }
//
//    public static String getName(Integer value) {
//        for (Payment payment : Payment.values()) {
//            if (payment.getValue() == value) {
//                return payment.getName();
//            }
//        }
//
//        return null;
//    }
//}
