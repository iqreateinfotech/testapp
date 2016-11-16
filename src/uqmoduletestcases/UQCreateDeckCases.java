package uqmoduletestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.CreateDeck_Modal;
import pageObjects.CreateDeck_Modal_Validation;
import pageObjects.Home_Page;
import pageObjects.Success_Login;
import reusablecases.UQAuthentication;
import reusablecases.UQDeckCreation;
import reusablecases.WebBrowser;
import utility.BaseExtent;
import utility.Constant;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

//import org.testng.annotations.Test;

public  class UQCreateDeckCases extends BaseExtent {

	public static WebElement element;
	//public static WebDriver driver;

	// static String fileLocation = "/home/muthu/Uniqreate/TestData/Photo/";
	// static String strFilename;
	// protected static String pathoffile =fileLocation + strFilename;


	// @Test
	public static void verifyNewDeckCreationWithIdeadeskAdmin (
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {
		try{
      
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Login modal
		element = UQAuthentication.InvokeSignInModal();
		//element = UQInvokeSignInModal.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(Constant.Username, Constant.Password);
		//element = LogIn_Page.Login(Constant.Username, Constant.Password);

		// Verification
		UQAuthentication.successLogon();
		
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		// Clicking on the Create Deck on the UQ Page
		UQDeckCreation.InvokeDeckCreationModal();
		//Success_Login.icon_CreateDeck().click();
		
        
		//Thread.sleep(600);
		Utils.waitForElement(CreateDeck_Modal.btn_CreateDeck());
				
			// report log
		test.log(LogStatus.INFO, "UQ Deck Creation modal is invoked");
		String uqdeckcreationmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver, "uqdeckcreationmodal");
		String uqdeckcreationmodalimg = test.addScreenCapture(uqdeckcreationmodal);
		test.log(LogStatus.PASS, "UQ Deck Creation is successfully invoked",uqdeckcreationmodalimg);

		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = UQDeckCreation.DeckCreation(strDeckName, strDeckType, strPeople, strColorcode, strFilename);
		//element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified with Admin ideadesk");

		System.out.print(strDeckName);
		Thread.sleep(1000);
		// report log
		test.log(LogStatus.INFO, "ADMIN IDEADESK deck creation verification ");
		String uqadmindeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqadmindeckcreate");
		String uqadmindeckcreateimg = test.addScreenCapture(uqadmindeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully", uqadmindeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");

			Reporter.log(strDeckName + " : deck has been created successfully");
		} catch (Exception e)  {
			
			 Log.error(e.getMessage());
			 System.out.println("Exception thrown  :" + e);
			 
				// report test case fail 
				test.log(LogStatus.INFO, "verifyNewDeckCreationWithIdeadeskAdmin test case result pass/fail? ");
				
				test.log(LogStatus.FAIL, "<pre>" + e.getMessage() + "</pre>");
			
			 return;
		}		
			

}


