package com.spring.learn.mySpring;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/9
 *
 * spring 解析bean
 */
public class MyClassPathXmlApplicationContext {

    private String xmlPath;

    public MyClassPathXmlApplicationContext(String xmlPath) {
       this.xmlPath = xmlPath;
    }
    /**
     * 读取xml文件加载bean
     */
    public Object getBean(String beanId) throws Exception{
        // spring 加载过程 或者spring ioc实现原理
        // 1.读取xml配置文件
        // 获取xml解析器
        SAXReader saxReader = new SAXReader();
        // this.getClass().getClassLoader().getResourceAsStream("xmlPath")
        // 获取当前项目路径
        Document dom = saxReader.read(this.getClass().getClassLoader().getResourceAsStream(xmlPath));

        //获取跟节点对象
        Element rootElement = dom.getRootElement();
        List<Element> elementList= rootElement.elements();
        Object obj = null;
        for (Element sonEle: elementList){
            // 2.获取到每个bean配置 获取class地址
            String sonBeanId = sonEle.attributeValue("id");
            if(!beanId.equals(sonBeanId)){
                continue;
            }
            String beanClassPath = sonEle.attributeValue("class");
            // 3.拿到class地址 进行反射实例化对象 ，使用反射api 为私有属性赋值
            Class forName = Class.forName(beanClassPath);
            //初始化对象
            obj = forName.newInstance();
            // 拿到成员属性
            List<Element> elements =sonEle.elements();
            for (Element element: elements){
                String name = element.attributeValue("name");
                String value = element.attributeValue("value");
                // 使用反射api 为私有属性赋值
                Field field = forName.getDeclaredField(name);
                //运行往私有成员赋值
                field.setAccessible(true);
                if(name.equals("id")){
                    int  valueInt = Integer.parseInt(value);
                    field.set(obj , valueInt);
                }else{
                    field.set(obj , value);
                }
            }
        }
        // 3.拿到class地址 进行反射实例化对象 ，使用反射api 为私有属性赋值
        return obj;
    }
}
