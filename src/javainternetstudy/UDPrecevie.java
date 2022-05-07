package javainternetstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPrecevie {
    public static void main(String[] args) throws IOException {
        //����DatagramSocket ���ͽ����ֽ��׶���
        //��Ϊ�������ݶˣ���Ҫ�����вι��죬�����Ƿ������ݶ�ָ���Ķ˿�
        DatagramSocket ds = new DatagramSocket(1000);

        //�������ݰ������ڽ�������
        byte[] info = new byte[1024];

        //�����ֽ��׶��󣬽�������
        //��������һ�����췽��
        //����Ϊ��������Ϣ���ֽ����飬�ֽ����鳤��
        //ע�⣺�˴��ĳ���ֻ�Ǳ�����������ĳ���
        DatagramPacket sp = new DatagramPacket(info,info.length);

        //DatagramSocket������ܷ���������ΪDatagramPacket����
        ds.receive(sp);

        //�������ݰ�����ȡ����
        //��Ҫ����һ���µ��������������ݽ���������
        byte[]trInfo = sp.getData();

        //������յ�������
        //DatagramPacket������һ��getLength()�����Ի�ȡ��ʵ�ʵĻ�ȡ�����ݵ��ֽڳ���
        System.out.println("���յ��������ǣ�"+new String(trInfo,0,sp.getLength()));

        //�رս��ܶ����ͷ��ڴ���Դ
        ds.close();
    }
}
