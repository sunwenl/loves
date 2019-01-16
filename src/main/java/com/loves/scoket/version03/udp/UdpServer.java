package com.loves.scoket.version03.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author ：SunWenLong
 * @Date ：2019/1/14
 *
 * UDP服务器端代码
 */
public class UdpServer {
    public static void main(String[] args) throws Exception{
        System.out.println("udp服务器已启动.......");
        DatagramSocket ds = new DatagramSocket(8888);
        byte [] buf = new byte[1024];

        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        // 阻塞效果
        ds.receive(dp);
        System.out.println("来源:"+dp.getAddress().getHostAddress()+",port:"+dp.getPort());
        String str = new String(dp.getData(),0,dp.getLength());
        System.out.println("客户端发来的数据是:"+str);
        ds.close();
    }
}
