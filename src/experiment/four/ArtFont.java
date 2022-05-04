package experiment.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ArtFont extends JFrame implements ActionListener, ItemListener {
    JComboBox fontType;//字体样式下拉框
    JComboBox fontSize;//字体大小下拉框
    JComboBox windowStyle;//窗体样式下拉框
    JCheckBox boldBx;// 粗体按钮
    JCheckBox italicBx;// 斜体按钮
    JButton colorBtn;// 颜色按钮
    String[] fontNames;// 字体名称
    String[] fontSizes;// 字体大小
    JLabel label;// 输入提示标签
    JTextField inputText;// 文字输入框
    JTextArea txtArea;// 文字显示区
    JPanel northPanel;// 字体设置
    JPanel centerPanel;// 显示效果区
    JPanel southPanel;//样式设置
    Font font;
    int boldStyle, italicStyle, underlineStyle;
    int fontSizeStyle;
    String fontNameStyle;
    Color colorStyle = Color.black;// 设置字体的默认颜色为黑色;
    String[] style = {"默认显示效果", "Windows显示效果", "Unix显示效果"};

    public ArtFont() {
        super("字体设置");
        // 设置默认字体
        boldStyle = 0;
        italicStyle = 0;
        underlineStyle = 0;
        fontSizeStyle = 10;
        fontNameStyle = "宋体";
        font = new Font(fontNameStyle, boldStyle + italicStyle, fontSizeStyle);

        northPanel = getNorthPanel();
        centerPanel = getCenterPanel();
        southPanel = getSouthPanel();

        // 设置容器
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        //将northPanel添加到窗体的北部
        container.add(northPanel, BorderLayout.NORTH);
        //将centerPanel添加到窗体的中部
        container.add(centerPanel, BorderLayout.CENTER);
        //将southPanel添加到窗体的南部
        container.add(southPanel, BorderLayout.SOUTH);
        setSize(500, 300);
        //将窗体位于屏幕的中央
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel getNorthPanel() {
        JPanel panel = new JPanel();
        label = new JLabel("输入");
        inputText = new JTextField(10);
        boldBx = new JCheckBox("粗体");
        panel.add(label);
        panel.add(inputText);
        italicBx = new JCheckBox("斜体");
        panel.add(italicBx);
        panel.add(boldBx);
        colorBtn = new JButton("颜色");
        //注册监听
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
        //获得系统默认字体
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        fontNames = ge.getAvailableFontFamilyNames();
        fontType = new JComboBox<>(fontNames);
        //设置字体大小
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
            colorStyle = JColorChooser.showDialog(this, "请选择一种颜色", colorStyle);
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
            if (s.equals("Windows显示效果"))
                className = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
            else if (s.equals("Unix显示效果"))
                className = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
            else if (s.equals("默认显示效果"))
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