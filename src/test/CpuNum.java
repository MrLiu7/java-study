package test;

import javax.swing.*;

/**
 * @author ���̼�
 * @date 28/4/2022
 * @apiNote
 */
public class CpuNum {
    public static void main(String[] args){
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println("��̨����������������ǣ�"+cpuNums);
        JOptionPane.showMessageDialog(null,"��̨����������������ǣ�"+cpuNums,"CPU������ѯ", JOptionPane.INFORMATION_MESSAGE);
    }
}
