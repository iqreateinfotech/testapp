package ExtentReportingWSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@SuppressWarnings("unused")
public class ReadandWriteExcel {
	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	static String SheetName="Sheet1";
	private static final String filePath = "/home/muthu/work/Selenium/SeleniumUQ/Testdata/Test.xls";

	public static void main(String []args){

		  try { 
	FileInputStream ExcelFile = new FileInputStream(filePath);
	@SuppressWarnings("resource")
	HSSFWorkbook wb = new HSSFWorkbook(ExcelFile);

	HSSFSheet sh = wb.getSheet(SheetName);
	
	System.out.println(sh.getRow(0).getCell(0).getStringCellValue());

	System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
		  }
	 
	 catch (Exception e) {

		 System.out.println(e.getMessage());

		  }

		 } 

	// load file//
	// FileInputStream fis = new FileInputStream(filePath);

	// Load workbook
	// HSSFWorkbook wb = new HSSFWorkbook(fis);

	// Load sheet- Here we are loading first sheetonly
	// HSSFSheet sh1 = wb.getSheetAt(0);

	/*
	 * jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm,
	 * *.xlsb)};DBQ=<file_path>;DriverID=22;READONLY=true;
	 * sun.jdbc.odbc.JdbcOdbcDriver
	 * 
	 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); String myDB =
	 * "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=("
	 * //home//muthu//work
	 * //Selenium//SeleniumWebdriver_TestAutomationSuite//TetsData
	 * //TestDataLegitimate//TestLegitimateWeb.xls");"
	 * 
	 * + "DriverID=22;READONLY=false"; Connection con =
	 * DriverManager.getConnection(myDB, "", "");
	 * 
	 * private static XSSFSheet ExcelWSheet; private static XSSFWorkbook
	 * ExcelWBook; private static XSSFCell Cell;
	 */

	@SuppressWarnings("resource")
	public static void setExcelFile(String filePath, String SheetName)
			throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(filePath);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFile);

			HSSFSheet sh = wb.getSheet(SheetName);
			
			System.out.println(sh.getRow(1).getCell(0).getStringCellValue());

			System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
			
			
		} catch (Exception e) {
			throw (e);
		}
	}

	@SuppressWarnings("resource")
	public static Object[][] getTableArray(String FilePath, String SheetName,
			int iTestCaseRow) throws Exception {
		String[][] tabArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFile);
			HSSFSheet sh1= wb.getSheet(SheetName);

			int startRow = 1;
			int startCol = 1;
			int totalRows = sh1.getLastRowNum();
			int totalCols = 2;
			tabArray = new String[totalRows][totalCols];

			for (int i = startRow; i <= totalRows; i++) {
				for (int j = startCol; j <= totalCols; j++) {
					tabArray[i - 1][j - 1] = getCellData(i, j);
					System.out.println(tabArray[i - 1][j - 1]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}

		catch (IOException e) {
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);
	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			 Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}

	public static String getTestCaseName(String sTestCase) throws Exception {
		String value = sTestCase;
		try {
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");
			value = value.substring(posi + 1);
			return value;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowContains(String sTestCaseName, int colNum)
			throws Exception {
		int i;
		try {
			int rowCount = ReadandWriteExcel.getRowUsed();
			for (i = 0; i < rowCount; i++) {
				if (ReadandWriteExcel.getCellData(i, colNum).equalsIgnoreCase(
						sTestCaseName)) {
					break;
				}
			}
			return i;
		} catch (Exception e) {
			throw (e);
		}
	}

	public static int getRowUsed() throws Exception {
		try {
			int RowCount = ExcelWSheet.getLastRowNum();
			return RowCount;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}

  
}