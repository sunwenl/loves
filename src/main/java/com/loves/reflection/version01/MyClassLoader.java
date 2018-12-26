package com.loves.reflection.version01;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/26
 *
 * 自定义类加载器
 */
public class MyClassLoader extends  ClassLoader{


    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return  super.loadClass(name);
    }


    public Class<?> loadFiles(String name) throws ClassNotFoundException {
        try {
            //byte[] data = loadFile(name);
            byte[] data = loadUrlFile(name);
            return super.defineClass(name, data, 0 , data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private byte[] loadFile(String name) throws  Exception{
        String result[] = name.split("\\.");
        System.err.println("-------result----"+result.toString());
        String names = result[result.length -1];
        System.err.println("--------names-----"+names);

        //把要传输的类 放在跟目录  /Users/sunwenlong/Downloads/Student.class
        File file = new File(" /Users/sunwenlong/Downloads/"+names+".class");
        InputStream in = new FileInputStream(file);

        ByteOutputStream bs = new ByteOutputStream();
        byte data[] = new byte[1024];//每次读取1024字节
        int length =0;//保存每次读取的长度
        while ((length = in.read(data)) != -1){
            bs.write(data, 0 ,length);
        }
        byte[] re = bs.toByteArray();//将所有的数据变成字节数组返回
        bs.close();
        in.close();
        return re;

    }

    private byte[] loadUrlFile(String name) throws  Exception{
        String result[] = name.split("\\.");
        System.err.println("-------result----"+result.toString());
        String names = result[result.length -1];
        System.err.println("--------names-----"+names);

        //服务器上面的类文件路径
        URL url = new URL("http://localhost:8080/xm1/Student.class");
        URLConnection urlConnection = url.openConnection();

        InputStream in =  urlConnection.getInputStream();

        ByteOutputStream bs = new ByteOutputStream();
        byte data[] = new byte[1024];//每次读取1024字节
        int length =0;//保存每次读取的长度
        while ((length = in.read(data)) != -1){
            bs.write(data, 0 ,length);
        }
        byte[] re = bs.toByteArray();//将所有的数据变成字节数组返回
        bs.close();
        in.close();
        return re;

    }
}
