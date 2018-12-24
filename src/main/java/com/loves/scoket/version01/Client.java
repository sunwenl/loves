package com.loves.scoket.version01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/24
 */
public class Client {

//创建 Socket:根据指定服务端的 IP 地址或端口号构造 Socket 类对 象。若服务器端响应，则建立客户端到服务器的通信线路。若连接失败，会出现异常。
    //打开连接到 Socket 的输入/出流: 使用 getInputStream()方法获得输 入流，使用 getOutputStream()方法获得输出流，进行数据传输
    //按照一定的协议对 Socket 进行读/写操作:通过输入流读取服务器 放入线路的信息(但不能读取自己放入线路的信息)，通过输出流 将信息写入线程。
    //关闭 Socket:断开客户端到服务器的连接，释放线路
    public static void main(String[] args) throws IOException {
        //客户端初始化一个socket  绑定服务器端ip，端口
        Socket socket=new Socket("127.0.0.1",8899);

        //获取OutputStream 并写入数据
        OutputStream out = socket.getOutputStream();
        out.write("hellos".getBytes());


        out.flush();
    }
}
