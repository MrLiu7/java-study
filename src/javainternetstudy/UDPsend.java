package javainternetstudy;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

//通信协议 UDP 的发送数据
public class UDPsend {
    public static void main(String[] args) throws IOException {
        //DatagramSocked表示用于发送和接收数据报数据包的套接字。
        DatagramSocket ds = new DatagramSocket();

        byte[]infos="你好，UDP，不安全的传输协议。".getBytes();

        //DatagramPacked表示数据报包。

        //掌握以下一个构造方法：
        //构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。
        //参数为：发送信息的字节数组，发送信息的长度，InetAddress地址，端口号
        //DatagramPacket(byte[] buf, int length, InetAddress address, int port);
        DatagramPacket dp = new DatagramPacket(infos,infos.length, InetAddress.getByName("192.168.1.10"),1000);

        //使用DatagramSocked发送数据
        ds.send(dp);
        //关闭释放资源
        ds.close();
    }
}
