package javainternetstudy;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressStudy {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress是一个静态类
        //通过getByName(String host)确定主机名称的IP地址，主机名可以是机器名称也可以是IP地址
        System.out.println("以下是通过IP地址获取的对象调用相关的方法");
        InetAddress inetAddress = InetAddress.getByName("DESKTOP-6DEHF8V");
        //getHostAddress可以获取IP地址的地址
        String address = inetAddress.getHostAddress();
        System.out.println("IP地址是："+address);
        //getHostName可以获取IP地址的主机名
        String name = inetAddress.getHostName();
        System.out.println("主机名称为："+name);
        System.out.println("-------------------");
        System.out.println("使用IP地址获取可以得到相同的结果");
        inetAddress = InetAddress.getByName("192.168.43.40");
        address = inetAddress.getHostAddress();
        name = inetAddress.getHostName();
        System.out.println("IP地址是："+address);
        System.out.println("主机名称为："+name);
    }
}
