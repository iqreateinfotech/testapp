package appModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Upload_Page;
import utility.BaseExtent;
import utility.Constant;
import utility.Log;

import com.relevantcodes.extentreports.LogStatus;

public  class UploadFile_Action extends BaseExtent {
	
	// String fileLocation = "/home/muthu/Downloads/output/pums.txt";

	static String fileLocation = Constant.Path_fileLocation;
	static String filename = Constant.Src_UploadFile;
	static String filepath = Constant.Path_fileLocation
			+ Constant.Src_UploadFile;

	public static void Execute(int iTestCaseRow) throws InterruptedException,
			Exception, AWTException {
        
		Thread.sleep(1000);
		System.out.println(fileLocation);
		System.out.println(filename);
		Upload_Page.view_ExcelDeck().click();
		Log.info("Click action is perfromed on Invoke deck");
		test.log(LogStatus.INFO, "Card view is invoked");
		String CratedDeckInvoke = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "CratedDeckInvoke");
		String CratedDeckInvokeimg = test.addScreenCapture(CratedDeckInvoke);
		test.log(LogStatus.PASS, "CraetedDeckInvoke", CratedDeckInvokeimg);

		Thread.sleep(3000);

		Upload_Page.btn_NewCard().click();
		Thread.sleep(1000);
		Log.info("Click action is perfromed to add a new card");
		test.log(LogStatus.INFO, "Perform to add a new card");
		String newcard = utility.CaptureScreenShotUtil.captureScreenShot(
				driver, "newcard");
		String newcardimg = test.addScreenCapture(newcard);
		test.log(LogStatus.PASS, "CraetedNewCard", newcardimg);

		Thread.sleep(1000);
		// add text into card
		Upload_Page.ck_ContentEditor().click();
		Upload_Page
				.ck_ContentEditor()
				.sendKeys(
						"Finance is a field that deals with the study of investments. Which includes the dynamics of assets and liabilities over time under conditions of different degrees of uncertainty and risk. Finance can also be defined as the science of money management. A key point in finance is the time value of money, which states that purchasing power of one unit of currency can vary over time. Finance aims to price assets based on their risk level and their expected rate of return. Finance can be broken into three different sub-categories: public finance, corporate finance and personal finance.");
		//to sroll down 250 pixcels
		((JavascriptExecutor) driver).executeScript("scroll(0,250)");

		// Upload_Page.txtbx_CardTitle().click();
		// Log.info("Click action is perfromed to enter card title" );
		// test.log(LogStatus.INFO, "Perform to enter card title");

		Thread.sleep(1000);

		Upload_Page.btn_FileUploadZone().click();
		Log.info("Click action is perfromed on File Upload Zone");
		test.log(LogStatus.INFO, "Perform to upload files");

		uploadFile(filepath);
		
		driver.manage().timeouts()
		.implicitlyWait(2000, TimeUnit.MILLISECONDS);
		Assert.assertEquals("Card has been updated", "Card has been updated");
		
		System.out.println("File Uploaded " + filepath);
		
		Thread.sleep(10000);

	
		
		
		//.//*[@id='cardFileDropZone']/div[2]/div/div[1]/div[3]/div[2]/div[2]/table
	
		
		String filedata = Upload_Page.table_FileUploadContent().getText();
		
		System.out.println(filedata);
		// Assert.assertEquals(data.contentEquals("text3.txt"), "Muthu");

		Assert.assertTrue(filedata.contains(filename));
		Log.info("File has been uplaoded successfully");
		// Assert.assertEquals("Card has been updated", data);

		test.log(LogStatus.PASS, "File Upload has been verified");
		String successfileupload = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "successfileupload");
		String successfileuploadimg = test.addScreenCapture(successfileupload);
		test.log(LogStatus.PASS, "FileUploadIntoCard", successfileuploadimg);

		Thread.sleep(1000);

		// to scroll the page to close the opened card

		((JavascriptExecutor) driver).executeScript("scroll(350,0)");

		// jsx.executeScript("window.scrollBy(450,0)", ""); //scroll up

		Upload_Page.icon_CardPopOutClose().click();
		Log.info("Click action is perfromed to close the card");

		Reporter.log("File Upload is successfully perfomred");

	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */

	public static void setClipboardData(String filename) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		// Specify the file location with extension
		StringSelection stringSelection = new StringSelection(filename);
		System.out.println(filename);
		System.out.println(stringSelection);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
		System.out.println("selection" + stringSelection);
	}

	public static void uploadFile(String filepath) {
		try {
			// Setting clipboard with file location
			setClipboardData(filepath);
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
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
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
