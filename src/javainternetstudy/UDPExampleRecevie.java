package javainternetstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author ���̼�
 * @date 7/5/2022
 * @apiNote
 */
public class UDPExampleRecevie {
    public static void main(String[] args) throws IOException {
        received();
    }

    public static void received() throws IOException {
        //����DatagramSocket�ֽ��׷��ͽ��ܶ���
        //���ն���Ҫָ���˿ں�
        DatagramSocket ds = new DatagramSocket(2677);

        //�����ֽ�����������ֱ�������ݻ���
        byte[] infos = new byte[1024];
        String text;

        //�������ն�DatagramPacketֱ�����ļ�����
        DatagramPacket dp;

        while (true) {
            dp = new DatagramPacket(infos, infos.length);

            //��������
            ds.receive(dp);

            //��������
            //dp.getData();

            text = new String(infos, 0, dp.getLength());

            if (text.equals("886")) break;

            //�������
            System.out.println(text);
        }

        System.out.println("�Է������˶Ի�");

        //�ر���Դ
        ds.close();
    }
}
