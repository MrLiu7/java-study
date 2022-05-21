package javainternetstudy.TCP.TCPExampleOne;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端
 *  发送数据，并且接收服务器反馈
 *
 * @author 柳继纪
 * &#064;date  8/5/2022
 * @apiNote
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {
        //创建客户端对象
        //通过直接指定IP地址的构造方法创建
        Socket socket = new Socket("192.168.1.6", 2677);

        //创建输出流 获取字节套的输出流
        OutputStream os = socket.getOutputStream();

        os.write("TCP案例一：发送数据到服务端，并且接收服务器反馈".getBytes());

        //接收服务器反馈
        InputStream is = socket.getInputStream();
        byte[] receiveInfo = new byte[1024];
        int len = is.read(receiveInfo);
        System.out.println("服务器发来消息：" + new String(receiveInfo, 0, len));

        //关闭资源
        os.close();
        is.close();
        socket.close();
    }
}