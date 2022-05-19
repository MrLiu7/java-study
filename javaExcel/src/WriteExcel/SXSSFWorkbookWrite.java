package WriteExcel;
/**
 * HSSFWorkbook 表示03版本的excel，有最大行数限制
 * POI写excel的基本的使用
 */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SXSSFWorkbookWrite {
    public static void main(String[] args) {
        //1、创建工作部
        Workbook workbook = new SXSSFWorkbook();
        //2、创建表
        Sheet sheet = workbook.createSheet("加强表");
        //3、创建行
        //参数表示行号，0代表第一行
        Row row;
        //4、创建表格
        //参数表示列号，0代表第一列
        Cell cell;

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < 100; j++) {
                cell = row.createCell(j);
                //设置数据
                cell.setCellValue(j);
            }
        }

        //保存数据
        File file = new File("D:\\学习时常记录表.xls");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            //写出数据
            workbook.write(outputStream);
            //关闭流
            outputStream.close();
            //清除临时文件
            ((SXSSFWorkbook)(workbook)).dispose();
        } catch (FileNotFoundException e) {
            System.out.println("没有找到相关文件" + file);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("工作簿写出数据出错！");
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();

        System.out.println("成功，耗时 "+(double)(end-start)/1000+"秒");
    }
}
