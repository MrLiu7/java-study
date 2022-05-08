package javainternetstudy.TCP.TCPExampleFour;

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

        //封住数据读取流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //创建写入文件流
        BufferedWriter bw = new BufferedWriter(new FileWriter("f:\\server.txt"));

        String info;
        while ((info=br.readLine())!=null){
            bw.write(info);
            bw.newLine();
            System.out.println("服务端正在写入数据...");
        }
        bw.flush();
        System.out.println("服务端接收数据完成，文件写入成功！");
        socket.close();
        bw.close();
    }
}
