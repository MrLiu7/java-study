package experiment.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ArtFont extends JFrame implements ActionListener, ItemListener {
    JComboBox fontType;//������ʽ������
    JComboBox fontSize;//�����С������
    JComboBox windowStyle;//������ʽ������
    JCheckBox boldBx;// ���尴ť
    JCheckBox italicBx;// б�尴ť
    JButton colorBtn;// ��ɫ��ť
    String[] fontNames;// ��������
    String[] fontSizes;// �����С
    JLabel label;// ������ʾ��ǩ
    JTextField inputText;// ���������
    JTextArea txtArea;// ������ʾ��
    JPanel northPanel;// ��������
    JPanel centerPanel;// ��ʾЧ����
    JPanel southPanel;//��ʽ����
    Font font;
    int boldStyle, italicStyle, underlineStyle;
    int fontSizeStyle;
    String fontNameStyle;
    Color colorStyle = Color.black;// ���������Ĭ����ɫΪ��ɫ;
    String[] style = {"Ĭ����ʾЧ��", "Windows��ʾЧ��", "Unix��ʾЧ��"};

    public ArtFont() {
        super("��������");
        // ����Ĭ������
        boldStyle = 0;
        italicStyle = 0;
        underlineStyle = 0;
        fontSizeStyle = 10;
        fontNameStyle = "����";
        font = new Font(fontNameStyle, boldStyle + italicStyle, fontSizeStyle);

        northPanel = getNorthPanel();
        centerPanel = getCenterPanel();
        southPanel = getSouthPanel();

        // ��������
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        //��northPanel��ӵ�����ı���
        container.add(northPanel, BorderLayout.NORTH);
        //��centerPanel��ӵ�������в�
        container.add(centerPanel, BorderLayout.CENTER);
        //��southPanel��ӵ�������ϲ�
        container.add(southPanel, BorderLayout.SOUTH);
        setSize(500, 300);
        //������λ����Ļ������
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel getNorthPanel() {
        JPanel panel = new JPanel();
        label = new JLabel("����");
        inputText = new JTextField(10);
        boldBx = new JCheckBox("����");
        panel.add(label);
        panel.add(inputText);
        italicBx = new JCheckBox("б��");
        panel.add(italicBx);
        panel.add(boldBx);
        colorBtn = new JButton("��ɫ");
        //ע�����
        inputText.addActionListener(this);
        colorBtn.addActionListener(this);
        panel.add(colorBtn);
        boldBx.addItemListener(this);
        italicBx.addItemListener(this);
        return panel;
    }

    private JPanel getCenterPanel() {
        JPanel panel = new JPanel();
        txtArea = new JTextArea();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(txtArea), BorderLayout.CENTER);
        return panel;
    }

    private JPanel getSouthPanel() {
        JPanel panel = new JPanel();
        //���ϵͳĬ������
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontNames = ge.getAvailableFontFamilyNames();
        fontType = new JComboBox<>(fontNames);
        //���������С
        fontSizes = new String[63];
        for (int i = 0; i < fontSizes.length; i++) {
            fontSizes[i] = Integer.toString(i + 10);
        }
        fontSize = new JComboBox<>(fontSizes);
        windowStyle = new JComboBox<>(style);
        panel.add(fontType);
        panel.add(fontSize);
        panel.add(windowStyle);
        fontSize.addItemListener(this);
        fontType.addItemListener(this);
        windowStyle.addItemListener(this);
        return panel;
    }

    public static void main(String[] args) {
        ArtFont artFont = new ArtFont();
        artFont.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputText) {
            txtArea.setText(inputText.getText());
        } else {
            colorStyle = JColorChooser.showDialog(this, "��ѡ��һ����ɫ", colorStyle);
            colorBtn.setForeground(colorStyle);
            txtArea.setForeground(colorStyle);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == boldBx) {
            if (boldBx.isSelected()) {
                boldStyle = Font.BOLD;
            } else {
                boldStyle = Font.PLAIN;
            }
        } else if (e.getSource() == italicBx) {
            if (italicBx.isSelected()) {
                italicStyle = Font.ITALIC;
            } else {
                italicStyle = Font.PLAIN;
            }
        } else if (e.getSource() == fontType) {
            fontNameStyle = (String) e.getItem();
        } else if (e.getSource() == fontSize) {
            fontSizeStyle = Integer.parseInt((String) e.getItem());
        } else if (e.getSource() == windowStyle) {
            String s = (String) e.getItem();
            String className = "";
            if (s.equals("Windows��ʾЧ��"))
                className = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            else if (s.equals("Unix��ʾЧ��"))
                className = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            else if (s.equals("Ĭ����ʾЧ��"))
                className = UIManager.getCrossPlatformLookAndFeelClassName();
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception de) {
                System.out.println("Exception happened!");
            }
        }
        font = new Font(fontNameStyle, boldStyle + italicStyle, fontSizeStyle);
        txtArea.setFont(font);
    }
}