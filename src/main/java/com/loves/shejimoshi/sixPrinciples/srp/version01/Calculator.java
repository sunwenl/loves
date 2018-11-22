package com.loves.shejimoshi.sixPrinciples.srp.version01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Calculator {
    public int add() throws NumberFormatException, IOException {
        File file = new File("/Users/Downloads/data.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        int a = Integer.valueOf(br.readLine());
        int b = Integer.valueOf(br.readLine());
        return a + b;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Calculator calculator = new Calculator();
        System.out.println("result:" + calculator.add());
    }
}
//
//总结：
//  来看上面这个例子，这个方法的作用是从一个文件中读出两个数，
//并返回它们的和，我相信各位也能看出当中有明显的多职责问题。
//如果没看出来的话，我想问各位一句，如果我想算这个文件中两个数字的差该如何做？
//
//  相信答案应该是我COPY出来一个div方法，把最后的加号改成减号。
//好吧，那我要除法呢？乘法呢？取模呢？COPY四次吗。
//这就造成了很多很多的代码重复，这不符合系统设计的规则。下面我把上述程序改善一下。
