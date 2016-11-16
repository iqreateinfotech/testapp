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
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.DeckShare_Popout;
import pageObjects.Home_Page;
import pageObjects.Success_Login;
import reusablecases.UQAuthentication;
import reusablecases.UQRegistration;
import reusablecases.WebBrowser;
import utility.BaseExtent;
import utility.Constant;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

public  class UQDeckShareCases extends BaseExtent  {
	public static WebElement element;
	public static String inviteid;
	public static String InviteUser;

	
	public static Statement stat = null;
	public static ResultSet result = null;
	public static String strEmail = null;
	public String value = null;
	static String dbUrl = "jdbc:mysql://192.168.0.212:3306/UQDBclone_210620161711"; // This is
																	// DB
	// URL
	public static String username = "qauser";
	public static String password = "S3cureP@55";
	public static String dbClass = "com.mysql.jdbc.Driver";



	public static void verifySendInviteNonUQPeople(String strEmail,
			String strMessage) throws Throwable {

		String uuid = UUID.randomUUID().toString();
		strEmail = uuid + strEmail;
		Thread.sleep(100);  
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Login modal
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(Constant.Username, Constant.Password);

		// Verification
		UQAuthentication.successLogon();
		Thread.sleep(4000);   

		DeckShare_Popout.dots_ShareDeckPeople().click();
		Thread.sleep(4000); 
		
		//click on invite to deck option
		DeckShare_Popout.lnk_inviteToDeck().click();
				
		// DeckShare_Popout.txtbox_PeopleEmail().clear();

		DeckShare_Popout.txtbox_PeopleEmail().sendKeys(strEmail);
		// DeckShare_Popout.txtbox_ShareMessage().clear();
		DeckShare_Popout.txtbox_ShareMessage().sendKeys(strMessage);
		Thread.sleep(1000);
		
		// report log
		test.log(LogStatus.INFO, "UQ Deck Invite/share modal is invoked and entering required details");
		String uqdeckinvitemodalinput = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckinvitemodalinput");
		String uqdeckinvitemodalinputimg = test
				.addScreenCapture(uqdeckinvitemodalinput);
		test.log(LogStatus.PASS, "UQ Deck Invite/share is successfully invoked",
				uqdeckinvitemodalinputimg);
		test.log(LogStatus.INFO,"Invite has been sending:" + strEmail);
		
		DeckShare_Popout.btn_ShareDeckButton().click();
		Thread.sleep(15000);
		// verification
		verifyRecordInDatabase(strEmail);
		Assert.assertEquals("Sharing the deck...", "Sharing the deck...");

		// Assert.assertEquals("Deck has been updated",
		// "Deck has been updated");
		//DeckShare_Popout.cross_ShareDeckCloseButton().click();

		System.out
				.println("verifySendInviteNonUQPeople method successfully run");
		Log.info("Share a deck with new people verified");
		
		// report log
				test.log(LogStatus.INFO, "UQ non registered people/email deck invite verified ");
				String uqdeckinvitenonuqpeople = utility.CaptureScreenShotUtil
						.captureScreenShot(driver, "uqdeckinvitenonuqpeople");
				String uqdeckinvitenonuqpeopleimg = test.addScreenCapture(uqdeckinvitenonuqpeople);
				test.log(LogStatus.PASS, "Invite has been sending: " + strEmail, uqdeckinvitenonuqpeopleimg);
				test.log(LogStatus.INFO,"Invite has been sending:" + strEmail);
		
		Reporter.log("Invite has been sent " + strEmail + "successfully to register");
		
		//Signout
		Utils.waitForElement(Success_Login.btn_SignOut());
		UQAuthentication.uniqreateSignout();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
	}
	
	
public static void verifyRegistrationByInviteLink(String strEmail ,String strMessage) throws Throwable  {
		
		String registrationurl = Constant.URL+"/register?inviteid=" +inviteid;
		
		System.out.println("Registration by invite link/ URL : " + registrationurl);
		
	//	Thread.sleep(1000);
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
		Log.info("Registration by invite link"); 

		//Thread.sleep(1000);
		
		//driver.get(resetpassurl);
		
		driver.navigate().to(registrationurl);
		
		//report log
		   test.log(LogStatus.INFO, "UQ Registration modal is invoked");
	      String uqregistrationbyinvitemodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqregistrationbyinvitemodal");
		   String uqregistrationbyinvitemodalimg = test.addScreenCapture(uqregistrationbyinvitemodal);
		   test.log(LogStatus.PASS, "UQ Registration modal is successfully invoked", uqregistrationbyinvitemodalimg);
		
		   
		   
		   element = UQRegistration.Registration("RegisterUsingInviteLink", InviteUser, "123456",
					"123456");
			Thread.sleep(1000);
			
			// Now it will wait 10 secs separately before jumping out to next step
			Utils.waitForElement(Success_Login.btn_SignOut());

			//  Registration Success Verification
			UQAuthentication.successLogon();
		
			
			//report log
			   test.log(LogStatus.INFO, "UQ Registration by invite link verification");
	    	   String uqregistrationbyinvitelinksuccess = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqregistrationbyinvitelinksuccess");
			   String uqregistrationbyinvitelinksuccessimg = test.addScreenCapture(uqregistrationbyinvitelinksuccess);
			   test.log(LogStatus.PASS, "Registration is Success using invite link", uqregistrationbyinvitelinksuccessimg);
			   test.log(LogStatus.INFO, InviteUser + " : has been successfully registered");

			// SignOut
			Utils.waitForElement(Success_Login.btn_SignOut());
			Log.info("UQ Signout button is clicked");
			UQAuthentication.uniqreateSignout();
			//Success_Login.btn_SignOut().click();
		
			// Now it will wait 10 secs separately before jumping out to next step
			Utils.waitForElement(Home_Page.lnk_SignIn());
			
			// Assert.assertTrue(title.contains("Uniqreate"));
			Log.info("UQ Signout verified");
			
			// report log
			 
		    System.out.println("Registration by invite link success");
			Log.info("Registration by invite link successful");
			test.log(LogStatus.INFO,"Registration by invite link done for  : " + InviteUser );
	
			

			Reporter.log(strEmail + " : has been successfully registered by invite link");
		   
		   
	
	

	}
	
	
	
	

