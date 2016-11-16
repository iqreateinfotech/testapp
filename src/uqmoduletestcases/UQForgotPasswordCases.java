package uqmoduletestcases;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.ForgotPassword_Modal;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.Success_Login;
import reusablecases.UQAuthentication;
import reusablecases.WebBrowser;
import utility.BaseExtent;
import utility.Constant;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

public  class UQForgotPasswordCases extends BaseExtent  {

	public static WebElement element;
	public static String resetpassstoken;
	
//	public static String strEmail;


	//public static String uuid = UUID.randomUUID().toString();
	//public static String strDeckName = "DleteDeck-" + uuid;

	public static Statement stat = null;
	public static ResultSet result = null;
	public String value = null;
	static String dbUrl = "jdbc:mysql://192.168.0.212:3306/UQDBclone_210620161711"; // This is
																	// DB
	// database creadentials
	public static String username = "qauser";
	public static String password = "S3cureP@55";
	public static String dbClass = "com.mysql.jdbc.Driver";


	//@Test(alwaysRun = true)
	public static void verifyResetPassword(String strEmail) throws Throwable{
	
		Utils.waitForElement(Home_Page.lnk_SignIn());

		// Invoke Registration modal..
		Log.info("Verify forgot password");

		// Call Signin/login modal
		element = UQAuthentication.InvokeSignInModal();
		Thread.sleep(1000);
		// invoke forgot pass modal
		LogIn_Page.lnk_ForgotPassword().click();
		Thread.sleep(500);
		
		//report log
		   test.log(LogStatus.INFO, "UQ ForgotPassword modal is invoked");
	      String uqforgetpassmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqforgetpassmodal");
		   String uqforgetpassmodalimg = test.addScreenCapture(uqforgetpassmodal);
		   test.log(LogStatus.PASS, "UQ Forgot Password is successfully invoked", uqforgetpassmodalimg);
		   
		// input email from excel
		ForgotPassword_Modal.txtbx_forgotPassEmail().sendKeys(strEmail);
		Thread.sleep(500);
		// click submit button
		ForgotPassword_Modal.btn_forgotPassButton().click();
		
		Thread.sleep(1000);
		
		test.log(LogStatus.INFO, "verifyResetPassRecordInDatabase");
		
		verifyResetPassRecordInDatabase(strEmail);
		
		Thread.sleep(1000);
		
		
		Utils.waitForElement(Home_Page.lnk_SignIn());

		/*
		 * // Forgot pass email trigger verification forgot modal should close
		 * auto WebElement forgotpassmodal; forgotpassmodal =
		 * ForgotPassword_Modal.modal_forgotPassword(); Assert.assertTrue(!
		 * forgotpassmodal.isDisplayed());
		 */
		System.out.println("verifyResetPassword method successfully run");
		Log.info("Forgot password email triggered");
		test.log(LogStatus.INFO,"Reset Password email sent successfully to : " + strEmail );
		Reporter.log("Email has beeen triggered successfully for reset password to : " +strEmail);
		
		

	}
		
	public static void changePassword(String strEmail) throws Exception {
		
		String resetpassurl = Constant.URL+"password/reset/" +resetpassstoken;
		
		System.out.println("Reset pass URL : " + resetpassurl);
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		Log.info("Verify change password"); 

		Thread.sleep(1000);
		
		//driver.get(resetpassurl);
		
		driver.navigate().to(resetpassurl);
		
		//report log
		   test.log(LogStatus.INFO, "UQ Reset Password modal is invoked");
	      String uqresetpassmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqresetpassmodal");
		   String uqresetpassmodalimg = test.addScreenCapture(uqresetpassmodal);
		   test.log(LogStatus.PASS, "UQ Reset Password modal is successfully invoked", uqresetpassmodalimg);
		
		ForgotPassword_Modal.txtbx_ChangePassEmail().sendKeys(strEmail);
		
		ForgotPassword_Modal.txtbx_Password().sendKeys("1234567");
		
		ForgotPassword_Modal.txtbx_ConfirmPassword().sendKeys("1234567");

		ForgotPassword_Modal.btn_ResetPassword().click();
		
		Thread.sleep(1000);
		
			
		// Verification
				Utils.waitForElement(Success_Login.btn_SignOut());
				UQAuthentication.successLogon();
		
				
				
		//Signout
		UQAuthentication.uniqreateSignout();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
		
		// report log
	 
	    System.out.println("verifyChangePassword method successfully run");
		Log.info("Password has been reset successfully");
		test.log(LogStatus.INFO,"Password has been reset for the user : " + strEmail );
		Reporter.log("Password has been reset for the user : : " +strEmail);
		
	
	

	}

		
	
	

