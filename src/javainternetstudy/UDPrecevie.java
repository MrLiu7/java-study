package javainternetstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPrecevie {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket 发送接收字节套对象
        //作为接受数据端，需要采用有参构造，参数是发送数据端指定的端口
        DatagramSocket ds = new DatagramSocket(1000);

        //创建数据包，用于接受数据
        byte[] info = new byte[1024];

        //创建字节套对象，解析数据
        //掌握以下一个构造方法
        //参数为：接受信息的字节数组，字节数组长度
        //注意：此处的长度只是保存数据数组的长度
        DatagramPacket sp = new DatagramPacket(info,info.length);

        //DatagramSocket对象接受方法，参数为DatagramPacket对象
        ds.receive(sp);

        //解析数据包，获取数据
        //需要创建一个新的数组来保存数据解析的内容
        byte[]trInfo = sp.getData();

        //输出接收到的数组
        //DatagramPacket对象有一个getLength()，可以获取到实际的获取的数据的字节长度
        System.out.println("接收到的内容是："+new String(trInfo,0,sp.getLength()));

        //关闭接受对象，释放内存资源
        ds.close();
    }
}