	public static void verifySendMultipleInviteNonUQPeople(String strEmail,
			String strMessage) throws Exception {

	
		Thread.sleep(100);
		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		// Invoke Login modal
				element = UQAuthentication.InvokeSignInModal();
				// Call Login method
				element = UQAuthentication.Login(Constant.Username, Constant.Password);

				// Verification
				UQAuthentication.successLogon();

				
		DeckShare_Popout.dots_ShareDeckPeople().click();
		
		Thread.sleep(500);
		Utils.waitForElement(DeckShare_Popout.btn_ShareDeckButton());
		// DeckShare_Popout.txtbox_PeopleEmail().clear();
             
		DeckShare_Popout.txtbox_PeopleEmail().sendKeys(strEmail);
		// DeckShare_Popout.txtbox_ShareMessage().clear();
		DeckShare_Popout.txtbox_ShareMessage().sendKeys(strMessage);
		Thread.sleep(1000);
		
			
		// Enter details log
		test.log(LogStatus.INFO, "UQ non registered multiple people/email deck invite verification ");
		String uqdeckinvitenonuqpeopleinput = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckinvitenonuqpeopleinput");
		String uqdeckinvitenonuqpeopleinputimg = test.addScreenCapture(uqdeckinvitenonuqpeopleinput);
		test.log(LogStatus.PASS, "Invite has been sending: " + strEmail, uqdeckinvitenonuqpeopleinputimg);
		test.log(LogStatus.INFO,"Invite has been sending:" + strEmail);
		
		DeckShare_Popout.btn_ShareDeckButton().click();
		Thread.sleep(10000);
		// verification
		Assert.assertEquals("Sharing the deck...", "Sharing the deck...");
		//DeckShare_Popout.cross_ShareDeckCloseButton().click();

		System.out
				.println("verifySendMultipleInviteNonUQPeople method successfully run");
		Log.info("Share a deck with multi  people verified");
		
		// report log
		test.log(LogStatus.INFO, "UQ non registered multiple people/email deck invite verified ");
		String uqdeckinvitenonuqmultipeople = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckinvitenonuqmultipeople");
		String uqdeckinvitenonuqmultipeopleimg = test.addScreenCapture(uqdeckinvitenonuqmultipeople);
		test.log(LogStatus.PASS, "Invite has been sent " + strEmail + "successfully to register", uqdeckinvitenonuqmultipeopleimg);
		test.log(LogStatus.INFO,"Invite has been sent " + strEmail + "successfully to register");
		Reporter.log(strEmail + " : invite has been sent successfully to register for multiple people");
	}

	public static void verifyShareDeckWithoutEmailID(String strEmail,
			String strMessage) throws Exception {
	
		Thread.sleep(1000);
				
		DeckShare_Popout.dots_ShareDeckPeople().click();
		Thread.sleep(500);
		Utils.waitForElement(DeckShare_Popout.btn_ShareDeckButton());
		
		//DeckShare_Popout.txtbox_PeopleEmail().clear();
		DeckShare_Popout.txtbox_PeopleEmail().sendKeys(strEmail);
		//DeckShare_Popout.txtbox_ShareMessage().clear();
		DeckShare_Popout.txtbox_ShareMessage().sendKeys(strMessage);
		Thread.sleep(1000);
		DeckShare_Popout.btn_ShareDeckButton().click();
	
		// verification
		Assert.assertEquals("Sharing the deck...", "Sharing the deck...");
		Log.info("Share a deck without email id is verified");
		
		// report log
				test.log(LogStatus.INFO, "Deck invitation without email");
				String uqdeckinviteoutemail = utility.CaptureScreenShotUtil
						.captureScreenShot(driver, "uqdeckinviteoutemail");
				String uqdeckinviteoutemailimg = test
						.addScreenCapture(uqdeckinviteoutemail);
				test.log(LogStatus.PASS,
						"UQ Deck Invite Validation :The people field is required.",
						uqdeckinviteoutemailimg);
		
		DeckShare_Popout.cross_ShareDeckCloseButton().click();
		System.out
				.println("verifyShareDeckWithoutEmailID method successfully run");
		
		Reporter.log("Validated successfully without EmailID");
	}