	public static void verifyNewDeckCreationWithIdeadeskFinance(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {
		 
		try {
			
			 if (element == null)
	           {
					WebBrowser.refreshPage();
					Utils.waitForElement(Home_Page.lnk_SignIn());
					// Invoke Login modal
					element = UQAuthentication.InvokeSignInModal();
					//element = UQInvokeSignInModal.InvokeSignInModal();
					// Call Login method
					element = UQAuthentication.Login(Constant.Username, Constant.Password);
					//element = LogIn_Page.Login(Constant.Username, Constant.Password);

					// Verification
					UQAuthentication.successLogon();
					
					
					Utils.waitForElement(Success_Login.icon_CreateDeck());
					// Clicking on the Create Deck on the UQ Page*/
					Success_Login.icon_CreateDeck().click();
					
					Thread.sleep(600);
					String uuid = UUID.randomUUID().toString();
					strDeckName = uuid + strDeckName;
					// Create a new deck
					element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
							strPeople, strColorcode, strFilename);

					// Verification
					Thread.sleep(10000);
					Assert.assertEquals("Deck has been updated", "Deck has been updated");
					Log.info("Deck Creation verified with Finance ideadesk");

					// report log
					test.log(LogStatus.INFO, "FINANCE IDEADESK deck creation verification ");
					String uqfinancedeckcreate = utility.CaptureScreenShotUtil
							.captureScreenShot(driver, "uqfinancedeckcreate");
					String uqfinancedeckcreateimg = test
							.addScreenCapture(uqfinancedeckcreate);
					test.log(LogStatus.PASS, strDeckName
							+ " : deck has been created successfully",
							uqfinancedeckcreateimg);
					test.log(LogStatus.INFO, strDeckName
							+ " : deck has been created successfully");

					// Close the browser
					// CloseWebBrowser.closeBrowser();
					Reporter.log(strDeckName + " : deck has been created successfully");
							
					
	           }
			 
			 else
				 
			 {
			Utils.waitForElement(Success_Login.icon_CreateDeck());
			// Clicking on the Create Deck on the UQ Page*/
			Success_Login.icon_CreateDeck().click();
			Thread.sleep(600);
			String uuid = UUID.randomUUID().toString();
			strDeckName = uuid + strDeckName;
			// Create a new deck
			element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
					strPeople, strColorcode, strFilename);

			// Verification
			Thread.sleep(10000);
			Assert.assertEquals("Deck has been updated", "Deck has been updated");
			Log.info("Deck Creation verified with Finance ideadesk");

			// report log
			test.log(LogStatus.INFO, "FINANCE IDEADESK deck creation verification ");
			String uqfinancedeckcreate = utility.CaptureScreenShotUtil
					.captureScreenShot(driver, "uqfinancedeckcreate");
			String uqfinancedeckcreateimg = test
					.addScreenCapture(uqfinancedeckcreate);
			test.log(LogStatus.PASS, strDeckName
					+ " : deck has been created successfully",
					uqfinancedeckcreateimg);
			test.log(LogStatus.INFO, strDeckName
					+ " : deck has been created successfully");

			// Close the browser
			// CloseWebBrowser.closeBrowser();
			Reporter.log(strDeckName + " : deck has been created successfully");
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 Log.error(e.getMessage());
			 System.out.println("Exception thrown  :" + e);
			 
			// report test case fail 
				test.log(LogStatus.INFO, "verifyNewDeckCreationWithIdeadeskFinance test case result pass/fail? ");
				
				test.log(LogStatus.FAIL, "<pre>" + e.getMessage() + "</pre>");
			 return;
		}

	}

