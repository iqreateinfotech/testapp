package uqmoduletestcases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.Log;

public class UQShareDeckThroughInvite {
	public static WebDriver driver;
	public static Connection con = null;
	public Statement stmt = null;
	// / Registration cases by invite
	
	public static WebElement element;


	// static String fileLocation = "/home/muthu/Uniqreate/TestData/Photo/";
	// static String strFilename;
	// protected static String pathoffile =fileLocation + strFilename;


	
	
	@Test
	public static void verifyNewRegistrationByInvite(String strName,
			String strEmail, String strPassword, String strConfirmPassword)
			throws Exception {

		// Invoke home page of UQ
		// driver=setup.testSetup();
		// Invoke Registration modal..

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.get("http://deck.uniqreate.qa/");
		driver.get("http://deck.uniqreate.qa/auth/register?inviteid=826");

		Thread.sleep(10000);
		Log.info("Verify new registarion through invitaion link ");
		// Registration
		driver.findElement(By.xpath(".//*[@id='register']/div[1]/div/input"))
				.sendKeys(strName);
		driver.findElement(By.xpath(".//*[@id='register']/div[2]/div/input"))
				.sendKeys(strEmail);
		driver.findElement(By.xpath(".//*[@id='register']/div[3]/div/input"))
				.sendKeys(strPassword);
		driver.findElement(By.xpath(".//*[@id='register']/div[4]/div/input"))
				.sendKeys(strConfirmPassword);
		driver.findElement(By.xpath(".//*[@id='register']/div[5]/button"))
				.click();
		Thread.sleep(1000);

		// Verification
		WebElement chk1;
		chk1 = driver.findElement(By
				.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a"));

		Assert.assertTrue(chk1.isDisplayed());

		Log.info("Registration through invite link is verified");

		// SignOut

		Log.info("UQ Signout button is clicked");
		driver.findElement(
				By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a"))
				.click();

		// Assert.assertTrue(title.contains("Uniqreate"));
		Log.info("UQ Signout verified");

		// Close the browser
		driver.quit();

	}

	@Test
	public static void verifyAlreadyUsedInvitation(String strName,
			String strEmail, String strPassword, String strConfirmPassword)
			throws Exception {
  
		  //private WebDriver driver = null;
		  //private Connection con = null;
		 // private Statement stmt = null;
		  //String baseUrl;

		// Add a new user on the UI
	    String newtestInviteid = "newid";
	  
	    
		// Invoke home page of UQ
		// driver=setup.testSetup();
		// Invoke Registration modal..
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.get("http://deck.uniqreate.qa/");
		driver.get("http://deck.uniqreate.qa/auth/register?inviteid=824");
		/*
		 * testLog.info("Verify new registarion through invitaion link "); //
		 * Call Registration method driver= UQRegistration.Registration(strName,
		 * strEmail, strPassword, strConfirmPassword);
		 */
		Thread.sleep(1000);

		// Verification
		String usedinvitelink = driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[2]/div"))
				.getText();

		System.out.println(usedinvitelink);
		Assert.assertTrue(usedinvitelink
				.contains("Invitation request has been used or not initiated"));
		
		
		//Verification through database
     //   invitequery = "Select * from invites ";
		
		 // verify the new user in the database
	    // create a query
	    String newinvitequery = "SELECT * From invites where id=?";
	    // create a statement
	    PreparedStatement stat = con.prepareStatement(newinvitequery);
	    stat.setString(1, newtestInviteid);
	    try {
	      boolean hasResultSet = stat.execute();
	      if (hasResultSet) {
	        ResultSet result = stat.getResultSet();
	        // get new user name from the table

	        String newid = result.getString("id");
	        // assert that new user name should be
	        Assert.assertEquals(newtestInviteid, newid);
	      }
	    } catch (SQLException ex)

	    {
	      System.out.println(ex);
	    } finally {
	      con.close();
	    }


		// Close the Registration modal..
		driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[1]/div/button"))
				.click();

		// Close the browser
		driver.quit();

	}

	@Test
	public static void verifyUQExistUser(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {

		// Invoke home page of UQ
	//	setup.testSetup();
		// Invoke Registration modal..
		/*
		 * driver=new FirefoxDriver();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * testLog.info("Implicit wait applied on the driver for 10 seconds");
		 * driver.manage().deleteAllCookies();
		 * driver.manage().window().maximize();
		 */
		// driver.get("http://deck.uniqreate.qa/");
		driver.get("http://deck.uniqreate.qa/auth/register?inviteid=830");
		testLog.info("Verify UQExistUser through invitaion link ");

		// Verification
		String existuserinvite = driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[2]/div"))
				.getText();

		System.out.println(existuserinvite);
		Assert.assertTrue(existuserinvite
				.contains("You have been added to the deck, please login to access the deck"));

		// Close the Registration modal..
		driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[1]/div/button"))
				.click();

		// Close the browser
		driver.quit();

	}

	@Test
	public static void invitationNotSent(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {

		// Invoke home page of UQ
		// driver=setup.testSetup();
		// Invoke Registration modal..
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit wait applied on the driver for 10 seconds");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.get("http://deck.uniqreate.qa/");
		driver.get("http://deck.uniqreate.qa/auth/register?inviteid=900");
		Log.info("Verify invite link has not yet sent to user");

		Thread.sleep(1000);

		// Verification
		String usedinvitelink = driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[2]/div"))
				.getText();

		System.out.println(usedinvitelink);
		Assert.assertTrue(usedinvitelink
				.contains("Invitation request has been used or not initiated"));

		// Close the Registration modal..
		driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[1]/div/button"))
				.click();

		// Close the browser
		driver.quit();

	}

	// Verify Send invitation more than once

	@Test
	public static void verifySendEmailMoreThanOnce(String strName,
			String strEmail, String strPassword, String strConfirmPassword)
			throws Exception {

		// Invoke home page of UQ
		// driver=setup.testSetup();
		// Invoke Registration modal..
		driver.get("http://deck.uniqreate.qa/auth/register?inviteid=825");
		Log.info("Verify new registarion through invitaion link ");
		// Registration
		driver.findElement(By.xpath(".//*[@id='register']/div[1]/div/input"))
				.sendKeys(strName);
		driver.findElement(By.xpath(".//*[@id='register']/div[2]/div/input"))
				.sendKeys(strEmail);
		driver.findElement(By.xpath(".//*[@id='register']/div[3]/div/input"))
				.sendKeys(strPassword);
		driver.findElement(By.xpath(".//*[@id='register']/div[4]/div/input"))
				.sendKeys(strConfirmPassword);
		driver.findElement(By.xpath(".//*[@id='register']/div[5]/button"))
				.click();
		Thread.sleep(1000);

		// Verification
		String existuserinvite = driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[2]/div"))
				.getText();

		System.out.println(existuserinvite);
		Assert.assertTrue(existuserinvite
				.contains("User has been added into deck"));

		// Close the Registration modal..
		driver.findElement(
				By.xpath(".//*[@id='register-modal']/div/div/div[1]/div/button"))
				.click();

		// Close the browser
		driver.quit();

	}

}
