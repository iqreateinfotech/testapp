package uqmoduletestcases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Card_PopOutPage;
import pageObjects.CreateDeck_Modal;
import pageObjects.Home_Page;
import pageObjects.Success_Login;
import pageObjects.Upload_Page;
import reusablecases.UQAuthentication;
import reusablecases.WebBrowser;
import utility.BaseExtent;
import utility.Constant;
import utility.Log;
import utility.UQUploadFileUtilRobot;
import utility.Utils;

import com.relevantcodes.extentreports.LogStatus;

public abstract class MultipleFileUploadCases extends BaseExtent {



	public static String strFilename;
	public static WebElement element;
	//public static WebElement driver;
	
   //@Test
	public static void verifyMultiFileUpload() throws Exception, AWTException {
		
    
		 
		//setup.testSetup();

		WebBrowser.refreshPage();
		Utils.waitForElement(Home_Page.lnk_SignIn());
				 
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(Constant.Username, Constant.Password);
		Thread.sleep(100);  
		//click on existed deck
		Utils.waitForElement(Success_Login.btn_SignOut());
			
		CreateDeck_Modal.view_ExistedDeck().click();
		
		Thread.sleep(1000);
		
		// report log
		test.log(LogStatus.INFO, "Invoked Deck to upload the documents/files");
		String uqexistdeckopen = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqexistdeckopen");
		String uqexistdeckopenimg = test
				.addScreenCapture(uqexistdeckopen);
		test.log(LogStatus.PASS,
				"User invoked existed/created Deck",
				uqexistdeckopenimg);
		//click on add new card
		Utils.waitForElement(Card_PopOutPage.icon_AddNewCard());
		Card_PopOutPage.icon_AddNewCard().click();
		Thread.sleep(1000);
		
		// report log
		test.log(LogStatus.INFO, "Added a new card");
		String uqaddnewcard = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqaddnewcard");
		String uqaddnewcardimg = test
				.addScreenCapture(uqaddnewcard);
		test.log(LogStatus.PASS,
				"New Card is added",
				uqaddnewcardimg);
		
	    Card_PopOutPage.txtbox_CardContent().click();
	    Card_PopOutPage.txtbox_CardContent().sendKeys("Sport (UK) or sports (US) are all forms of usually competitive physical activity or games which, through casual or organised participation, aim to use, maintain or improve physical ability and skills while providing entertainment to participants, and in some cases, spectators.");
	    Thread.sleep(200);
	    
		//report log
		test.log(LogStatus.INFO, "Added a content into a new card");
		String uqaddcontentnewcard = utility.CaptureScreenShotUtil
				.captureScreenShot(driver, "uqaddcontentnewcard");
		String uqaddcontentnewcardimg = test
				.addScreenCapture(uqaddcontentnewcard);
		test.log(LogStatus.PASS,
				"Content is added into the card",
				uqaddcontentnewcardimg);
	    
	    //scroll down 
		((JavascriptExecutor)driver).executeScript("scroll(0,350)");
		Thread.sleep(1000);
				
	
		try {

			FileInputStream file = new FileInputStream(new File(
					"/home/muthu/work/Selenium/SeleniumUQ/TestData/FileUploadData.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				String strFilename = sheet.getRow(i).getCell(0)
						.getStringCellValue();

				System.out.println("Before File Uploaded " + strFilename);
				// searchbox.clear();
				Thread.sleep(1000);
				Upload_Page.btn_FileUploadZone().click();
				//driver.findElement(By.xpath(".//*[@id='files-upload-header']")).click();
				Thread.sleep(1000);

				UQUploadFileUtilRobot.uploadFile(strFilename);
				// uploadFile(strFilename);

				driver.manage().timeouts()
						.implicitlyWait(2000, TimeUnit.MILLISECONDS);
				Assert.assertEquals("Card has been updated",
						"Card has been updated");

				System.out.println("File Uploaded :" + strFilename);
				 Thread.sleep(10000);
				//driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
				//verification			 
			   String data = Upload_Page.table_FileUploadContent().getText();
			   System.out.println(data);
				
				//wait for upload file list to appear 
				Utils.waitForElement(Upload_Page.table_FileUploadContent());
				//Utils.waitForFileUploadList(Upload_Page.table_FileUploadContent(),data);
				
				Assert.assertTrue(data.contains(strFilename));
				driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
				
				//report log
								
				test.log(LogStatus.INFO, "Uplaoded file verification");
				String uquploadedfilenewcard = utility.CaptureScreenShotUtil
						.captureScreenShot(driver, strFilename);
				//uquploadedfilenewcard= strFilename;
				String uquploadedfilenewcardimg = test
						.addScreenCapture(uquploadedfilenewcard);
				test.log(LogStatus.PASS,
						"Files are Uploaded successfully ",
						uquploadedfilenewcardimg);
				test.log(LogStatus.INFO, strFilename + "file has been uploaded successfully");
				
				Thread.sleep(1000);

				
			}
			
			// to scroll the page to close the opened card

			((JavascriptExecutor) driver).executeScript("scroll(350,0)");

			// jsx.executeScript("window.scrollBy(450,0)", ""); //scroll up

			Upload_Page.icon_CardPopOutClose().click();
			Log.info("Click action is perfromed to close the card");
			
			Thread.sleep(1000);
			//report log
			test.log(LogStatus.INFO, "Closing the card popout");
			String uqclosecardpopout = utility.CaptureScreenShotUtil
					.captureScreenShot(driver, "uqclosecardpopout");
			String uqclosecardpopoutimg = test
					.addScreenCapture(uqclosecardpopout);
			test.log(LogStatus.PASS,
					"Files are Uploaded successfully ",
					uqclosecardpopoutimg);
					
			
			//
			WebBrowser.refreshPage();
			//Signout
			Utils.waitForElement(Success_Login.btn_SignOut());
			UQAuthentication.uniqreateSignout();
			Reporter.log(strFilename + "file has been uploaded successfully");
			
						 
			 WebBrowser.closeBrowser();
			 
			workbook.close();
			file.close();
			//driver.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
