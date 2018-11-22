package com.loves.designModel.sixPrinciples.lod.version01;

import java.io.*;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Reader {
    int a,b;

    private String path;

    private BufferedReader br;

    public Reader(String path){
        this.path = path;
    }

    public void setBufferedReader() throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(path)));
    }

    public void readLine() throws NumberFormatException, IOException {
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
