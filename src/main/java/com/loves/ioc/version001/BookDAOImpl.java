package com.loves.ioc.version001;

public class BookDAOImpl implements BookDAO {
    /**
     * 图书数据访问实现类
     */
    public String addBook(String bookName) {
        return "添加图书" + bookName + "成功！";
    }
}
