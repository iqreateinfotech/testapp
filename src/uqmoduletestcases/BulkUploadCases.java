package uqmoduletestcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.Card_PopOutPage;
import pageObjects.CreateDeck_Modal;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.Success_Login;
import pageObjects.Upload_Page;
import reusablecases.WebBrowser;
import reusablecases.UQAuthentication;
import utility.BaseExtent;
import utility.Constant;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

public class BulkUploadCases extends BaseExtent {
	
	public BulkUploadCases(WebDriver driver) {
		// super(driver);
		// TODO Auto-generated constructor stub
	}


	public static String strFilename;
	public static WebElement element;

		static String bukuploadpath = Constant.Path_bulkfileLocation;
		static String filename = Constant.Src_UploadFile;
		static String filepath = Constant.Path_fileLocation
				+ Constant.Src_UploadFile;

		@Test
		public static void verifyBulkFileUpload() throws Exception, AWTException {

			Utils.waitForElement(Home_Page.lnk_SignIn());
			// Invoke Login modal
			element = UQAuthentication.InvokeSignInModal();
			// Call Login method
			element = LogIn_Page.Login(Constant.Username, Constant.Password);
			//wait for element
			Utils.waitForElement(Success_Login.btn_SignOut());
			//click on existed deck
			CreateDeck_Modal.view_ExistedDeck().click();
			//Thread.sleep(1000);
			
			//wait for new card element
			Utils.waitForElement(Card_PopOutPage.icon_AddNewCard());
			//click on add new card
			Card_PopOutPage.icon_AddNewCard().click();
			Utils.waitForElement(Card_PopOutPage.icon_AddtoAnalysis());
		    Card_PopOutPage.txtbox_CardContent().click();
		    Card_PopOutPage.txtbox_CardContent().sendKeys("Sport (UK) or sports (US) are all forms of usually competitive physical activity or games which, through casual or organised participation, aim to use, maintain or improve physical ability and skills while providing entertainment to participants, and in some cases, spectators.");
		    Thread.sleep(200);
			((JavascriptExecutor)driver).executeScript("scroll(0,250)");
			Thread.sleep(1000);
			

			// Upload_Page.txtbx_CardTitle().click();
			// Log.info("Click action is perfromed to enter card title" );
			// test.log(LogStatus.INFO, "Perform to enter card title");

			Thread.sleep(1000);

			Upload_Page.btn_FileUploadZone().click();
			Log.info("Click action is perfromed on File Upload Zone");
		

			uploadFile(bukuploadpath);
			
			driver.manage().timeouts()
			.implicitlyWait(20000, TimeUnit.MILLISECONDS);
			
			Assert.assertEquals("Card has been updated", "Card has been updated");
			
			System.out.println("File Uploaded " + bukuploadpath);
			
			Thread.sleep(10000);

			//report log
			test.log(LogStatus.INFO, "Bulk Upload verification");
			String uqbulkuploadedfilenewcard = utility.CaptureScreenShotUtil
					.captureScreenShot(driver, "uqbulkuploadedfilenewcard");
			String uqbulkuploadedfilenewcardimg = test
					.addScreenCapture(uqbulkuploadedfilenewcard);
			test.log(LogStatus.PASS,
					"Multi Files are Uploaded successfully ",
					uqbulkuploadedfilenewcardimg);
			test.log(LogStatus.INFO, strFilename + "file has been uploaded successfully");

			Thread.sleep(1000);

			// to scroll the page to close the opened card

			((JavascriptExecutor) driver).executeScript("scroll(300,0)");

			// jsx.executeScript("window.scrollBy(450,0)", ""); //scroll up

			Upload_Page.icon_CardPopOutClose().click();
			Log.info("Click action is perfromed to close the card");

			Reporter.log("Files are  Uploaded is successfully perfomred");
			
			//close browser
			
			// Close the browser
			WebBrowser.closeBrowser();

		}

		/**
		 * This method will set any parameter string to the system's clipboard.
		 */

		public static void setClipboardData(String bukuploadpath) {
			// StringSelection is a class that can be used for copy and paste
			// operations.
			// Specify the file location with extension
			StringSelection stringSelection = new StringSelection(bukuploadpath);
			System.out.println(bukuploadpath);
			System.out.println(stringSelection);
			Toolkit.getDefaultToolkit().getSystemClipboard()
					.setContents(stringSelection, null);
			System.out.println("selection" + stringSelection);
		}

		public static void uploadFile(String bukuploadpath) {
			try {
				// Setting clipboard with file location
				setClipboardData(bukuploadpath);
				// native key strokes for CTRL, V and ENTER keys
				Robot robot = new Robot();
				/*
				 * // Press Enter robot.keyPress(KeyEvent.VK_ENTER); // Release
				 * Enter robot.keyRelease(KeyEvent.VK_ENTER); // Press CTRL+V
				 * robot.keyPress(KeyEvent.VK_CONTROL);
				 * robot.keyPress(KeyEvent.VK_V); // Release CTRL+V
				 * robot.keyRelease(KeyEvent.VK_CONTROL);
				 * robot.keyRelease(KeyEvent.VK_V); Thread.sleep(1000); //Press
				 * Enter robot.keyPress(KeyEvent.VK_ENTER);
				 * robot.keyRelease(KeyEvent.VK_ENTER); Thread.sleep(1000);
				 */
				
	// to clear the previous text in file upload loction
				
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyPress(KeyEvent.VK_DELETE);

				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_DELETE);
				
				
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				// Release CTRL+V
				Thread.sleep(300);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(1000);
								
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Thread.sleep(300);
			
				//tab
				
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_TAB);
				Thread.sleep(300);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(100);
				
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_TAB);
				
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_TAB);

				// Press Enter - Calling key press event to press Enter Key from
				// keyboard to place cursor in window textbox
				// robot.keyPress(KeyEvent.VK_ENTER);
				// Release Enter
				// robot.keyRelease(KeyEvent.VK_ENTER);
				/*
				 * // Press CTRL+V Now we are going to trigger CTRL+V action so
				 * first we will press CTRL and then V and finally will release
				 * these key.
				 */
				Thread.sleep(100);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				// Release CTRL+V
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_A);
				Thread.sleep(100);
				// Press Enter
				// After pasting path now we are going to click on Open and that can
				// be triggered by pressing enter key from Keyboard.
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				// Release open
				Thread.sleep(1000);

			} catch (Exception exp) {
				exp.printStackTrace();
			}
		}

	


}
