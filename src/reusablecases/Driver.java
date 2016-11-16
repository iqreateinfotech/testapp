package reusablecases;

import ExtentReportingWSelenium.ReadWriteExcel;

public class Driver extends ReadWriteExcel {
	  public static final String URL = "http://www.deck.uniqreate.qa";
	  public static final String Username = "muthu@iqreateinfotech.com";
      public static final String Password = "123456";
      public static final String Path_TestData = "/home/muthu/work/Selenium/SeleniumUQ/TestData/";
      public static final String File_TestData = "Test.xls";
	
	public static void main(String[] args) throws Exception {
		try{
	//	 @SuppressWarnings("unused")
	//	ReadWriteExcel subDriver = new ReadWriteExcel();
			
			ReadWriteExcel.setExcelFile(Driver.Path_TestData + Driver.File_TestData,"Sheet1");
			
			//ReadWriteExcel.setExcelFile(Path_TestData, File_TestData);
		
			String sUsername = ReadWriteExcel.getCellData(1,1);

			String sPassword = ReadWriteExcel.getCellData(1,2);
			
			ReadWriteExcel.setCellData("Pass", 1, 3);
	        System.out.println(sUsername); 
	        System.out.println(sPassword); 
	       
	        
		}catch(Exception execErr){
			System.out.println(execErr.getMessage());
		}
	}

}