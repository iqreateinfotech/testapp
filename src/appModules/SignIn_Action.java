package appModules;


//import org.openqa.selenium.support.ui.Select;
//import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.Success_Login;
import utility.BaseExtent;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

     
    // This is called Modularization, when we club series of actions in to one Module
	// For Modular Driven Framework, please see http://www.toolsqa.com/modular-driven/   
    public  class SignIn_Action extends BaseExtent  {
 

		public static List<HashMap<String,String>> datamap;
        
    /*	public SignIn_Action()
        {
        	
         	datamap = DataHelper.data(System.getProperty("user.dir")+"//src//TestData/default.xlsx","Sheet1");
        }
    	
    	/*
		public static WebDriver driver = null;
		private final String filePath = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQNewReport.html";
		
		  @BeforeClass
		    public void beforeClass() {
		    	
		        extent = new ExtentReports(filePath, true);
		        
		        // optional - to store all results in a database
		       // extent.startReporter(ReporterType.DB, "extent.db");
		        
		        extent.addSystemInfo("Host Name", "Muthu");
		    }
    	    	*/
		  
    	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
    	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
    	// For use of Functions & Parameters, 
		 
       public static void Execute(int iTestCaseRow) throws Exception{
  
   	
          	// Clicking on the My Account link on the Home Page
        	Home_Page.lnk_SignIn().click();
        	Log.info("Click action is perfromed on Sign In link" );
            Thread.sleep(1000);	                	
     	   test.log(LogStatus.INFO, "UQ Login modal is invoked");
       	   String uqloginmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqloginmodal");
 		   String Loginmodalimg = test.addScreenCapture(uqloginmodal);
 		   test.log(LogStatus.PASS, "login", Loginmodalimg);
    	     	     	
              	        	
        	// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
        	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
        	// Constant.Col_UserName is the column number for UserName column in the Test Data sheet
        	// Please see the Constant class in the Utility Package
        	// For Use of Constant Variables,
        
 		   
 		   	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
        	   
            LogIn_Page.txtbx_UserName().sendKeys(sUserName);
 	
            // Printing the logs for what we have just performed
             Log.info(sUserName+" is entered in UserName text box" );
            
           
             String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
             LogIn_Page.txtbx_Password().sendKeys(sPassword);
            
             Log.info(sPassword+" is entered in Password text box" );
 		  
 		  
            
            LogIn_Page.btn_LogIn().click();
            Log.info("Click action is performed on Submit button");
            
            
            
            // I noticed in few runs that Selenium is trying to perform the next action before the complete Page load
            // So I have decided to put a wait on the Logout link element
            // Now it will wait 10 secs separately before jumping out to next step
            Utils.waitForElement(Success_Login.btn_SignOut());
            
            test.log(LogStatus.PASS, "SignIn verified");

     	     String uqloginsuccess = utility.CaptureScreenShotUtil.captureScreenShot(driver, "uqloginsuccess");
    	     String Loginsuccessimg = test.addScreenCapture(uqloginsuccess);
    	     test.log(LogStatus.PASS, "login", Loginsuccessimg);
            
            // This is another type of logging, with the help of TestNg Reporter log
            // This has to be very carefully used, you should only print the very important message in to this
            // This will populate the logs in the TestNG HTML reports
            // I have used this Reporter log just once in this whole module 
            Reporter.log("SignIn Action is successfully perfomred");
            
        }
    }
