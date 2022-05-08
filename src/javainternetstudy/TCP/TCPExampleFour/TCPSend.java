package javainternetstudy.TCP.TCPExampleFour;

import java.io.*;
import java.net.Socket;

/**
 * @author 柳继纪
 * @date 8/5/2022
 * @apiNote
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.4", 2677);

        //创建封装读取文本文件
        BufferedReader bi = new BufferedReader(new FileReader("F:\\sendInfo.txt"));

        //创建字节输出流到服务端
        BufferedWriter bo = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String info;
        while ((info = bi.readLine()) != null) {
            System.out.println("正在读取数据...");
            bo.write(info);
            bo.newLine();
        }
        bo.flush();
        System.out.println("文件读取完成");
        socket.close();
        //bi需要被关闭，是因为bi没有被socket绑定
        bi.close();
        System.out.println("文件上传成功");
    }
}
