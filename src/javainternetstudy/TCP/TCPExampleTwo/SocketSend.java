package javainternetstudy.TCP.TCPExampleTwo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 用户端
 *
 * @author 柳继纪
 * &#064;date  8/5/2022
 * @apiNote
 */
public class SocketSend {
    public static void main(String[] args) throws IOException {
        //创建客户端的发送对象
        Socket socket = new Socket("192.168.1.6", 2677);

        String info = "notNull";
        Scanner input = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();
        int index = 1;
        while (!info.equals("886")) {
            System.out.print((index++) + ":<<<");
            info = input.nextLine();
            os.write(info.getBytes());
        }

        socket.close();
    }
}