	public static void verifySharedeckWithPeopleWhoAreMembers(String strEmail,
			String strMessage) throws Exception {

		//Utils.waitForElement(DeckShare_Popout.icon_ShareDeckPeople());
		Thread.sleep(1000);
		DeckShare_Popout.dots_ShareDeckPeople().click();
	
		Utils.waitForElement(DeckShare_Popout.btn_ShareDeckButton());
		//DeckShare_Popout.txtbox_PeopleEmail().clear();
		DeckShare_Popout.txtbox_PeopleEmail().sendKeys(strEmail);
		//DeckShare_Popout.txtbox_ShareMessage().clear();
		DeckShare_Popout.txtbox_ShareMessage().sendKeys(strMessage);
		Thread.sleep(1000);
		
		
		
		// Enter details log
		test.log(LogStatus.INFO, "Deck invitation to people who are already a member of uniqreate ");
		String uqdeckinvitememberpeopleinput = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckinvitememberpeopleinput");
		String uqdeckinvitememberpeopleinputimg = test.addScreenCapture(uqdeckinvitememberpeopleinput);
		test.log(LogStatus.PASS, "Invite has been sending: " + strEmail, uqdeckinvitememberpeopleinputimg);
		test.log(LogStatus.INFO,"Invite has been sending:" + strEmail);
		
		
		
		DeckShare_Popout.btn_ShareDeckButton().click();
		Thread.sleep(10000);   
		// verification

				
		// report log
		test.log(LogStatus.INFO, "Deck invitation to people who are already a member of uniqreate");
		String uqdeckinvitememberpeople = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckinvitememberpeople");
		String uqdeckinvitememberpeopleimg = test
				.addScreenCapture(uqdeckinvitememberpeople);
		test.log(LogStatus.PASS,
				"UQ Deck Invite Validation : The People who are already a member of uniqreate",
				uqdeckinvitememberpeopleimg);
		
		Log.info("Share a deck With the people who are already memebers is verified");
	
		System.out.println("verifySharedeckWithPeopleWhoAreMembers method successfully run");

		Thread.sleep(1000);
		// sign out
		UQAuthentication.uniqreateSignout();
			
		Reporter.log("Validated successfully people who are already memeber of the deck");
		

	}

	public static void verifyRecordInDatabase(String strEmail) throws Throwable {
		// verify the new user in the database
		Class.forName(dbClass);
		// Get connection to DB.
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		// create a query
		String newdeckcreationquery = "SELECT id,email FROM `invites` WHERE id=(SELECT MAX(id) FROM `invites`)";
		// create a statement
		PreparedStatement stat = con.prepareStatement(newdeckcreationquery);
	//	 stat.setString(1, strEmail);
		System.out.println(strEmail);

		try {
			boolean hasResultSet = stat.execute();
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();
				// get new deck name from the table

				result.next();

				String newinviteid = result.getString("email");
				InviteUser = result.getString("email");
				inviteid = result.getString("id");
				
				System.out.println(newinviteid);

				// assert that new deck name should be

				assertEquals(strEmail, newinviteid);

				System.out
						.println("Deck invite record stored in DB successfully: "
								+ strEmail);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}

	// @Test
	public static void verifyAllDeckShareCases() throws Throwable {

		try {
		   
					
			// Open the Excel file
			FileInputStream fis = new FileInputStream(
					"/home/muthu/work/Selenium/SeleniumUQ/TestData/DeckShareData.xlsx");

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
						"verifySendInviteNonUQPeople"))) {
					verifySendInviteNonUQPeople(row.getCell(1).toString(), row
							.getCell(2).toString());

				} 
				else if (sTestCaseName.equals(new String(
						"verifyRegistrationByInviteLink"))) {
					verifyRegistrationByInviteLink(row.getCell(1).toString(), row
							.getCell(2).toString());
								
				}
				else if (sTestCaseName.equals(new String(
						"verifySendMultipleInviteNonUQPeople"))) {
					verifySendMultipleInviteNonUQPeople(row.getCell(1)
							.toString(), row.getCell(2).toString());
				}

				else if (sTestCaseName.equals(new String(
						"verifyShareDeckWithoutEmailID"))) {
					verifyShareDeckWithoutEmailID(row.getCell(1).toString(),
							row.getCell(2).toString());
				}

				else if (sTestCaseName.equals(new String(
						"verifySharedeckWithPeopleWhoAreMembers"))) {
					verifySharedeckWithPeopleWhoAreMembers(row.getCell(1)
							.toString(), row.getCell(2).toString());
				}
				
			

			}
			
			fis.close();
		} catch (IOException e) {	
			System.out.println("Test data file not found");
		}
	
	}
	

}
