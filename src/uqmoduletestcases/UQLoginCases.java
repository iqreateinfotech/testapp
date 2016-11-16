package uqmoduletestcases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.Login_Page_Validation;
import pageObjects.Success_Login;
import reusablecases.UQAuthentication;
import reusablecases.WebBrowser;
import utility.BaseExtent;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

public  class UQLoginCases extends BaseExtent {
	public static WebElement element;

	public static void successLogin(String strUserName, String strPassword)
			throws Exception {


		Utils.waitForElement(Home_Page.lnk_SignIn());

		// Invoke Login modal
		element = UQAuthentication.InvokeSignInModal();
		
		
		// report log
		test.log(LogStatus.INFO, "UQ Login modal is invoked");
		String uqloginmodal = utility.CaptureScreenShotUtil.captureScreenShot(
				driver, "uqloginmodal");
		String Loginmodalimg = test.addScreenCapture(uqloginmodal);
		test.log(LogStatus.PASS, "login", Loginmodalimg);

		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);
		//element = LogIn_Page.Login(strUserName, strPassword);
		
		
		// Verification
		Utils.waitForElement(Success_Login.btn_SignOut());
		UQAuthentication.successLogon();
		
		// report log
		test.log(LogStatus.INFO, "UQ Signin verification");
		test.log(LogStatus.INFO, strUserName
				+ " : has been successfully logged on");
		String uqsigninsuccess = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqsigninsuccess");
		String uqsigninsuccessimg = test.addScreenCapture(uqsigninsuccess);
		test.log(LogStatus.PASS, "UQ SignIn Success verified",
				uqsigninsuccessimg);
		
