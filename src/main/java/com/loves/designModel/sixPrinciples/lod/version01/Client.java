package com.loves.designModel.sixPrinciples.lod.version01;

/**
 * @Author ：SunWenLong
 * @Date ：2018/11/22
 */
public class Client {
    public static void main(String[] args) throws Exception {
        // Reader类改成上述这个样子，显然它给其他的类透漏了太多细节，让别人知道了它的太多细节，
        // 这样我客户端调用的时候就很可能写成如下形式。
        Reader reader = new Reader("/Users/Downloads/data.txt");
        reader.setBufferedReader();
        reader.readLine();
        int a = reader.getA();
        int b = reader.getB();
        //以下用于计算等等

        //改写后
        Reader02 reader02 = new Reader02("/Users/Downloads/data.txt");
        int newA = reader.getA();
        int newB = reader.getB();
    }
}
