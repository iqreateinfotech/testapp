package uqmoduletestcases;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.Registration_Page;
import pageObjects.Registration_Page_Validation;
import pageObjects.Success_Login;
import reusablecases.UQAuthentication;
import reusablecases.UQRegistration;
import reusablecases.WebBrowser;
import utility.BaseExtent;
//import com.relevantcodes.extentreports.LogStatus;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

public  class UQRegistrationCases  extends BaseExtent {
	public static WebElement element;


	//@Test(alwaysRun = true)
	public static void verifyNewRegistration(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {
	
		Utils.waitForElement(Home_Page.lnk_SignIn());		
		// Invoke Registration modal..
		Log.info("Verify new user registration ");
		// Call Registration method
		element = UQRegistration.InvokeRegistrationModal();
		Thread.sleep(100);
		String uuid = UUID.randomUUID().toString();
		strEmail = uuid + strEmail; 
		// report log
		   test.log(LogStatus.INFO, "UQ Registration modal is invoked");
    	   String uqregistrationmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqregistrationmodal");
		   String uqregistrationmodalimg = test.addScreenCapture(uqregistrationmodal);
		   test.log(LogStatus.PASS, "registration", uqregistrationmodalimg);
		   
		element = UQRegistration.Registration(strName, strEmail, strPassword,
				strConfirmPassword);
		Thread.sleep(1000);
		
		// Now it will wait 10 secs separately before jumping out to next step
		Utils.waitForElement(Success_Login.btn_SignOut());

		//  Registration Success Verification
		UQAuthentication.successLogon();
			
		//report log
		   test.log(LogStatus.INFO, "UQ Registration verification");
    	   String uqregistrationsuccess = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqregistrationsuccess");
		   String uqregistrationsuccessimg = test.addScreenCapture(uqregistrationsuccess);
		   test.log(LogStatus.PASS, "Registration is Success", uqregistrationsuccessimg);
		   test.log(LogStatus.INFO, strEmail + " : has been successfully registered");

		// SignOut

		Log.info("UQ Signout button is clicked");
		UQAuthentication.uniqreateSignout();
		//Success_Login.btn_SignOut().click();
	
		// Now it will wait 10 secs separately before jumping out to next step
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
		// Assert.assertTrue(title.contains("Uniqreate"));
		Log.info("UQ Signout verified");
		

		Reporter.log(strEmail + " : has been successfully registered");
	}

	//@Test(alwaysRun = true)
	public static void verifyAlreadyUsedEmail(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {
	
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke home page of UQ
		//setup.testSetup();
		// Invoke Registration modal..
	   element = UQRegistration.InvokeRegistrationModal();
	   Log.info("Verify registarion with alrady used email ");
		// Call Registration method
		
		element = UQRegistration.Registration(strName, strEmail, strPassword,
				strConfirmPassword);
		Thread.sleep(500);
		
		// Verification

		String usedemail = Registration_Page_Validation.label_strEmail()
				.getText();
		System.out.println(usedemail);
		Assert.assertTrue(usedemail
				.contains("The email has already been taken."));
		
		//report log
		   test.log(LogStatus.INFO, "Registarion with already used/registred email");
	       String registrationsusedemail = utility.CaptureScreenShotUtil.captureScreenShot(driver,"registrationsusedemail");
		   String registrationsusedemailimg = test.addScreenCapture(registrationsusedemail);
		   test.log(LogStatus.PASS, "Registarion with already used/registred email", registrationsusedemailimg);
		

		// Close the Registration modal..
		Registration_Page.icon_CloseRegistrationModal().click();
	

		// Close the browser
		//CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully email has already been taken.");
		
	}

	///@Test(alwaysRun = true)
	public static void verifyMismatchPassword_ConfirmPassword(String strName,
			String strEmail, String strPassword, String strConfirmPassword)
			throws Exception {

		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Registration modal..
		element = UQRegistration.InvokeRegistrationModal();
		Log.info("Verify Mismatch Password_ConfirmPassword in registration");
		// Call Registration method
		element = UQRegistration.Registration(strName, strEmail, strPassword,
				strConfirmPassword);
		Thread.sleep(1000);
		// Verification
		String mismatchpass = Registration_Page_Validation.label_strPassword()
				.getText();
	
		System.out.println(mismatchpass);
		Assert.assertTrue(mismatchpass
				.contains("The password confirmation does not match."));
		
		//report log
		   test.log(LogStatus.INFO, "Registarion Validation: password confirmation does not match.");
	       String registrationmismatchpass_confpass = utility.CaptureScreenShotUtil.captureScreenShot(driver,"registrationmismatchpass_confpass");
		   String registrationmismatchpass_confpassimg = test.addScreenCapture(registrationmismatchpass_confpass);
		   test.log(LogStatus.PASS, "Registarion Validation: password confirmation does not match.", registrationmismatchpass_confpassimg);

		// Close the Registration modal..
		Registration_Page.icon_CloseRegistrationModal().click();

		// Close the browser
		//CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully password confirmation does not match.");
	}

	//@Test(alwaysRun = true)
	public static void emptyPassword(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {

		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Registration modal..
		element = UQRegistration.InvokeRegistrationModal();
		Log.info("Verify registarion with blank pass ");
		// Call Registration method
		element = UQRegistration.Registration(strName, strEmail, strPassword,
				strConfirmPassword);
		Thread.sleep(1000);
		// Verification
		String blankpassword = Registration_Page_Validation.label_strPassword()
				.getText();
		System.out.println(blankpassword);
		Assert.assertTrue(blankpassword
				.contains("The password field is required."));
		
		//report log
		   test.log(LogStatus.INFO, "Registarion Validation:emptyPassword");
	       String registrationemptypass = utility.CaptureScreenShotUtil.captureScreenShot(driver,"registrationemptypass");
		   String registrationemptypassimg = test.addScreenCapture(registrationemptypass);
		   test.log(LogStatus.PASS, "Registarion Validation:emptyPassword", registrationemptypassimg);

		// Close the Registration modal..
		Registration_Page.icon_CloseRegistrationModal().click();

		// Close the browser
	//	CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully password field is required.");
	}

	//@Test
	public static void allFieldsEmpty(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {

		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Registration modal..
		element = UQRegistration.InvokeRegistrationModal();
		Log.info("Verify registarion with alrady used email ");
		// Call Registration method
		element = UQRegistration.Registration(strName, strEmail, strPassword,
				strConfirmPassword);
		Thread.sleep(1000);
		// Verification
		String allfieldblank = Registration_Page_Validation.label_strName()
				.getText();
		System.out.println(allfieldblank);
		Assert.assertTrue(allfieldblank.contains("The name field is required."));
		
		//report log
		   test.log(LogStatus.INFO, "Registarion Validation:allFieldsEmpty");
	       String registrationallfieldsempty = utility.CaptureScreenShotUtil.captureScreenShot(driver,"registrationallfieldsempty");
		   String registrationallfieldsemptyimg = test.addScreenCapture(registrationallfieldsempty);
		   test.log(LogStatus.PASS, "Registarion Validation:allFieldsEmpty", registrationallfieldsemptyimg);

		// Close the Registration modal..
		Registration_Page.icon_CloseRegistrationModal().click();

		// Close the browser
		//CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully name field is required.");

	}

	///@Test
	public static void verifyEmailFormat(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {

		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Registration modal..
		element = UQRegistration.InvokeRegistrationModal();
		testLog.info("Verify registarion with incorrect email format ");
		// Call Registration method
		element = UQRegistration.Registration(strName, strEmail, strPassword,
				strConfirmPassword);
		Thread.sleep(1000);
		// Verification
		String incorrectemailformat = Registration_Page_Validation
				.label_strEmail().getText();

		System.out.println(incorrectemailformat);
		Assert.assertTrue(incorrectemailformat
				.contains("Invalid email address"));
		
		//report log
		   test.log(LogStatus.INFO, "Registarion Validation:Invalid email address");
	       String registrationaemailformat = utility.CaptureScreenShotUtil.captureScreenShot(driver,"registrationaemailformat");
		   String registrationaemailformatimg = test.addScreenCapture(registrationaemailformat);
		   test.log(LogStatus.PASS, "Registarion Validation:Invalid email address", registrationaemailformatimg);

		// Close the Registration modal..
		Registration_Page.icon_CloseRegistrationModal().click();
		
		Reporter.log("Validated successfully Invalid email address");

	
	}
	

	public static void verifyAllRegistrationCases() throws Throwable {

		try {
				
	        // Open the Excel file
	        FileInputStream fis = new FileInputStream("/home/muthu/work/Selenium/SeleniumUQ/TestData/RegistrationData.xlsx");

			// Access the required test data sheet
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");

			/*
			 * Loop through all rows in the sheet Start at row 1 as row 0 is our
			 * header row
			 * 
			 * loop through every record and based on the validLogin and
			 * invalidLogin string in first column of each row will cal the
			 * different funtion
			 */
			for (int count = 1; count <= sheet.getLastRowNum(); count++) {
				XSSFRow row = sheet.getRow(count);
				System.out.println("Running test case "
						+ row.getCell(0).toString());

				String sTestCaseName = row.getCell(0).toString();

				// Run the test for the current test data row
		          
				 if(sTestCaseName.equals(new String("verifyNewRegistration")))
				 {
				 verifyNewRegistration(row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
								 				 
				 }
				 
				 else if(sTestCaseName.equals(new String("verifyAlreadyUsedEmail")))
				 {
					
					 
					 verifyAlreadyUsedEmail(row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
				 		
				 }
				 
				 else if(sTestCaseName.equals(new String("verifyMismatchPassword_ConfirmPassword")))
				 {
					
					 verifyMismatchPassword_ConfirmPassword(row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
				 		
					 
				 }
				 
				 else if(sTestCaseName.equals(new String("emptyPassword")))
				 {
					 emptyPassword(row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
				 }
				 
				 else if(sTestCaseName.equals(new String("allFieldsEmpty")))
				 {
					 allFieldsEmpty(row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
				 }
				 else if(sTestCaseName.equals(new String("verifyEmailFormat")))
				 {
					 verifyEmailFormat(row.getCell(1).toString(), row.getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
				 }
				
			}

		
			fis.close();
			
		} catch (IOException e) {
			System.out.println("Test data file not found");
		
		}
		

	}
   
	
}