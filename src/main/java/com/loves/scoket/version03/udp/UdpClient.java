package com.loves.scoket.version03.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 * udp客户端
 */
public class UdpClient {
    public static void main(String[] args) throws Exception{
        System.out.println("udp 客户端启动");
        DatagramSocket ds = new DatagramSocket();
        String str = "客户端发送数据....。。。";
        byte[] strByte = str.getBytes();
        DatagramPacket dp = new DatagramPacket(strByte,strByte.length,InetAddress.getByName("127.0.0.1"),8888);
        ds.send(dp);
        ds.close();
    }
}
