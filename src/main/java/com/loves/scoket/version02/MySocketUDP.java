package com.loves.scoket.version02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/24
 */
public class MySocketUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(8890,InetAddress.getByName("127.0.0.1"));
        byte[] by = new byte[1024];
        DatagramPacket dp = new DatagramPacket(by, by.length);
        System.out.println("准备接收");
        //执行此方法后 挂起  直到接收到消息
        ds.receive(dp);
        System.out.println("接收中");
        String str = new String(dp.getData(), 0, dp.getLength());
        System.out.println(str + "--" + dp.getAddress());
        ds.close();
        System.out.println("接收完毕");
    }
}
