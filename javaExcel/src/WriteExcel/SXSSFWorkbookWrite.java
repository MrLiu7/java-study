package WriteExcel;
/**
 * HSSFWorkbook ��ʾ03�汾��excel���������������
 * POIдexcel�Ļ�����ʹ��
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
        //1������������
        Workbook workbook = new SXSSFWorkbook();
        //2��������
        Sheet sheet = workbook.createSheet("��ǿ��");
        //3��������
        //������ʾ�кţ�0�����һ��
        Row row;
        //4���������
        //������ʾ�кţ�0�����һ��
        Cell cell;

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < 100; j++) {
                cell = row.createCell(j);
                //��������
                cell.setCellValue(j);
            }
        }

        //��������
        File file = new File("D:\\ѧϰʱ����¼��.xls");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            //д������
            workbook.write(outputStream);
            //�ر���
            outputStream.close();
            //�����ʱ�ļ�
            ((SXSSFWorkbook)(workbook)).dispose();
        } catch (FileNotFoundException e) {
            System.out.println("û���ҵ�����ļ�" + file);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("������д�����ݳ���");
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();

        System.out.println("�ɹ�����ʱ "+(double)(end-start)/1000+"��");
    }
}
