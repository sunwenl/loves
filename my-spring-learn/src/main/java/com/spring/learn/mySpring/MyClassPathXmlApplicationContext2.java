package com.spring.learn.mySpring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/10
 *
 * bean 注入实例练习
 */
public class MyClassPathXmlApplicationContext2 {

    //初始化  获取xml文件
    private String xmlPath;
    MyClassPathXmlApplicationContext2(String xmlPath){
        this.xmlPath = xmlPath;
    }

    /**
     * 传入beanId  通过dom4j解析xml文件  匹配ID,获取class路径,
     * 反射加载class 初始化，并幅值
     * @param beanId 要获取的beanId
     * @return bean实例
     */
    Object getBean( String beanId) throws  Exception{
        Object obj = null;
        //dom4j解析xml文件
        SAXReader saxReader= new SAXReader();
        Document dom= saxReader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));

        Element element = dom.getRootElement();
        //获取子节点
        List<Element> elementList = element.elements();
        for(Element element1 : elementList){
            //获取id值
            String id = element1.attributeValue("id");
            if(!id.equals(beanId)){
                continue;
            }
            //获取class地址
            String clazzPath= element1.attributeValue("class");
            Class clazz = Class.forName(clazzPath);
            obj = clazz.newInstance();//反射调用class  实例化bean

            //获取配置的参数值
            List<Element> elementList2 = element1.elements();
            for (Element ele: elementList2){
                String name = ele.attributeValue("name");
                String value = ele.attributeValue("value");

                Field field = clazz.getDeclaredField(name);
                //设置私有属性可见
                field.setAccessible(true);
                if(name.equals("id")){
                    int valueInt = Integer.parseInt(value);
                    field.set(obj, valueInt);
                }else{
                    field.set(obj, value);
                }
            }
        }
        return obj;
    }
}
