package homework.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WorkTwo1 extends JFrame {
    private JCheckBox italics;
    private JCheckBox bold;
    private JRadioButton[] txtSize;
    private JTextArea txtArea;
    private int italicsFlag;
    private int boldFlag;
    private int txtSizeFlag;
    public WorkTwo1() {
        italics = new JCheckBox("б��",false);
        bold = new JCheckBox("����",false);
        txtArea = new JTextArea("��ϲ��C++\n����ϲ��Java");
        txtSize = new JRadioButton[3];
        txtSize[0]=new JRadioButton("���ֺ�",false);
        txtSize[1]=new JRadioButton("���ֺ�",false);
        txtSize[2]=new JRadioButton("С�ֺ�",true);
        txtSizeFlag=10;
        init();
    }

    public void init() {
        setLayout(new GridLayout(1, 2));
        setBounds(400, 300, 500, 400);
        JPanel leftPanel = new JPanel(new GridLayout(5,1));
        leftPanel.add(italics);
        leftPanel.add(bold);
        ButtonGroup sizeGroup = new ButtonGroup();
        for (int i = 0; i < 3; i++) {
            sizeGroup.add(txtSize[i]);
            leftPanel.add(txtSize[i]);
        }
        add(leftPanel);
        add(txtArea);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addListen();
    }

    public static void main(String[] args) {
        new WorkTwo1();
    }

    //�¼�����
    public void addListen(){
        italics.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (italics.isSelected()){
                    italicsFlag = Font.ITALIC;
                }else {
                    italicsFlag = Font.PLAIN;
                }
                txtArea.setFont(new Font("����",boldFlag+italicsFlag,txtSizeFlag));
            }
        });

        bold.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bold.isSelected()){
                    boldFlag = Font.BOLD;
                }else {
                    boldFlag = Font.PLAIN;
                }
                txtArea.setFont(new Font("����",boldFlag+italicsFlag,txtSizeFlag));
            }
        });

        txtSize[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSize[0].isSelected()){
                    txtSizeFlag = 30;
                }
                txtArea.setFont(new Font("����",boldFlag+italicsFlag,txtSizeFlag));
            }
        });
        txtSize[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSize[1].isSelected()){
                    txtSizeFlag = 20;
                }
                txtArea.setFont(new Font("����",boldFlag+italicsFlag,txtSizeFlag));
            }
        });
        txtSize[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtSize[2].isSelected()){
                    txtSizeFlag = 10;
                }
                txtArea.setFont(new Font("����",boldFlag+italicsFlag,txtSizeFlag));
            }
        });
    }
}