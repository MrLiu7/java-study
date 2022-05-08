package javainternetstudy.TCP.TCPExammpleSix;

import java.io.*;
import java.net.Socket;

/**
 * @author 柳继纪
 * &#064;date  8/5/2022
 * @apiNote
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.4", 2677);

        BufferedOutputStream bo = new BufferedOutputStream(socket.getOutputStream());
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream("f:\\source.png"));

        byte[] infos = new byte[8192];
        while (bi.read(infos) != -1) {
            bo.write(infos);
        }
        socket.shutdownOutput();
        bo.flush();

        socket.close();
        bi.close();
    }
}
