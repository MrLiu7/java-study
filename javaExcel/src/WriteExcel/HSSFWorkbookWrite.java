package WriteExcel;
/**
 * HSSFWorkbook 表示03版本的excel，有最大行数限制
 * POI写excel的基本的使用
 */

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HSSFWorkbookWrite {
    public static void main(String[] args) {
        //1、创建工作部
        Workbook workbook = new HSSFWorkbook();
        //2、创建表
        Sheet sheet = workbook.createSheet("学习记录表");
        //3、创建行
        //参数表示行号，0代表第一行
        Row row = sheet.createRow(0);
        //4、创建表格
        //参数表示列号，0代表第一列
        Cell cell = row.createCell(0);
        //添加数据
        cell.setCellValue("学习时长");

        //保存数据
        File file = new File("D:\\学习市场记录表.xls");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            //写出数据
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            System.out.println("没有找到相关文件"+ file);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("工作簿写出数据出错！");
            throw new RuntimeException(e);
        }
        System.out.println("成功");
    }
}
