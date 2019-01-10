package com.spring.learn.ioc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/9
 *
 * fastJson解析
 */
public class FastJsonTest {
    static String JSONSTR = "{\"sites\":[{\"name\":\"死亡率\",\"url\":\"www.baidu.com\"},{\"name\":\"嗡嗡嗡\",\"url\":\"http://taobao.com/\"}]}";

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        // 将json字符串转为jsonbject
        JSONObject jsonStrObject = jsonObject.parseObject(JSONSTR);
        JSONArray jsonArray = jsonStrObject.getJSONArray("sites");
        for (Object object : jsonArray){
            JSONObject jsonObje = (JSONObject) object;
            String name= jsonObje.getString("name");
            String url= jsonObje.getString("url");
            System.out.println(name+"----"+url);
        }

    }
}
