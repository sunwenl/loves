package com.loves.ioc.version001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用XML配置的方式实现IOC
 */
public class BookService {
    BookDAO bookDao;

    Book book;

    public BookService() {
        //容器
        ApplicationContext ctx=new ClassPathXmlApplicationContext("ioc/version001/IOCBeans01.xml");
        //从容器中获得id为bookDao的bean
        bookDao=(BookDAO)ctx.getBean("bookDao");

        book=(Book)ctx.getBean("book");
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
