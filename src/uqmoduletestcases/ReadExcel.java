package uqmoduletestcases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



@SuppressWarnings("unused")
public class ReadExcel {

public static void main(String []args){

 try {
 // Specify the path of file
 File src=new File("/home/muthu/work/Selenium/SeleniumUQ/TestData/Test.xls");

// load file
FileInputStream fis=new FileInputStream(src);



// Load workbook
@SuppressWarnings("resource")
HSSFWorkbook wb=new HSSFWorkbook(fis);

// Load sheet- Here we are loading first sheetonly
HSSFSheet sh1= wb.getSheetAt(0);

// getRow() specify which row we want to read.

// and getCell() specify which column to read.
// getStringCellValue() specify that we are reading String data.


System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());

System.out.println(sh1.getRow(0).getCell(1).getStringCellValue());

System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());

System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());

System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());

System.out.println(sh1.getRow(2).getCell(1).getStringCellValue());

 } catch (Exception e) {

System.out.println(e.getMessage());

 }

}

}
