package javainternetstudy.TCP.TCPExampleSeven;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 柳继纪
 * @date 8/5/2022
 * @apiNote
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(2677);
        Socket socket;
        while (true) {
            socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }
}
