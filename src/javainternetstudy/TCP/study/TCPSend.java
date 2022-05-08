package javainternetstudy.TCP.study;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author 柳继纪
 * &#064;date  8/5/2022
 * @apiNote
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {
        /*
        TCP发送数据步骤：
            1、创建Socket对象
            2、获取输入流输出流
            3、释放资源
         */

        //创建Socket对象
        //Socket(InetAddress address, int port) 创建流套接字并将其连接到指定IP地址的指定端口号。
        //这个构造方法和下面这个构造方法作用是一样的
        Socket socket = new Socket("192.168.1.4",2677);

        //获取输出流，写数据
        //OutputStream getOutputStream() 返回此套接字的输出流

        OutputStream os = socket.getOutputStream();

        //write 写出数据
        os.write("hello,TCP,我正在学习你".getBytes());


        //释放资源
        socket.close();
    }
}
