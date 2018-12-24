package com.loves.scoket.version01;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/24
 */
public class MyServer {

    //调用 ServerSocket(int port) :创建一个服务器端套接字,并绑定到指定端口上。用于监听客户端的请求。
    //调用 accept():监听连接请求，如果客户端请求连接，则 接受连接，返回通信套接字对象。
    //调用 该Socket类对象的 getOutputStream() 和 getInputStream ():获取输出流和输入流，开始网络数据 的发送和接收。
    //关闭ServerSocket和Socket对象:客户端访问结束，关闭 通信套接字。
    public static void main(String[] args)  throws UnknownHostException,IOException {

        //服务器端初始化一个socket，并设置ip，端口号
        ServerSocket serverSocket = new ServerSocket();
        //设置ip 端口
        InetAddress inetAddress = InetAddress.getByAddress(new byte[]{127,0,0,1});
        InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress, 8899);
        serverSocket.bind(inetSocketAddress);

        //保持等待，准备接收客户端的消息
        Socket socket = serverSocket.accept();

        //拉取数据
        InputStream inp =socket.getInputStream();
        byte[] buf = new byte[1024];
        int num = inp.read(buf);
        String str = new String(buf,0,num);


        System.out.println("ip为："+serverSocket.getInetAddress().toString() + "接收到的消息："+ str);

        //关闭链接
        socket.close();
        serverSocket.close();

    }
}
