package com.loves.weixin.version001.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Utils
 *
 * @Author ：xiaoyijia.
 * @Date ：Created in 15:52 2018/12/5
 */
class MD5Utils {
    private MD5Utils() {
    }

    /**
     * 16进制的字符集
     */
    private final static char[] hexDigitsChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * MD5加密字符串
     *
     * @param source  源字符串
     * @param charset 字符集
     * @return 加密后的字符串
     */
    static String getMD5(String source, String charset) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        if (null == source || "".equals(source.trim())) {
            return null;
        }
        return getMD5(source.getBytes(charset));
    }

    /**
     * MD5加密以byte数组表示的字符串
     *
     * @param source 源字节数组
     * @return 加密后的字符串
     */
    private static String getMD5(byte[] source) throws NoSuchAlgorithmException {
        String s;

        final int temp = 0xf;
        final int arraySize = 32;
        final int strLen = 16;
        final int offset = 4;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(source);
        byte[] tmp = md.digest();
        char[] str = new char[arraySize];
        int k = 0;
        for (int i = 0; i < strLen; i++) {
            byte byte0 = tmp[i];
            str[k++] = hexDigitsChar[byte0 >>> offset & temp];
            str[k++] = hexDigitsChar[byte0 & temp];
        }
        s = new String(str);

        return s;
    }

}