	//@Test(alwaysRun = true)
	public static void verifyEmptyResetpass(String strEmail) throws Exception {
		

		Thread.sleep(1000);
		// Call Signin/login modal
		element = UQAuthentication.InvokeSignInModal();
		Thread.sleep(500);
		// invoke forgot pass modal
		LogIn_Page.lnk_ForgotPassword().click();
				
		
		// input email from excel
		Thread.sleep(500);
	//	ForgotPassword_Modal.txtbx_forgotPassEmail().findElement(By.id("email")).sendKeys(strEmail);
		ForgotPassword_Modal.txtbx_forgotPassEmail().sendKeys(strEmail);
		// click submit button
		Utils.waitForElement(ForgotPassword_Modal.btn_forgotPassButton());
		ForgotPassword_Modal.btn_forgotPassButton().click();

		Thread.sleep(500);

		// Verification
		String blankemail = ForgotPassword_Modal.label_forgotPassEmail()
				.getText();
		System.out.println(blankemail);
		Assert.assertTrue(blankemail.contains("Please fill email field."));
		// forgot password modal
		Thread.sleep(500);
		
		//report log
		   test.log(LogStatus.INFO, "UQ ForgotPassword without email verification");
	      String uqforgetpasemptyemail = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqforgetpasemptyemail");
		   String uqforgetpasemptyemailimg = test.addScreenCapture(uqforgetpasemptyemail);
		   test.log(LogStatus.PASS, "UQ Forgot Password validaion :The email field is required. ", uqforgetpasemptyemailimg);
		   
		ForgotPassword_Modal.btn_forgotPassCloseButton();
		
		System.out.println("verifyEmptyResetpass method successfully run");
		Log.info("Empty Forgot password email validation verified");
        
		Reporter.log("Validated successfully Empty Forgot password email");
		
	}
	
	//@Test(alwaysRun = true)
	public static void verifyIncorrectEmail(String strEmail) throws Exception {
		//DOMConfigurator.configure("log4j.xml");
		
		//ForgotPassword_Modal.refreshPage();
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		Thread.sleep(1000);
		element= UQAuthentication.InvokeSignInModal();
		Thread.sleep(1000);
		// invoke forgot pass modal
		LogIn_Page.lnk_ForgotPassword().click();
		// input email from excel
		Thread.sleep(500);
		ForgotPassword_Modal.txtbx_forgotPassEmail().sendKeys(strEmail);
		Thread.sleep(500);
		// click submit button
		Utils.waitForElement(ForgotPassword_Modal.btn_forgotPassButton());
		ForgotPassword_Modal.btn_forgotPassButton().click();

		Thread.sleep(500);

		// Verification
		String incorrectemail = ForgotPassword_Modal.label_forgotPassEmail()
				.getText();
		System.out.println(incorrectemail);
		Assert.assertTrue(incorrectemail.contains("The email you entered is not found in our records."));
		Thread.sleep(1000);
		
		//report log
		   test.log(LogStatus.INFO, "UQ ForgotPassword incorrect email verification");
	      String uqforgetpaseincorrectemail = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqforgetpaseincorrectemail");
		   String uqforgetpaseincorrectemailimg = test.addScreenCapture(uqforgetpaseincorrectemail);
		   test.log(LogStatus.PASS, "UQ Forgot Password validaion :We can't find a user with that e-mail address. ", uqforgetpaseincorrectemailimg);
		
		// forgot password modal
	   
		ForgotPassword_Modal.btn_forgotPassCloseButton();
	
		Log.info("Incorrect  email validation verified");
	   	Reporter.log("Validated successfully Incorrect  email");
	
	}
	
	//@Test(alwaysRun = true)
	public static void verifyInvalidEmailFormat(String strEmail) throws Exception {
		
		Thread.sleep(1000); 
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
	
		// Call Signin/login modal
		element = UQAuthentication.InvokeSignInModal();
		Thread.sleep(1000);
		// invoke forgot pass modal
		LogIn_Page.lnk_ForgotPassword().click();
		// input email from excel
		Thread.sleep(1000);
		ForgotPassword_Modal.txtbx_forgotPassEmail().sendKeys(strEmail);
		Thread.sleep(500);
		// click submit button
		 Utils.waitForElement(ForgotPassword_Modal.btn_forgotPassButton());
		ForgotPassword_Modal.btn_forgotPassButton().click();

		Thread.sleep(1000);

		// Verification
		String invalidemailformat = ForgotPassword_Modal.label_forgotPassEmail()
				.getText();
		System.out.println(invalidemailformat);
		Assert.assertTrue(invalidemailformat.contains("Please enter a valid email address."));
		// forgot password modal
		Thread.sleep(1000);
		ForgotPassword_Modal.btn_forgotPassCloseButton();
		Log.info("Incorrect  email validation verified");
		
		
		//report log
		   test.log(LogStatus.INFO, "UQ ForgotPassword incorrect email format verification");
	      String uqforgetpaseemailformat = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqforgetpaseemailformat");
		   String uqforgetpaseemailformatimg = test.addScreenCapture(uqforgetpaseemailformat);
		   test.log(LogStatus.PASS, "UQ Forgot Password validaion :Invalid email address ", uqforgetpaseemailformatimg);
		
		// Close the browser
		//CloseWebBrowser.closeBrowser();
		Reporter.log("Validated successfully invalid email format");
	}
	
