package javainternetstudy.TCP.TCPExammpleSix;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
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
        Socket socket = serverSocket.accept();

        BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream("F:\\copy.png"));

        byte[]infos = new byte[8192];
        while (bi.read(infos)!=-1){
            bo.write(infos);
        }
        bo.flush();
    }
}
