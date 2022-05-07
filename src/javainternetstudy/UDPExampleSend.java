package javainternetstudy;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author ���̼�
 * @date 7/5/2022
 * @apiNote
 */
public class UDPExampleSend {
    /*
    UDP�������ݣ�������Դ�ڼ��̣�ֱ�������������886���������ݽ���
    UDP�������ݣ�һֱ�������Է��Ͷ˵����ݲ����
     */
    public static void main(String[] args) throws IOException {
        sendInfo();
    }

    /**
     * ������ϢӦ�ö�
     *
     * @throws IOException
     */
    public static void sendInfo() throws IOException {
        //�������ݷ��Ͷ���
        //ʹ���׳��쳣����һ�쳣
        DatagramSocket ds = new DatagramSocket();

        //�����ֽ����飬������ȡ�û�������
        byte[] info = new byte[1024];

        //ͨ��whileѭ������ȡ�û�����
        String userInputInfo = " ";
        Scanner input = new Scanner(System.in);
        while (!userInputInfo.equals("886")) {
            System.out.println("��ǰ����������Ϣ��");
            userInputInfo = input.nextLine();
            info = userInputInfo.getBytes();

            //���������ֽ���
            //�˿ں�Ϊ 2677
            DatagramPacket dp = new DatagramPacket(info, info.length, InetAddress.getByName("XiaoLiuPA"), 2677);

            //ʹ�� DatagramSocket����������
            ds.send(dp);
        }

        System.out.println("�ѽ����Ի�");

        //�ر���Դ
        ds.close();
    }
}
