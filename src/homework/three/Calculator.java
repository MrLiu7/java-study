//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package homework.three;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Calculator {
    public JFrame mainFrame = new JFrame("整数计算器");
    public JPanel numPanel = new JPanel(new GridLayout(4, 3));
    public JButton titleButton = new JButton("清空");
    public JButton[] numButtons = new JButton[12];

    public Calculator() {
    }

    public static void main(String[] args) {
        (new Calculator()).init();
    }

    public void init() {
        for (int i = 0; i < 10; ++i) {
            this.numButtons[i] = new JButton("" + i);
            this.numPanel.add(this.numButtons[i]);
        }

        this.numButtons[10] = new JButton("加");
        this.numButtons[11] = new JButton("等于");
        this.numPanel.add(this.numButtons[10]);
        this.numPanel.add(this.numButtons[11]);
        this.mainFrame.add(this.titleButton, "First");
        this.mainFrame.add(this.numPanel, "Center");
        this.mainFrame.setBounds(400, 300, 300, 200);
        this.jButtonClick();
        this.mainFrame.setVisible(true);
        this.mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void addJButtonListen(final JButton jButton) {
        jButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String text = Calculator.this.titleButton.getText();
                if (text.equals("清空")) {
                    text = "";
                }

                text = text + jButton.getText();
                Calculator.this.titleButton.setText(text);
            }
        });
    }

    public void jButtonClick() {
        for (int i = 0; i < 10; ++i) {
            this.addJButtonListen(this.numButtons[i]);
        }

        this.numButtons[10].addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String text = Calculator.this.titleButton.getText();
                if (text.equals("清空")) {
                    text = "";
                }

                text = text + "+";
                Calculator.this.titleButton.setText(text);
            }
        });
        this.numButtons[11].addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                String text = Calculator.this.titleButton.getText();
                if (text.equals("清空")) {
                    text = "0";
                    Calculator.this.titleButton.setText(text);
                } else {
                    String[] nums = text.split("[+]");
                    int result = 0;
                    String[] var5 = nums;
                    int var6 = nums.length;

                    for (int var7 = 0; var7 < var6; ++var7) {
                        String num = var5[var7];
                        result += Integer.parseInt(num);
                    }

                    Calculator.this.titleButton.setText(text + "= " + String.valueOf(result));
                }

            }
        });
        this.titleButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Calculator.this.titleButton.setText("清空");
            }
        });
    }
}
