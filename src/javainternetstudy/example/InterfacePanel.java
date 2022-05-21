package javainternetstudy.example;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * @author 柳继纪
 * @date 21/5/2022
 * @apiNote
 */
public class InterfacePanel {
    private final JTextField textField;
    private final JButton sendButton;
    private JTextArea textArea;
    private final String title;

    public InterfacePanel(String name) {
        title = name;
        JFrame frame = new JFrame(name);
        this.textField = new JTextField(20);
        this.sendButton = new JButton("发送");

        addListen();

        frame.add(getCenterPanel(), BorderLayout.CENTER);
        frame.add(getSouthPanel(), BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setBounds(0, 0, 400, 320);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JTextArea getTextArea() {
        return textArea;
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
                //消息框显示输入内容
                String info = textField.getText();
                if ("".equals(info)) return;
                textArea.append(title + "说：" + info + "\n");
                textField.setText("");
                //发送数据

            }
        });
    }
}
