package com.loves.weixin.version002.common;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.writer.Delta;
import org.springframework.boot.actuate.metrics.writer.MetricWriter;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @Author ：xiaoyijia.
 * @Date ：Created in 11:20 2018/12/6
 */
@Component("tradeCashierErrors")
public class TradeCashierErrors {

    /**
     * bundle FQN
     */
    @NonNls
    private static final String BUNDLE_FQN = "i18n.TradeCashierErrors";
    /**
     * resource bundle
     */
    private static ResourceBundle ourBundle = ResourceBundle.getBundle(BUNDLE_FQN, new Locale("en", "US"));
    @Autowired(required = false)
    private MetricWriter writer;

    /**
     * 获取resource bundle中对应的bundle值
     *
     * @param key    bundle key
     * @param params 参数，bundle的值采用MessageFormat的格式化方式
     * @return bundle值，如果bundle key不存在，返回特定key丢失格式
     */
    public String message(@PropertyKey(resourceBundle = BUNDLE_FQN) String key, Object... params) {
        String value;
        try {
            value = ourBundle.getString(key);
            if (writer != null) {
                this.writer.increment(new Delta<>("errors." + key, 1L));
            }
        } catch (MissingResourceException ignore) {
            value = "!!!" + key + "!!!";
        }
        if (params != null && params.length > 0 && value.indexOf('{') >= 0) {
            value = MessageFormat.format(value, params);
        }
        return key + ": " + value;
    }
}