package javainternetstudy.TCP.TCPExampleTwo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 *
 * @author 柳继纪
 * &#064;date  8/5/2022
 * @apiNote
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2677);
        Socket socket = serverSocket.accept();

        byte[] info = new byte[1024];
        InputStream is = socket.getInputStream();
        String txt;
        int index = 1;
        do {
            int len = is.read(info);
            txt = new String(info, 0, len);
            System.out.println((index++) + ":>>>" + txt);
        } while (!txt.equals("886"));

        serverSocket.close();
    }
}
