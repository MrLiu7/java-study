package javainternetstudy.TCP.TCPExampleFive;

import java.io.*;
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

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("f:\\server.txt"));
        String info;
        while ((info = br.readLine()) != null) {
            bw.write(info);
            bw.newLine();
            System.out.println("服务端正在写入数据..."+info);
        }
        bw.flush();

        BufferedWriter sbw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        sbw.write("服务端处理数据完毕！");
        sbw.flush();
        bw.close();
        socket.close();
    }
}
