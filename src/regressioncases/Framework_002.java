package regressioncases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.relevantcodes.extentreports.ExtentReports;

import pageObjects.BaseClass;
import utility.BaseExtent;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.Registration_Action;
//import appModules.SignIn_Action;
import appModules.SignOut_Action;

public class Framework_002  extends BaseExtent  {


	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	/*
	private final String filePath = Constant.Path_ExtentReport;
	
	  @BeforeClass
	    public void beforeClass() {
	    	
	        extent = new ExtentReports(filePath, true);
	        
	        // optional - to store all results in a database
	       // extent.startReporter(ReporterType.DB, "extent.db");
	        
	        extent.addSystemInfo("MuthuComputer", "Muthu");
	    }*/
	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  	DOMConfigurator.configure("log4j.xml");
	  	sTestCaseName = this.toString();
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
		Log.startTestCase(sTestCaseName);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(driver);  
        }
  
  @Test
  public void f() throws Exception {
	  try{
		//SignIn_Action.Execute(iTestCaseRow);
		Registration_Action.Execute(iTestCaseRow);  
		SignOut_Action.Execute(iTestCaseRow);
		ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
	  }catch (Exception e){
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  utility.CaptureScreenShotUtil.captureScreenShot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  throw (e);
	  }
		
  }
		
		
  @AfterMethod
  public void afterMethod() {
	    Log.endTestCase(sTestCaseName);
	    driver.close();
  		}
}
