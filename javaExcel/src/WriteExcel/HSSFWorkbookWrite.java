package WriteExcel;
/**
 * HSSFWorkbook ��ʾ03�汾��excel���������������
 * POIдexcel�Ļ�����ʹ��
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
        //1������������
        Workbook workbook = new HSSFWorkbook();
        //2��������
        Sheet sheet = workbook.createSheet("ѧϰ��¼��");
        //3��������
        //������ʾ�кţ�0�����һ��
        Row row = sheet.createRow(0);
        //4���������
        //������ʾ�кţ�0�����һ��
        Cell cell = row.createCell(0);
        //�������
        cell.setCellValue("ѧϰʱ��");

        //��������
        File file = new File("D:\\ѧϰ�г���¼��.xls");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            //д������
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            System.out.println("û���ҵ�����ļ�"+ file);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("������д�����ݳ���");
            throw new RuntimeException(e);
        }
        System.out.println("�ɹ�");
    }
}
