package javainternetstudy.UDP.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 柳继纪
 * &#064;date  7/5/2022
 * @apiNote
 */
public class UDPExampleRecevie {
    public static void main(String[] args) throws IOException {
        received();
    }

    public static void received() throws IOException {
        //创建DatagramSocket字节套发送接受对象
        //接收端需要指定端口号
        DatagramSocket ds = new DatagramSocket(2677);

        //创建字节数组来保存直接套数据缓存
        byte[] infos = new byte[1024];
        String text;

        //创建接收端DatagramPacket直接套文件对象
        DatagramPacket dp;

        while (true) {
            dp = new DatagramPacket(infos, infos.length);

            //接收数据
            ds.receive(dp);

            //解析数据
            //dp.getData();

            text = new String(infos, 0, dp.getLength());

            if (text.equals("886")) break;

            //输出数据
            System.out.println(text);
        }

        System.out.println("对方结束了对话");

        //关闭资源
        ds.close();
    }
}