		//Success_Login.btn_SignOut().click();
		UQAuthentication.uniqreateSignout();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		test.log(LogStatus.INFO, strUserName
				+ " : has been successfully logged out");
		Reporter.log(strUserName
				+ " : has been successfully logged into Uniqreate");
	}

	// @Test (description="Verifies incorrect password")
	public static void incorrectPassword(String strUserName, String strPassword)
			throws Exception {
	
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
		element = UQAuthentication.InvokeSignInModal();
		
		// Now it will wait 10 secs separately before jumping out to next step
		Utils.waitForElement(LogIn_Page.btn_LogIn());
		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);
		
		Utils.waitForElement(Login_Page_Validation.general_LoginValidationMsg());
		// Verification
		String Wrongpass = Login_Page_Validation.general_LoginValidationMsg().getText();
        
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		System.out.println(Wrongpass);

		Assert.assertTrue(Wrongpass
				.contains("These credentials do not match our records."));

		Log.info("Incorrect Password verified");

		// report log
		test.log(LogStatus.INFO,
				"UQ Signin with incorrect password verification");
		String uqsigninincorrectpass = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqsigninincorrectpass");
		String uqsigninincorrectpassimg = test
				.addScreenCapture(uqsigninincorrectpass);
		test.log(
				LogStatus.PASS,
				"UQ SignIn Validation :These credentials do not match our records. ",
				uqsigninincorrectpassimg);

		// close the login modal
	//	LogIn_Page.close_LogInModal().click();
		Home_Page.lnk_SignIn().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully Incorrect Password");

	}

	// @Test
	// (description="Verifies  other' registered user email with some other user valid password")
	public static void incorrectEmail(String strUserName, String strPassword)
			throws Exception {

		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// setup.testSetup();
		// Invoke Login modal
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);
		//Thread.sleep(4000);
		
		Utils.waitForElement(Login_Page_Validation.general_LoginValidationMsg());
		// Verification
		String Incorrectemail = Login_Page_Validation
				.general_LoginValidationMsg().getText();

		
		System.out.println(Incorrectemail);
		Assert.assertTrue(Incorrectemail
				.contains("These credentials do not match our records."));

		Log.info("Incorrect Email is verified");

		// report log
		test.log(LogStatus.INFO, "UQ Signin with incorrect email verification");
		String uqsigninincorrectemail = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqsigninincorrectemail");
		String uqsigninincorrectemailimg = test
				.addScreenCapture(uqsigninincorrectemail);
		test.log(
				LogStatus.PASS,
				"UQ SignIn Validation :These credentials do not match our records. ",
				uqsigninincorrectemailimg);

		// close the login modal
		//LogIn_Page.close_LogInModal().click();
		Home_Page.lnk_SignIn().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully Incorrect Email");
		//test.log(LogStatus.INFO, "----------------*** UQLoginCases verification successfuly completed ***----------------");
		// Log.info("----------------*** UQLoginCases verification successfuly completed ***----------------");
	}

	// @Test
	public static void emptyEmail(String strUserName, String strPassword)
			throws Exception {

		// setup.testSetup();
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);


		String emailblnk = Login_Page_Validation.general_LoginValidationMsg()
				.getText();

		System.out.println(emailblnk);
		Assert.assertTrue(emailblnk.contains("The email field is required."));
		Log.info("Blank Email verified");

		// close the login modal
		//LogIn_Page.close_LogInModal().click();
		Home_Page.lnk_SignIn().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();

	}

	// @Test
	public static void emptyPassword(String strUserName, String strPassword)
			throws Exception {
		// Home_Page.lnk_SignIn().click();
		// setup.testSetup();
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);
		Thread.sleep(1000);
		String emptypass = Login_Page_Validation.label_Password().getText();
		System.out.println(emptypass);
		Assert.assertTrue(emptypass.contains("The password field is required."));
		Log.info("Blank Password verified");

		// close the login modal
		// LogIn_Page.close_LogInModal().click();
		Home_Page.lnk_SignIn().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();
	}

	// @Test
	public static void emptyUserName_Password(String strUserName,
			String strPassword) throws Exception {

		// setup.testSetup();
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);
		Thread.sleep(1000);
		String emptypass = Login_Page_Validation.label_Password().getText();
		String emailblnk = Login_Page_Validation.label_UserName().getText();

		System.out.println(emailblnk);
		System.out.println(emptypass);
		Assert.assertTrue(emptypass.contains("The password field is required."));
		Assert.assertTrue(emailblnk.contains("The email field is required."));

		Log.info("Blank User Name and Password verified");

		// close the login modal
		//LogIn_Page.close_LogInModal().click();
		Home_Page.lnk_SignIn().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();

	}

	// @Test
	public static void passwordLengthLessThanSixChar(String strUserName,
			String strPassword) throws Exception {

		// setup.testSetup();
		element = UQAuthentication.InvokeSignInModal();

		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);
		Thread.sleep(1000);
		String passlessthansixchar = Login_Page_Validation.label_Password()
				.getText();

		System.out.println(passlessthansixchar);
		Assert.assertTrue(passlessthansixchar
				.contains("The password must be at least 6 characters."));

		Log.info("Minimum Password length verified");

		// close the login modal
		//LogIn_Page.close_LogInModal().click();
		Home_Page.lnk_SignIn().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();

	}

	// @Test
	public static void verifyInvalidemailFormat(String strUserName,
			String strPassword) throws Exception {

		// setup.testSetup();
		element = UQAuthentication.InvokeSignInModal();

		// Call Login method
		element = UQAuthentication.Login(strUserName, strPassword);

		Thread.sleep(1000);
		String Invalidemailformat = Login_Page_Validation.label_UserName()
				.getText();
		System.out.println(Invalidemailformat);
		Assert.assertTrue(Invalidemailformat.contains("Invalid email address"));

		Log.info("Email format verified");

		// Close the browser
		// CloseWebBrowser.closeBrowser();

	}

	// @Test
	public static void verifyAllLoginCases() throws Throwable {

		try {
			// DOMConfigurator.configure("log4j.xml");
		
			// test.log(LogStatus.INFO, "----------------*** UQLoginCases verification ***----------------");
			// Log.info("----------------*** UQLoginCases verification ***----------------");
			// Open the Excel file
			FileInputStream fis = new FileInputStream(
					"/home/muthu/work/Selenium/SeleniumUQ/TestData/LoginData.xlsx");

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

				if (sTestCaseName.equals(new String("validLogin"))) {
					successLogin(row.getCell(1).toString(), row.getCell(2)
							.toString());

				} else if (sTestCaseName
						.equals(new String("incorrectPassword"))) {
					incorrectPassword(row.getCell(1).toString(), row.getCell(2)
							.toString());
				}

				else if (sTestCaseName.equals(new String("incorrectEmail"))) {
					incorrectEmail(row.getCell(1).toString(), row.getCell(2)
							.toString());
				}

				/*
				 * else if (sTestCaseName.equals(new String("emptyEmail"))) {
				 * emptyEmail(row.getCell(1).toString(), row.getCell(2)
				 * .toString()); }
				 * 
				 * else if (sTestCaseName.equals(new String("emptyPassword"))) {
				 * emptyPassword(row.getCell(1).toString(), row.getCell(2)
				 * .toString()); }
				 * 
				 * else if (sTestCaseName.equals(new String(
				 * "emptyUserName_Password"))) {
				 * emptyUserName_Password(row.getCell(1).toString(), row
				 * .getCell(2).toString()); }
				 * 
				 * else if (sTestCaseName.equals(new String(
				 * "passwordLengthLessThanSixChar"))) {
				 * passwordLengthLessThanSixChar(row.getCell(1).toString(),
				 * row.getCell(2).toString()); }
				 * 
				 * else if (sTestCaseName.equals(new String(
				 * "verifyInvalidemailFormat"))) {
				 * verifyInvalidemailFormat(row.getCell(1).toString(), row
				 * .getCell(2).toString()); }
				 */
				


			}
			
			fis.close();
		} catch (IOException e) {
			System.out.println("Test data file not found");
		}
		 
	}
	
}
