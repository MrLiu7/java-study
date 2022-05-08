package javainternetstudy.TCP.TCPExampleThree;

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
        //创建服务端字节套接收数据
        ServerSocket serverSocket = new ServerSocket(2677);

        Socket socket = serverSocket.accept();

        //创建接收数据对象 缓冲字符流
        //InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //写文件对象 缓冲字节流
        BufferedOutputStream fw = new BufferedOutputStream(new FileOutputStream("F:\\info.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("886")) break;
            //写入文件
            fw.write(line.getBytes());
            fw.write("\r\n".getBytes());
            //控制台输出
            System.out.println(">>>: "+line);
        }
        //刷新缓冲区
        fw.flush();
        /*
            //flush执行了write，不要频繁的flush，不然反而降低了效率
            private void flushBuffer() throws IOException {
                if (count > 0) {
                    out.write(buf, 0, count);
                    count = 0;
                }
            }
         */
        //关闭资源
        serverSocket.close();
    }
}
