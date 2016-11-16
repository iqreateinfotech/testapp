package appModules;

import library.ScreenShotUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.Registration_Page;
import utility.BaseExtent;
//import utility.Constant;
//import utility.ExcelUtils;
import utility.Log;

import com.relevantcodes.extentreports.LogStatus;

public abstract class Registration_Action extends BaseExtent  {


	public static void Execute(int iTestCaseRow) throws Exception{
     	
	       /*	 test = extent.startTest("VerifyUQLoginTestCasesWithScreenshot");
			 test.assignCategory("Regression");*/
	        	
	          	// Clicking on the My Account link on the Home Page
	        	Home_Page.lnk_Registration().click();
	        	Log.info("Click action is perfromed on Registration link" );
	              	
	     	   test.log(LogStatus.INFO, "UQ Registration modal is invoked");
	       	   String uqregistrationmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqregistrationmodal");
	 		   String uqregistrationmodalimg = test.addScreenCapture(uqregistrationmodal);
	 		   test.log(LogStatus.PASS, "registration", uqregistrationmodalimg);
	 		   
	 		   
	 		//  String sRName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserNameR);
	        	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
	        	
	 		    Registration_Page.txtbx_Name().sendKeys("Renga1");
	            // Printing the logs for what we have just performed
	       //     Log.info(sRName+" is entered in Name text box" );
	            
	        //   String sREmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_EmailR); 
	 		   Registration_Page.txtbx_Email().sendKeys("Renga1@email.com");
	 		//  Log.info(sREmail+" is entered in Email text box" );
	 		   
	 	//	  String sRPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_PasswordR); 
	 		   Registration_Page.txtbx_Password().sendKeys("123456");
	 	//	  Log.info(sRPassword+" is entered in Password text box" );
	 		  
	 		// String sRConfirmPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_ConfirmPasswordR); 
	 		  Registration_Page.txtbx_ConfirmPassword().sendKeys("123456");
	 	//	 Log.info(sRConfirmPassword+" is entered in Password text box" );
	 			// Assert.assertTrue(title.contains("SIGN OUT"));
	 		 
	 		 Registration_Page.btn_NewRegistration().click();
             Log.info("Click action is performed on Submit button");
	 		 
	 		 
	 			WebElement chk1;
	 			chk1 = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a"));

	 			Assert.assertTrue(chk1.isDisplayed());

	 			// Assert.assertTrue(title.contains("Uniqreate IDEAS INTELLIGENCE INNOVATION"));
	 			test.log(LogStatus.PASS, "Registration verified");

	 			ScreenShotUtil.captureScreenShot(driver, "Registrationsuccess");
	 			String Registrationsuccess = ScreenShotUtil.captureScreenShot(driver, "Registrationsuccess");
	 			String registrationsuccessimg = test.addScreenCapture(Registrationsuccess);
	 			test.log(LogStatus.PASS, "registration", registrationsuccessimg);
	 		  
	 			Reporter.log("Registration Action is successfully perfomred");
	 }
	 
	 
}