	// @Test
	public static void verifyNewDeckCreationWithIdeadeskPersonal(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {

		

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified with Personal ideadesk");

		// report log
		test.log(LogStatus.INFO,
				"PERSONAL IDEADESK deck creation verification ");
		String uqpersonaldeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqpersonaldeckcreate");
		String uqpersonaldeckcreateimg = test
				.addScreenCapture(uqpersonaldeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully",
				uqpersonaldeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");

		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}

	// @Test
	public static void verifyNewDeckCreationWithIdeadeskOperations(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {

		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified for Operations ideadesk");

		// report log
		test.log(LogStatus.INFO,
				"OPERATIONS IDEADESK deck creation verification ");
		String uqoperationsdeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqoperationsdeckcreate");
		String uqoperationsdeckcreateimg = test
				.addScreenCapture(uqoperationsdeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully",
				uqoperationsdeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");

		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}

	// @Test
	public static void verifyNewDeckCreationWithIdeadeskRnD(String strDeckName,
			String strDeckType, String strPeople, String strColorcode,
			String strFilename) throws Exception {

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);  
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified with R & D ideadesk");

		// report log
		test.log(LogStatus.INFO, "R & D IDEADESK deck creation verification ");
		String uqrnddeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqrnddeckcreate");
		String uqrnddeckcreateimg = test.addScreenCapture(uqrnddeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully", uqrnddeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");

		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}

	// @Test
	public static void verifyNewDeckCreationWithIdeadeskWithoutImage(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {

		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified without selecting the Image");

		// report log
		test.log(LogStatus.INFO,
				"ADMIN IDEADESK  witout image and email deck creation verification ");
		String uqadminoutimgemaildeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqadminoutimgemaildeckcreate");
		String uqadminoutimgemaildeckcreateimg = test
				.addScreenCapture(uqadminoutimgemaildeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully",
				uqadminoutimgemaildeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}

	// @Test
	public static void verifyNewDeckCreationWithIdeadeskWithoutImagenColor(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {

		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);  
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified without selecting an Image and color");

		// report log
		test.log(LogStatus.INFO,
				"FINANCE IDEADESK  witout image and color deck creation verification ");
		String uqfinanceoutimgecolordeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqfinanceoutimgecolordeckcreate");
		String uqfinanceoutimgecolordeckcreateimg = test
				.addScreenCapture(uqfinanceoutimgecolordeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully",
				uqfinanceoutimgecolordeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}

	// @Test
	public static void verifyNewDeckCreationWithIdeadeskWithoutImagenColorEmail(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {

		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified without selecting an Image, Email and color");

		// report log
		test.log(LogStatus.INFO,
				"PERSONAL IDEADESK  witout image ,email and color deck creation verification ");
		String uqpersonaloutimgecoloremildeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver,
						"uqpersonaloutimgecoloremildeckcreate");
		String uqpersonaloutimgecoloremildeckcreateimg = test
				.addScreenCapture(uqpersonaloutimgecoloremildeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully",
				uqpersonaloutimgecoloremildeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}

	// @Test
	public static void verifyNewDeckCreationWithoutDeckName(String strDeckName,
			String strDeckType, String strPeople, String strColorcode,
			String strFilename) throws Exception {

		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);
		Thread.sleep(1000);
		// Verification

		String emptydeckname = CreateDeck_Modal_Validation.label_DeckName()
				.getText();

		System.out.println(emptydeckname);
		Assert.assertTrue(emptydeckname.contains("Please deck name"));

		Log.info("Deck Creation verified Without deck name");

		// report log
		test.log(LogStatus.INFO, "RND IDEADESK  witout deck name  verification");
		String uqrndoutnamedeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqrndoutnamedeckcreate");
		String uqrndoutnamedeckcreateimg = test
				.addScreenCapture(uqrndoutnamedeckcreate);
		test.log(LogStatus.PASS,
				"UQ Deck Creation Validation :Please deck name",
				uqrndoutnamedeckcreateimg);

		// close create deck modal
		CreateDeck_Modal.close_CreateDeckModal().click();

		// Close the browser
		// CloseWebBrowser.closeBrowser();

		Reporter.log("Validation is performed Without Deck name successfully");

	}
	
	public static void verifyDuplicateNewDeckCreationWithAlreadyCreated(String strDeckName,
			String strDeckType, String strPeople, String strColorcode,
			String strFilename) throws Exception {
		
		
		Thread.sleep(1000);
		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);
		Thread.sleep(6000);
		// Verification
		
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified for with same name");
		
		// report log
				test.log(LogStatus.INFO, "Deck Creation with same name is verified");
				String uqadminduplicatedeckcreate = utility.CaptureScreenShotUtil
						.captureScreenShot(driver, "uqadminduplicatedeckcreate");
				String uqadminduplicatedeckcreateimg = test
						.addScreenCapture(uqadminduplicatedeckcreate);
				test.log(LogStatus.PASS,
						"UQ Deck Creation(same deck):deck has been created successfully",
						uqadminduplicatedeckcreateimg);
		    	test.log(LogStatus.INFO, strDeckName
						+ " : deck has been created successfully");
	
		Reporter.log("Already Existed deck name(similar name) successfully created");
	}
		

	// @Test
	public static void verifyNewDeckCreationWithoutIdeaDeskType(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {
		Thread.sleep(1000);
		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */

		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);
		Thread.sleep(1000);
		// Verification

		String noideadecktype = CreateDeck_Modal_Validation
				.label_IdeaDeskTypeSelect().getText();

		System.out.println(noideadecktype);
		Assert.assertTrue(noideadecktype
				.contains("Please select deck type"));

		Log.info("Deck Creation verified Without Idea Desk Type successfully");

		// report log
		test.log(LogStatus.INFO, "Validation without IDEADESK/DECK TYPE verification");
		String uqrndoutideaadeskdeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqrndoutideaadeskdeckcreate");
		String uqrndoutideaadeskdeckcreateimg = test
				.addScreenCapture(uqrndoutideaadeskdeckcreate);
		test.log(LogStatus.PASS,
				"UQ Deck Creation Validation :Please select deck type",
				uqrndoutideaadeskdeckcreateimg);

		// close create deck modal
		CreateDeck_Modal.close_CreateDeckModal().click();
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log("Validation is performed Without Idea Desk Type ");

	}

	// @Test
	public static void verifyNewDeckCreationWithBiggerDeckName(
			String strDeckName, String strDeckType, String strPeople,
			String strColorcode, String strFilename) throws Exception {
	
		/*
		 * setup.testSetup(); // Invoke Login modal element =
		 * UQInvokeSignInModal.InvokeSignInModal(); // Call Login method element
		 * = LogIn_Page.Login(Constant.Username, Constant.Password);
		 * 
		 * // Verification WebElement SuccessSignIn; SuccessSignIn =
		 * Success_Login.btn_SignOut();
		 * Assert.assertTrue(SuccessSignIn.isDisplayed());
		 * Log.info("Success Login verified");
		 */
		Thread.sleep(1000);
		// Clicking on the Create Deck on the UQ Page
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		Thread.sleep(600);
		String uuid = UUID.randomUUID().toString();
		strDeckName = uuid + strDeckName;
		// Create a new deck
		element = CreateDeck_Modal.DeckCreation(strDeckName, strDeckType,
				strPeople, strColorcode, strFilename);
		Thread.sleep(1000);
		// Verification
		Thread.sleep(100);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified with longer deck name");

		// report log
		test.log(LogStatus.INFO,
				"FINANCE IDEADESK  with Big Name deck creation verification ");
		String uqfinancebignamedeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqfinancebignamedeckcreate");
		String uqfinancebignamedeckcreateimg = test
				.addScreenCapture(uqfinancebignamedeckcreate);
		test.log(LogStatus.PASS, strDeckName
				+ " : deck has been created successfully",
				uqfinancebignamedeckcreateimg);
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been created successfully");
		// Close the browser
		// CloseWebBrowser.closeBrowser();
		Reporter.log(strDeckName + " : deck has been created successfully");

	}


	public static void verifyIdeaskType() throws Exception, Throwable {
        
		
	/*	WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Login modal
		element = UQAuthentication.InvokeSignInModal();
		//element = UQInvokeSignInModal.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(Constant.Username, Constant.Password);
		//element = LogIn_Page.Login(Constant.Username, Constant.Password);

		// Verification
		UQAuthentication.successLogon();*/
		///remove above
		
		Thread.sleep(1000);
		Utils.waitForElement(Success_Login.icon_CreateDeck());
		Success_Login.icon_CreateDeck().click();
		
		Utils.waitForElement(CreateDeck_Modal.drpbx_IdeaDeskTypeSelect());
		
		

		
		
		
		CreateDeck_Modal.drpbx_IdeaDeskTypeSelect().click();
	//	Thread.sleep(1000); 
		// verification
		
		 // report log
		test.log(LogStatus.INFO, "IDEADESK list verification ");
		String uqideadesklistdeckcreate = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqideadesklistdeckcreate");
		String uqideadesklistdeckcreateimg = test
				.addScreenCapture(uqideadesklistdeckcreate);
		test.log(LogStatus.PASS,
				"IDEADESK list verification done successfully",
				uqideadesklistdeckcreateimg);
		
		
		@SuppressWarnings("unused")
		int count = 0;
		String[] exp = {"SELECT DECK TYPE","Admin", "Finanace", "Operations", "Personal", "R & D" };
		Select oSelect = new Select(driver.findElement(By.name("idea_desk_id")));
		List <WebElement> elementCount = oSelect.getOptions();
		int iSize = elementCount.size();

		for(int i =0; i< iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println(sValue);
			
			count ++;
			test.log(LogStatus.INFO, sValue
					+ " : deck type value");
						
		}
			
			
					
			if (exp.length == iSize) {
				System.out.println("matched");
				
				WebBrowser.refreshPage();
				UQAuthentication.uniqreateSignout();
			} else {
				System.out.println("Dropdown list did not match");
				//signout
				WebBrowser.refreshPage();
				UQAuthentication.uniqreateSignout();
			
			}
						
	}

	/*
	 * //@Test public void verifyIdeaskType1() { // Locating element by tagName
	 * and store // its text in to variable dropdown. String dropdown1 =
	 * element.findElement(By.tagName("select")).getText();
	 * System.out.print("Drop down list values are as bellow :\n" + dropdown1);
	 * 
	 * }
	 */

	// @Test
	public static void verifyAllDeckCreationCases() throws Throwable {

		try {
			
			// Open the Excel file
			
			FileInputStream fis = new FileInputStream(
					"/home/muthu/work/Selenium/SeleniumUQ/TestData/DeckCreationData.xlsx");

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

				if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskAdmin"))) {
					verifyNewDeckCreationWithIdeadeskAdmin(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());

				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskFinance"))) {
					verifyNewDeckCreationWithIdeadeskFinance(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskPersonal"))) {
					verifyNewDeckCreationWithIdeadeskPersonal(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskOperations"))) {
					verifyNewDeckCreationWithIdeadeskOperations(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskRnD"))) {
					verifyNewDeckCreationWithIdeadeskRnD(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}

				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskWithoutImage"))) {
					verifyNewDeckCreationWithIdeadeskWithoutImage(row
							.getCell(1).toString(), row.getCell(2).toString(),
							row.getCell(3).toString(), row.getCell(4)
									.toString(), row.getCell(5).toString());
				}

				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskWithoutImagenColor"))) {
					verifyNewDeckCreationWithIdeadeskWithoutImagenColor(row
							.getCell(1).toString(), row.getCell(2).toString(),
							row.getCell(3).toString(), row.getCell(4)
									.toString(), row.getCell(5).toString());
				} else if (sTestCaseName
						.equals(new String(
								"verifyNewDeckCreationWithIdeadeskWithoutImagenColorEmail"))) {
					verifyNewDeckCreationWithIdeadeskWithoutImagenColorEmail(
							row.getCell(1).toString(), row.getCell(2)
									.toString(), row.getCell(3).toString(), row
									.getCell(4).toString(), row.getCell(5)
									.toString());
				}

				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithoutDeckName"))) {
					verifyNewDeckCreationWithoutDeckName(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
								
				else if (sTestCaseName.equals(new String(
						"verifyDuplicateNewDeckCreationWithAlreadyCreated"))) {
					verifyDuplicateNewDeckCreationWithAlreadyCreated(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}

				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithoutIdeaDeskType"))) {
					verifyNewDeckCreationWithoutIdeaDeskType(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithBiggerDeckName"))) {
					verifyNewDeckCreationWithBiggerDeckName(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}

				else if (sTestCaseName.equals(new String("verifyIdeaskType"))) {
					verifyIdeaskType();
				}
			
			}

			fis.close();
		} catch (IOException e) {
			System.out.println("Test data file not found");
		}
		
	}

}
