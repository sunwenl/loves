package com.loves.designModel.structureModel.decoratorPattern.version01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author ：SunWenLong
 * @Date ：2018/12/25
 * 被装饰对象
 */
public class Source implements  DecInterface{
    @Override
    public void doSomeThing() {
        System.out.println("开始做事");
        try {
            InputStream in =new FileInputStream("/user/text.txt");
            InputStream bufIn =  new BufferedInputStream(in);
            in.read();

            bufIn.read();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
