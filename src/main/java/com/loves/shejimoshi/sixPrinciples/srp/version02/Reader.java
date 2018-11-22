package com.loves.shejimoshi.sixPrinciples.srp.version02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Reader {
    int a, b;

    public Reader(String path) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        a = Integer.valueOf(br.readLine());
        b = Integer.valueOf(br.readLine());
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
