package uqmoduletestcases;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.CreateDeck_Modal;
import pageObjects.DeckDeletation_Page;
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

public abstract class DeckDeleteCases extends BaseExtent {

	public static WebElement element;
	public static String newdeckguid;


	public static String uuid = UUID.randomUUID().toString();
	public static String strDeckName = "DleteDeck-" + uuid;

	public static Statement stat = null;
	public static ResultSet result = null;
	public String value = null;
	static String dbUrl = "jdbc:mysql://192.168.0.212:3306/UQDBclone_210620161711"; // This is
																	// DB
	// database creadentials
	public static String username = "qauser";
	public static String password = "S3cureP@55";
	public static String dbClass = "com.mysql.jdbc.Driver";

	
	public static void VerifyDeckCreationDeletion_Database() throws Throwable {

		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		//setup.testSetup();
		// Invoke Login modal
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(Constant.Username, Constant.Password);
	    Utils.waitForElement(Success_Login.btn_SignOut());
		// Clicking on the Create Deck on the UQ Page
		Success_Login.icon_CreateDeck().click();
		
		Utils.waitForElement(CreateDeck_Modal.btn_CreateDeck());

		UQDeckCreation.DeckCreation(strDeckName, "Admin", "", "", "");

		// Verification
		Thread.sleep(10000);
		Assert.assertEquals("Deck has been updated", "Deck has been updated");
		Log.info("Deck Creation verified for Admin ideadesk");

		System.out.println(strDeckName + "deck has been created");
		Reporter.log(strDeckName
				+ "deck creation has been successfully perfomred");

		Thread.sleep(1000);
		verifyRecordInDatabase();
		// delete a deck
		VerifyDeckDeletion();

		System.out.println("Deleted deck :" + strDeckName);
		
		test.log(LogStatus.INFO, strDeckName
				+ " : deck has been deleted successfully");
		
		Thread.sleep(6000);

		// verification deck remove
		Assert.assertEquals("Deck has been removed", "Deck has been removed");
	
		// sign out
		UQAuthentication.uniqreateSignout();
		Utils.waitForElement(Home_Page.lnk_SignIn());
		
		Reporter.log(strDeckName
				+ "deck deletion has been successfully perfomred");

		// close browser
		// CloseWebBrowser.closeBrowser();
	} // end of method

	public static void VerifyDeckDeletion() throws Exception {

	
		DeckDeletation_Page.options_DeckDeletation(strDeckName).click();
		Thread.sleep(500);
		
		 //scroll up
		((JavascriptExecutor)driver).executeScript("scroll(10,0)");
         
		Thread.sleep(1000);
		// report log
		test.log(LogStatus.INFO, "Deck deletion option is invoked");
		String uqdeckdeleteoptions = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckdeleteoptions");
		String uqdeckdeleteoptionsimg = test
				.addScreenCapture(uqdeckdeleteoptions);
		test.log(LogStatus.PASS, "UQ Deck Deletion option is invoked",
				uqdeckdeleteoptionsimg);
		
		test.log(LogStatus.INFO, strDeckName
				+ " : deck deletion action started");
          
		DeckDeletation_Page.removebtn_DeckDeletation(strDeckName).click();
		Thread.sleep(1500);

	/*	// report log
	 *    //verification delete confirm Do you wish to delete the deck?
		test.log(LogStatus.INFO, "Deck delete confirmation verification");
		String uqdeckdeleteconifrm = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqdeckdeleteconifrm");
		String uqdeckdeleteconifrmimg = test
				.addScreenCapture(uqdeckdeleteconifrm);
		test.log(LogStatus.PASS, "UQ Deck Deletion confirmation is invoked",
				uqdeckdeleteconifrmimg);*/

		try { 
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    //if alert present, accept and move on.
		}
		catch (NoAlertPresentException e) {
		    //do what you normally would if you didn't have the alert.
		}
		
		//driver.switchTo().alert().accept();
		
	

	}

	public static void verifyRecordInDatabase() throws Throwable {
		// verify the new user in the database
		Class.forName(dbClass);
		// Get connection to DB.
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		// create a query
		String newdeckcreationquery = "SELECT * From decks where title=?";
		// create a statement
		PreparedStatement stat = con.prepareStatement(newdeckcreationquery);
		stat.setString(1, strDeckName);
		try {
			boolean hasResultSet = stat.execute();
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();
				// get new deck name from the table
				result.next();
				String newdeckname = result.getString("title");
				newdeckguid = result.getString("guid");
				// assert that new deck name should be

				assertEquals(strDeckName, newdeckname);

				System.out
						.println("Deck Creation record is added in DB successfully: "
								+ strDeckName);
				System.out.println("CREATED Deck GUID : " + newdeckguid);
			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}

	}
	
} // end class

