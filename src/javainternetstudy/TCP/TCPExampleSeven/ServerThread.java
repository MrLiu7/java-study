package javainternetstudy.TCP.TCPExampleSeven;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author 柳继纪
 * @date 8/5/2022
 * @apiNote
 */
public class ServerThread implements Runnable {
    private Socket socket;
    private static int ID;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try {
            bi = new BufferedInputStream(socket.getInputStream());
            bo = new BufferedOutputStream(new FileOutputStream("f:\\" + (++ID) + "copy.png"));
            BufferedOutputStream sbo = new BufferedOutputStream(socket.getOutputStream());
            byte[] infos = new byte[1024];
            while (bi.read(infos) != -1) {
                bo.write(infos);
            }
            bo.flush();
            sbo.write(("ID:"+ID+"完成！").getBytes());
            sbo.write("\r\n".getBytes());
            sbo.flush();
            sbo.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
