package WriteExcel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.Formula;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

/**
 * @author ���̼�
 * @date 18/5/2022
 * @apiNote
 */
public class HSSFWorkbookRead {
    public static void main(String[] args) {
        File file = new File("D:\\ѧϰ�ɼ���.xlsx");
        try {
            //��ȡ�ļ�������
            FileInputStream inputStream=new FileInputStream(file);
            //ͨ���ļ���������ȡ������
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //��ȡ�������Ĺ����� ��0���������ĵ�һ�ű�
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowNum; i++) {
                //��ȡ�������Ĺ����� ��������0 ��������ĵ�һ�У�
                XSSFRow row = sheet.getRow(i);
                if (row!=null){
                    //��ȡһ�еĸ���
                    int num = row.getPhysicalNumberOfCells();
                    for (int j = 0; j < num; j++) {
                        //ͨ�������л�ȡ�����񣨴���0 �������еĵ�һ�У�
                        XSSFCell cell = row.getCell(j);
                        if (cell!=null) {
                            //�ж�cell������
                            CellType cellType = cell.getCellType();
                            switch (cellType){
                                case STRING : //�ַ���
                                    //��ȡֵ
                                    String valueString = cell.getStringCellValue();
                                    System.out.println(valueString);
                                    break;
                                case BOOLEAN://boolean����
                                    boolean valueBoolean = cell.getBooleanCellValue();
                                    System.out.println(valueBoolean);
                                case BLANK://��
                                    break;
                                case NUMERIC:
                                    //�����������
                                    if (HSSFDateUtil.isCellDateFormatted(cell)){
                                        Date dateCellValue = cell.getDateCellValue();
                                        System.out.println(dateCellValue);
                                    }else {
                                        //����ͨ���֣���ֹ���ֹ���
                                        cell.setCellType(CellType.STRING);
                                        String s = cell.toString();
                                        System.out.println(s);
                                    }
                                    break;
                                case ERROR:
                                    System.out.println("�������ʹ���");
                                    break;
                                case FORMULA://��ʽ����
                                    String cellFormula = cell.getCellFormula();
                                    System.out.println(cellFormula);
                            }

                        }
                    }
                }
            }
            //��������ڱ�����

        } catch (FileNotFoundException e) {
            System.out.println("�ļ���ȡʧ��");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("���ȡʧ��");
            throw new RuntimeException(e);
        }
    }
}
