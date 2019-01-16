package com.loves.scoket.version03.tcp;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 * 客户端
 */
public class TcpClient {
    public static void main(String[] args) throws  Exception{
        System.out.println("socket客户端启动....");
        Socket s = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = s.getOutputStream();
        outputStream.write("我是客戶端....".getBytes());
        s.close();
    }
}
