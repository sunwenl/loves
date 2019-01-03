package com.loves.scoket.version02;
import java.io.IOException;
import java.net.*;

/**
 * @Author ：xiaoyijia
 * @Date ：2018/12/24
 */
public class MyClientUDP {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket ds = new DatagramSocket();
        byte[] bytes = "hello".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length,
                InetAddress.getByName("127.0.0.1"), 8890);

        ds.send(datagramPacket);

        System.out.println("发送完毕");
        ds.close();

    }
}
