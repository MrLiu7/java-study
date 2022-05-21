package javainternetstudy.TCP.TCPExampleSeven;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author 柳继纪
 * @date 8/5/2022
 * @apiNote
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {
        //模拟10个用户上传数据
        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket("192.168.1.4", 2677);
            BufferedOutputStream bo = new BufferedOutputStream(socket.getOutputStream());
            BufferedInputStream bi = new BufferedInputStream(new FileInputStream("F:\\source.png"));
            byte[] infos = new byte[8192];
            BufferedInputStream sbi = new BufferedInputStream(socket.getInputStream());
            while (bi.read(infos) != -1) {
                bo.write(infos);
            }
            bo.flush();
            socket.shutdownOutput();
            int len = sbi.read(infos);
            System.out.println(new String(infos, 0, len));
            bi.close();
            socket.close();
        }
    }
}
