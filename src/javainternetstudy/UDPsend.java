package javainternetstudy;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

//ͨ��Э�� UDP �ķ�������
public class UDPsend {
    public static void main(String[] args) throws IOException {
        //DatagramSocked��ʾ���ڷ��ͺͽ������ݱ����ݰ����׽��֡�
        DatagramSocket ds = new DatagramSocket();

        byte[]infos="��ã�UDP��".getBytes();

        //DatagramPacked��ʾ���ݱ�����

        //��������һ�����췽����
        //����һ�����ݰ������ͳ���Ϊ length�����ݰ���ָ�������ϵ�ָ���˿ںš�
        //����Ϊ��������Ϣ���ֽ����飬������Ϣ�ĳ��ȣ�InetAddress��ַ���˿ں�
        //DatagramPacket(byte[] buf, int length, InetAddress address, int port);
        DatagramPacket dp = new DatagramPacket(infos,infos.length, InetAddress.getByName("DESKTOP-6DEHF8V"),1000);

        //ʹ��DatagramSocked��������
        ds.send(dp);
        //�ر��ͷ���Դ
        ds.close();
    }
}
