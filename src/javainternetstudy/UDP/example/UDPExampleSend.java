package javainternetstudy.UDP.example;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author 柳继纪
 * &#064;date  7/5/2022
 * @apiNote
 */
public class UDPExampleSend {
    /*
    UDP发送数据：数据来源于键盘，直到输入的数据是886，发送数据结束
    UDP接收数据：一直接收来自发送端的数据并输出
     */
    public static void main(String[] args) throws IOException {
        sendInfo();
    }

    /**
     * 发送消息应用端
     */
    public static void sendInfo() throws IOException {
        //创建数据发送对象
        //使用抛出异常处理一异常
        DatagramSocket ds = new DatagramSocket();

        //创建字节数组，用来获取用户的输入
        byte[] info;

        //通过while循环来获取用户输入
        String userInputInfo = " ";
        Scanner input = new Scanner(System.in);
        while (!userInputInfo.equals("886")) {
            System.out.println("当前可以输入消息：");
            userInputInfo = input.nextLine();
            info = userInputInfo.getBytes();

            //创建数据字节套
            //端口号为 2677
            DatagramPacket dp = new DatagramPacket(info, info.length, InetAddress.getByName("XiaoLiuPA"), 2677);

            //使用 DatagramSocket对象发送数据
            ds.send(dp);
        }

        System.out.println("已结束对话");

        //关闭资源
        ds.close();
    }
}
