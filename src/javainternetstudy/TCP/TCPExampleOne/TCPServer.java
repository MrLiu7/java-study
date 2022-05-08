package javainternetstudy.TCP.TCPExampleOne;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 柳继纪
 * @date 8/5/2022
 * @apiNote
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器端的ServerSocket
        //只需要制定个端口号即可
        ServerSocket serverSocket = new ServerSocket(2677);

        //创建服务器端的socket
        Socket socket = serverSocket.accept();

        //输入流对象
        InputStream is = socket.getInputStream();

        //创建字节数组
        byte[] infos =new byte[1024];
        int len = is.read(infos);

        System.out.println(new String(infos,0,len));

        //服务器反馈消息
        OutputStream os = socket.getOutputStream();
        os.write("服务器收到！".getBytes());

        //只需要关闭serverSocket资源即可，因为其他资源是应此而产生的
        serverSocket.close();
    }
}
