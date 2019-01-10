package com.spring.learn.ioc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/9
 *
 * fastJson组装
 */
public class FastJsonTest2 {

    public static void main(String[] args) {
        JSONObject jsonObject0 = new JSONObject();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject.put("name","swl");
        jsonObject.put("url","baidu.com");
        jsonArray.add(jsonObject);
        jsonObject2.put("name","sss");
        jsonObject2.put("url","taobao.com");
        jsonArray.add(jsonObject2);
        jsonObject0.put("size",jsonArray);
        System.out.println(jsonObject0.toString());

    }
}
