package com.loves.io;

import java.io.*;

public class FileLearn {

    public static void main(String[] args) throws  Exception{
        //创建一个文件对象，使之与一个文件关联
         File file = new File("/Users/sunwenlong/Downloads/settings.xml");
        //显示与文件有关的属性信息
         System.out.println("文件或目录是否存在:" + file.exists());
         System.out.println("是文件吗:" + file.isFile());
         System.out.println("是目录吗:" + file.isDirectory());
         System.out.println("名称:" + file.getName());
         System.out.println("绝对路径:" + file.getAbsolutePath());
         System.out.println("文件大小:" + file.length());


         //******************FileInputStream 的使用******************
        //创建文件对象
        File files = new File("/Users/sunwenlong/Downloads/settings.xml");
        //使用文件对象创建文件输出流对象 相当于打开对象
        FileInputStream fileInputStream = new FileInputStream(files);


    }
}