	//@Test(alwaysRun = true)
	public static void verifyWithMultiValidEmail(String strEmail) throws Exception {
		

		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
		// Call Signin/login modal
		element = UQAuthentication.InvokeSignInModal();
		Thread.sleep(1000);
		// invoke forgot pass modal
		LogIn_Page.lnk_ForgotPassword().click();
		// input email from excel
		ForgotPassword_Modal.txtbx_forgotPassEmail().sendKeys(strEmail);
		// click submit button
		 Utils.waitForElement(ForgotPassword_Modal.btn_forgotPassButton());
		ForgotPassword_Modal.btn_forgotPassButton().click();

		Thread.sleep(1000);

		// Verification
		String multiemails = ForgotPassword_Modal.label_forgotPassEmail()
				.getText();
		System.out.println(multiemails);
		Assert.assertTrue(multiemails.contains("Please enter a valid email address."));
		Thread.sleep(2000);
		// forgot password modal
	//	ForgotPassword_Modal.btn_forgotPassCloseButton();
		Log.info("Incorrect  email validation verified");
		
		//report log
		   test.log(LogStatus.INFO, "UQ ForgotPassword multi email verification");
	      String uqforgetpassmultiemail = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqforgetpassmultiemail");
		   String uqforgetpassmultiemailimg = test.addScreenCapture(uqforgetpassmultiemail);
		   test.log(LogStatus.PASS, "UQ Forgot Password validaion :Invalid email address ", uqforgetpassmultiemailimg);
		   
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		   
		ForgotPassword_Modal.btn_forgotPassCloseButton();   
		Reporter.log("Validated successfully multiple email ");
		
	}
	
	
	public static void verifyResetPassRecordInDatabase(String strEmail) throws Throwable {
		// verify the new user in the database
		Class.forName(dbClass);
		// Get connection to DB.
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		// create a query
		String resetpassquery = "SELECT * From password_resets where email=?";
		// create a statement
		PreparedStatement stat = con.prepareStatement(resetpassquery);
		stat.setString(1, strEmail);
		try {
			boolean hasResultSet = stat.execute();
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();
				// get new deck name from the table
				result.next();
				String resetpass = result.getString("email");
				resetpassstoken = result.getString("token");
				// assert that new deck name should be

				assertEquals(strEmail, resetpass);

				System.out
						.println("Rset password user: "
								+ strEmail);
				System.out.println("Token : " + resetpassstoken);
				
				test.log(LogStatus.INFO, "verifyResetPassRecordInDatabase successfully done");
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}
	

	public static void verifyAllForgotPasswordCases() throws Throwable {

		try {
			// DOMConfigurator.configure("log4j.xml");
			// Open the Excel file
			
			 
			FileInputStream fis = new FileInputStream(
					"/home/muthu/work/Selenium/SeleniumUQ/TestData/ForgotPasswordData.xlsx");

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

				if (sTestCaseName.equals(new String("verifyResetPassword"))) {
					verifyResetPassword(row.getCell(1).toString());

				} 

				else if (sTestCaseName.equals(new String("changePassword"))) {
					changePassword(row.getCell(1).toString());

				}
				
				else if (sTestCaseName.equals(new String(
						"verifyEmptyResetpass"))) {
					verifyEmptyResetpass(row.getCell(1).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyIncorrectEmail"))) {
					verifyIncorrectEmail(row.getCell(1).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyInvalidEmailFormat"))) {
					verifyInvalidEmailFormat(row.getCell(1).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyWithMultiValidEmail"))) {
					verifyWithMultiValidEmail(row.getCell(1).toString());
				}

			}
			fis.close();
			
		} 
		
		
		catch (IOException e) {
			
			System.out.println("Test data file not found");
		}
	
    }

}
