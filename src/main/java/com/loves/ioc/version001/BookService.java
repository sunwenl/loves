package com.loves.ioc.version001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 使用XML配置的方式实现IOC
 */
public class BookService {
    BookDAO bookDao;

    Book book;

    public BookService() {
//        ClassPathXmlApplicationContext 默认文件路径是src下那一级
//        classpath:和classpath*:的区别:
//        classpath: 只能加载一个配置文件,如果配置了多个,则只加载第一个
//        classpath*: 可以加载多个配置文件,如果有多个配置文件,就用这个
//
//        FileSystemXmlApplicationContext
//        这个类,默认获取的是项目路径,默认文件路径是项目名下一级，与src同级。
//        如果前边加了file:则说明后边的路径就要写全路径了,就是绝对路径
//        file:D:/workspace/applicationContext.xml

        //FileSystemXmlApplicationContext方式读取加载配置文件
        ApplicationContext ctx=new FileSystemXmlApplicationContext ("loves/src/main/resources/ioc/version001/IOCBeans01.xml");
        ApplicationContext ctx1=new FileSystemXmlApplicationContext("classpath:ioc/version001/IOCBeans01.xml");

        //ClassPathXmlApplicationContext方式读取加载配置文件
        ApplicationContext ctx2=new ClassPathXmlApplicationContext ("classpath:ioc/version001/IOCBeans01.xml");
        ApplicationContext ctx3=new ClassPathXmlApplicationContext ("ioc/version001/IOCBeans01.xml");

        //XmlWebApplicationContext方式读取加载配置文件
        //默认的路径/WEB-INF/applicationContext.xml
        XmlWebApplicationContext ctx4=new XmlWebApplicationContext();
        //重新设置路径
        ctx4.setConfigLocations("classpath:ioc/version001/IOCBeans01.xml");
        //设置完需要刷新重新加载
        ctx4.refresh();

        //从容器中获得id为bookDao的bean
        bookDao=(BookDAO)ctx4.getBean("bookDao");
        book=(Book)ctx4.getBean("book");
    }

    public void storeBook(String bookName){
        System.out.println("图书上货");
        String result=bookDao.addBook(bookName);
        System.out.println(result);

        System.out.println(book.toString());
    }

    public static void main(String[] args) {
        BookService bookservice=new BookService();
        bookservice.storeBook("《Spring MVC权威指南 第一版》");
    }
}
