package regressioncases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
//import java.util.List;


import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import utility.BaseExtent;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.CreateDeck_Action;
import appModules.SignIn_Action;
import appModules.SignOut_Action;
import appModules.UploadFile_Action;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ReporterType;

public class Framework_001 extends BaseExtent {


	//public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	 HSSFWorkbook workbook;
	//define an Excel Work sheet
	  HSSFSheet sheet;
	Map<String, Object[]> testresultdata;
//	 public List<HashMap<String,String>> datamap;
	
	private final String reportPath = Constant.Path_ExtentReport + Framework_001.class.getSimpleName() + ".html";

	  @BeforeClass
	    public void beforeClass() {
	    	
		  
		
			
	        extent = new ExtentReports(reportPath, true);
	        
	        // optional - to store all results in a database
	        extent.startReporter(ReporterType.DB, (new File(reportPath)).getParent() + File.separator + "extent.db");
	       // extent.startReporter(ReporterType.DB, "extent.db");
	        
	        extent.config().documentTitle("IQreateInfotechReports");
			  
	        String css = "#topbar { background-color: #8bb1ec; }" +
			        ".topbar-items-right span { color: white; }" +
			        ".menu span { color: darkgreen; }" +
			        ".menu-item-selected span { border-bottom: 1px solid green; }" +
			        "#dashboard { background-color: transparent; }" +
			        ".test { border: 1px solid lightseagreen; }" + 
			        ".description { background-color: transparent; border-left: 2px solid orange; padding: 2px 15px;}" + 
			        ".name { color: darkgreen; }" + 
			        ".extent-table { border: 1px solid #bbb; }" + 
			        ".extent-table th { background: none repeat scroll 0 0 olivedrab; color: #fff; }" + 
			        ".extent-table td { border-bottom: 1px solid #bbb; }";

			extent.config().addCustomStylesheet(css);
	        
	        extent.addSystemInfo("MuthuComputer", "Muthu");
	        
	        //create a new work book
	        workbook = new HSSFWorkbook();
	        //create a new work sheet
	         sheet = workbook.createSheet("Test Result");
	        testresultdata = new LinkedHashMap<String, Object[]>();
	        //add test result excel file column header
	        //write the header in the first row
	        testresultdata.put("1", new Object[] {"Test Step Id", "Action", "Expected Result","Actual Result"});
	    }
	
	  
  // Following TestNg Test case pattern, and divided a Test case in to three different part.
  // In Before Method, your code will always be the same for every other test case.
  // In other way before method is your prerequisites of your main Test Case	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	    // http://www.deck.uniqreate.qa/log4j-logging/
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
	
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		// Now we do need to provide the Selenium driver to any of the Page classes or Module Actions
		// Will soon write a post on Base Class
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void main() throws Exception {
	  // Every exception thrown from any class or method, will be catch here and will be taken care off

	  try{
				
				
		// Here we are calling the SignIN Action and passing argument (iTestCaseRow)
		// This is called Modularization, when we club series of actions in to one Module
		// For Modular Driven Framework
		// SignIn_Action.Execute(iTestCaseRow);
		  SignIn_Action.Execute(iTestCaseRow);
		 //Call Craete New Deck Action
	     CreateDeck_Action.Execute(iTestCaseRow);
		 Thread.sleep(1000);
		 
		 //Upload the files into  card
		 
		  UploadFile_Action.Execute(iTestCaseRow);
		 
		 //Logout from UQ System
	     SignOut_Action.Execute(iTestCaseRow);
	
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
			// This is to throw exception in case of fail test, this exception will be caught by catch block below
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  // If the exception is in between the test, bcoz of any element not found or anything, this will take a screen shot
		  utility.CaptureScreenShotUtil.captureScreenShot(driver, sTestCaseName);
		  // This will print the error log message
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
		
  }
	
  
  
 // Its time to close the finish the test case		
  @AfterClass  
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	  
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.close();
  		}
  
@AfterSuite
  public void setupAfterSuite() {
    //write excel file and file name is TestResult.xls 
    Set<String> keyset = testresultdata.keySet();
    int rownum = 0;
    for (String key : keyset) {
        Row row = sheet.createRow(rownum++);
        Object [] objArr = testresultdata.get(key);
        int cellnum = 0;
        for (Object obj : objArr) {
            Cell cell = row.createCell(cellnum++);
            if(obj instanceof Date) 
                cell.setCellValue((Date)obj);
            else if(obj instanceof Boolean)
                cell.setCellValue((Boolean)obj);
            else if(obj instanceof String)
                cell.setCellValue((String)obj);
            else if(obj instanceof Double)
                cell.setCellValue((Double)obj);
        }
    }
    try {
        FileOutputStream out =new FileOutputStream(new File("TestResult.xls"));
        workbook.write(out);
        out.close();
        System.out.println("Excel written successfully..");
         
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //close the browser
   // driver.close();
  //  driver.quit();
  }
  
}
