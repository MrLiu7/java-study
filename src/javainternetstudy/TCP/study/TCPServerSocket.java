package javainternetstudy.TCP.study;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 柳继纪
 * &#064;date  8/5/2022
 * @apiNote
 */
public class TCPServerSocket {
    public static void main(String[] args) throws IOException {
        //创建服务器端的Socket
        //只需要指定端口号即可
        ServerSocket socket = new ServerSocket(2677);

        //ServerSocket的accept方法返回侦听要连接到此套接字并接受它，返回Socket对象
        Socket s = socket.accept();

        //获取输入流
        InputStream is = s.getInputStream();
        byte[] data = new byte[1024];
        int len = is.read(data);
        System.out.println("接收到的数据为：" + new String(data, 0, len));

        is.close();
        s.close();
        socket.close();
    }
}
