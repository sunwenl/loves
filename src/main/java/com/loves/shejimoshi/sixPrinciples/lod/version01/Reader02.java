package com.loves.shejimoshi.sixPrinciples.lod.version01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 这样客户端就依赖于reader的多个行为才能最终获取到A和B两个数值，
 * 这时候两个类的耦合度就太高了，
 * 我们更好的做法使用访问权限限制将二者都给隐藏起来不让外部调用的类知道这些。就像下面这样。
 *
 * 我们最终将两个方法都变为私有封装在Reader02类当中，这样外部的类就无法知道这两个方法了，
 * 所以迪米特原则虽说是指的一个类应当尽量不要知道其他类太多细节，但其实更重要的是一个类应当不要让外部的类知道自己太多。
 * 两者是相辅相成的，只要你将类的封装性做的很好，那么外部的类就无法依赖当中的细节。
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Reader02 {
    int a,b;
    private String path;
    private BufferedReader br;
    public Reader02(String path) throws Exception{
        super();
        this.path = path;
        setBufferedReader();
        readLine();
    }
    //注意，我们变为私有的方法
    private void setBufferedReader() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(path));
    }
    //注意，我们变为私有的方法
    private void readLine() throws NumberFormatException, IOException {
        a = Integer.valueOf(br.readLine());
        b = Integer.valueOf(br.readLine());
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }
}
