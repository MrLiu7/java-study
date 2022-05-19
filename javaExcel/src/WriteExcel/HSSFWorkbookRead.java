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
 * @author 柳继纪
 * @date 18/5/2022
 * @apiNote
 */
public class HSSFWorkbookRead {
    public static void main(String[] args) {
        File file = new File("D:\\学习成绩表.xlsx");
        try {
            //获取文件输入流
            FileInputStream inputStream=new FileInputStream(file);
            //通过文件输入流获取工作簿
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            //获取工作簿的工作表 （0代表工作簿的第一张表）
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowNum; i++) {
                //获取工作簿的工作行 （参数：0 代表工作表的第一行）
                XSSFRow row = sheet.getRow(i);
                if (row!=null){
                    //读取一行的个数
                    int num = row.getPhysicalNumberOfCells();
                    for (int j = 0; j < num; j++) {
                        //通过工作行获取工作格（代表：0 代表工作行的第一列）
                        XSSFCell cell = row.getCell(j);
                        if (cell!=null) {
                            //判断cell的类型
                            CellType cellType = cell.getCellType();
                            switch (cellType){
                                case STRING : //字符串
                                    //获取值
                                    String valueString = cell.getStringCellValue();
                                    System.out.println(valueString);
                                    break;
                                case BOOLEAN://boolean类型
                                    boolean valueBoolean = cell.getBooleanCellValue();
                                    System.out.println(valueBoolean);
                                case BLANK://空
                                    break;
                                case NUMERIC:
                                    //如果是日期类
                                    if (HSSFDateUtil.isCellDateFormatted(cell)){
                                        Date dateCellValue = cell.getDateCellValue();
                                        System.out.println(dateCellValue);
                                    }else {
                                        //是普通数字，防止数字过长
                                        cell.setCellType(CellType.STRING);
                                        String s = cell.toString();
                                        System.out.println(s);
                                    }
                                    break;
                                case ERROR:
                                    System.out.println("数据类型错误");
                                    break;
                                case FORMULA://公式类型
                                    String cellFormula = cell.getCellFormula();
                                    System.out.println(cellFormula);
                            }

                        }
                    }
                }
            }
            //如果不存在表，返回

        } catch (FileNotFoundException e) {
            System.out.println("文件获取失败");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("表获取失败");
            throw new RuntimeException(e);
        }
    }
}
