package javainternetstudy.TCP.TCPExampleFive;

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

        BufferedReader br = new BufferedReader(new FileReader("F:\\sendInfo.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String info;
        while ((info = br.readLine())!=null){
            bw.write(info);
            bw.newLine();
            System.out.println("客户端正在上传数据..."+info);
        }
        bw.flush();

        //此方法不加，会导致程序卡死无法继续往下运行，因为服务端还在等着接收数据
        //因此客户端得不到服务端的反馈
        socket.shutdownOutput();

        //获取服务端反馈的信息
        BufferedReader sbr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String serverInfo = sbr.readLine();
        System.out.println("服务器的反馈信息："+serverInfo);

        bw.close();
        br.close();
        socket.close();
    }
}
