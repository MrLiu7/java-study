package javainternetstudy.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * @author 柳继纪
 * @date 21/5/2022
 * @apiNote
 */
public class Server implements Runnable {
    private final JTextField textField;
    //发送按钮
    private final JButton sendButton;
    //消息显示文本域
    private JTextArea textArea;
    //窗口标题
    private final String title;
    //socket网络套接字
    private final Socket socket;

    public Server(String name) throws IOException {
        //窗口标题初始化
        title = name;
        //全局主窗口
        JFrame frame = new JFrame(name);
        //初始化文本键入框
        this.textField = new JTextField(20);
        //初始化发送按钮
        this.sendButton = new JButton("发送");
        //服务器端的套接字
        ServerSocket serverSocket = new ServerSocket(2677);
        //获取服务器短的socket对象，该方法会阻塞等待客户端的请求，直到收到请求
        socket = serverSocket.accept();

        //注册监听
        addListen();

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

    //发送
    class SendInfo extends Thread {
        @Override
        public void run() {
            try {
                BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
                //消息框显示输入内容
                String info = textField.getText();
                if ("".equals(info)) return;
                textArea.append(title + "说：" + info + "\n");
                textField.setText("");
                //发送数据
                out.write((title + "说：" + info + "\n").getBytes());
                out.flush();
                //out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Thread(new Server("服务端")).start();
    }
}

