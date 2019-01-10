package com.spring.learn.ioc;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/9
 *
 * dom4j解析xml 学习
 */
public class Dom4jTest {
//    解析XML过程是通过获取Document对象，然后继续获取各个节点以及属性等操作，因此获取Document对象是第一步，大体说来，有三种方式：
//            1.自己创建Document对象
//    Document document = DocumentHelper.createDocument();
//    Element root = document.addElement("students");
//    其中students是根节点，可以继续添加其他节点等操作。
//            2.自己创建Document对象
//    // 创建SAXReader对象
//    SAXReader reader = new SAXReader();
//    // 读取文件 转换成Document
//    Document document = reader.read(new File("XXXX.xml"));
//3.读取XML文本内容获取Document对象
//    String xmlStr = "<students>......</students>";
//    Document document = DocumentHelper.parseText(xmlStr);

//SAXReader saxReader = new SAXReader();
//    Document read = saxReader.read(new File("E://work//spring-ioc//src//main//resources//stu.xml"));
//    // 获取根节点
//    Element rootElement = read.getRootElement();
//    getNodes(rootElement);
//}
//    static public void getNodes(Element rootElement) {
//        System.out.println("当前节点名称:" + rootElement.getName());
//        // 获取属性ID
//        List<Attribute> attributes = rootElement.attributes();
//        for (Attribute attribute : attributes) {
//            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
//        }
//        if (!rootElement.getTextTrim().equals("")) {
//            System.out.println(rootElement.getName() + "--" + rootElement.getText());
//        }
//        // 使用迭代器遍历
//        Iterator<Element> elementIterator = rootElement.elementIterator();
//        while (elementIterator.hasNext()) {
//            Element next = elementIterator.next();
//            getNodes(next);
//        }
//    }
//    注意: this.getClass().getClassLoader().getResourceAsStream(xmlPath) 获取当前项目路径xmlfsfs

    public static void main(String[] args) throws  Exception{
        SAXReader saxReader = new SAXReader();

        Document dom = saxReader.read(new File("/Users/sunwenlong/Downloads/workspaces/my-work/my-work--001/loves/my-spring-learn/src/main/java/com/spring/learn/ioc/sida.xml"));
        //获取根节点
        Element rootElement = dom.getRootElement();
        getNodes(rootElement);
    }
    static public void getNodes(Element rootElement) {
        System.out.println("当前节点名称:"+rootElement.getName());
        // 获取属性ID
        List<Attribute> list = rootElement.attributes();
        for (Attribute attribute : list){
            System.out.println("属性:" + attribute.getName() + "---" + attribute.getText());
        }
        if (!rootElement.getTextTrim().equals("")) {
            System.out.println(rootElement.getName() + "--" + rootElement.getText());
        }
        // 使用迭代器遍历
        Iterator<Element> elementIterator = rootElement.elementIterator();
        while (elementIterator.hasNext()) {
            Element next = elementIterator.next();
            getNodes(next);
        }
    }
}
