package javainternetstudy.TCP.TCPExampleThree;

import java.io.*;
import java.net.Socket;

/**
 * @author 柳继纪
 * @date 8/5/2022
 * @apiNote
 */
public class TCPSend {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.4",2677);

        //此处使用字符流来写出数据
        //数据来源于键盘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //封装输出流对象
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String info;

        while ((info = br.readLine())!=null){
            if (info.equals("886"))break;
            bw.write(info);
            bw.newLine();
        }
        bw.flush();
        //释放资源
        socket.close();
    }
}
