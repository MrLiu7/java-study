package test;

import javax.swing.*;

/**
 * @author 柳继纪
 * @date 28/4/2022
 * @apiNote
 */
public class CpuNum {
    public static void main(String[] args){
        Runtime runtime = Runtime.getRuntime();
        int cpuNums = runtime.availableProcessors();
        System.out.println("本台计算机处理器核数是："+cpuNums);
        JOptionPane.showMessageDialog(null,"本台计算机处理器核数是："+cpuNums,"CPU核数查询", JOptionPane.INFORMATION_MESSAGE);
    }
}
