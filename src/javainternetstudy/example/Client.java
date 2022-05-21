package javainternetstudy.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.Socket;

/**
 * 客户端
 *
 * @author 柳继纪
 * @date 21/5/2022
 * @apiNote
 */
public class Client implements Runnable {
    //全局主窗口
    private final JFrame frame;
    //文本键入框
    private final JTextField textField;
    //发送按钮
    private final JButton sendButton;
    //消息显示文本域
    private JTextArea textArea;
    //窗口标题
    private final String title;
    //socket网络套接字
    private final Socket socket;

    public Client(String title) throws IOException {
        //窗口标题初始化
        this.title = title;
        //初始化主窗口
        frame = new JFrame(title);
        //初始化文本键入框
        this.textField = new JTextField(20);
        //初始化发送按钮
        this.sendButton = new JButton("发送");
        //初始化网络套接字对象
        socket = new Socket("192.168.1.6", 2677);

        //注册监听
        addListen();
        //初始化窗口
        init();
    }

    private void init() {
        //添加中间区域
        frame.add(getCenterPanel(), BorderLayout.CENTER);
        //添加南部区域
        frame.add(getSouthPanel(), BorderLayout.SOUTH);
        //设置窗口可见
        frame.setVisible(true);
        //设置窗口大小
        frame.setBounds(0, 0, 400, 320);
        //设置窗口可关闭
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * 获取中间区域的消息显示
     *
     * @return 返回JPanel面板
     */
    private JPanel getCenterPanel() {
        textArea = new JTextArea();
        //容纳滑动条窗口的面板设置布局为边框布局，填充中间区域为最佳效果
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return panel;
    }

    /**
     * 获取南部区域
     * 输入框
     * 发送按钮
     *
     * @return 返回JPanel面板
     */
    private JPanel getSouthPanel() {
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(sendButton);
        return panel;
    }

    /**
     * 发送按钮的监听
     * 当点击发送，创建一个线程执行数据发送的请求
     */
    public void addListen() {
        sendButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //启动线程 发送数据
                new SendInfo().start();
            }
        });
    }

    @Override
    public void run() {
        //不断监听数据的接收
        while (true) {
            try {
                BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
                byte[] infos = new byte[8192];
                int len;
                while ((len = in.read(infos)) != -1) {
                    textArea.append(new String(infos, 0, len));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 继承Thread，实现多线程
     * 重写run方法，实现数据的发送
     */
    class SendInfo extends Thread {
        @Override
        public void run() {
            try {
                //获取套接字数据输出流
                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                //消息框显示输入内容
                String info = textField.getText();
                if ("".equals(info)) return;
                textArea.append(title + "说：" + info + "\n");
                textField.setText("");
                //发送数据
                out.write((title + "说：" + info + "\n").getBytes());
                //刷新流
                out.flush();
                //关闭流
                //out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //启动客户端
        new Thread(new Client("客户端")).start();
    }
}

