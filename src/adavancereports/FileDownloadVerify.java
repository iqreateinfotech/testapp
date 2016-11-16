package adavancereports;
import java.io.File;
//import java.io.FileFilter;
//import java.nio.file.FileSystems;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardWatchEventKinds;
//import java.nio.file.WatchEvent;
//import java.nio.file.WatchKey;
//import java.nio.file.WatchService;
//import java.util.Arrays;
//import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.comparator.LastModifiedFileComparator;
//import org.apache.commons.io.filefilter.WildcardFileFilter;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Card_PopOutPage;
import pageObjects.CreateDeck_Modal;
//import pageObjects.Home_Page;
import pageObjects.Success_Login;
import reusablecases.UQAuthentication;
//import reusablecases.WebBrowser;
import uqmoduletestcases.setup;
//import utility.BaseExtent;
import utility.Constant;
import utility.Utils;

public class FileDownloadVerify  {
	
	public static WebDriver driver;
	public static WebElement element;
//	public static WebDriver driver;
	
	private static String downloadPath = "/home/muthu/doc/";
	//private String URL="http://spreadsheetpage.com/index.php/file/C35/P10/"; 
/*	
	@BeforeClass
	public void testSetup() throws Exception{
		driver = new FirefoxDriver();
	//	driver = new FirefoxDriver(firefoxProfile());
	    driver.get(Constant.URL);	
		driver.manage().window().maximize();
		
		
	}*/
	
	@Test
	public void example_VerifyDownloadWithFileName() throws Throwable  {
		
		
		
		setup.testSetup();
			//	Thread.sleep(100);  
			//	WebBrowser.refreshPage();
			//	Utils.waitForElement(Home_Page.lnk_SignIn());
						 
				element = UQAuthentication.InvokeSignInModal();
				// Call Login method
				element = UQAuthentication.Login(Constant.Username, Constant.Password);
				Thread.sleep(6000);  
				
				//click on existed deck
			//Utils.waitForElement(Success_Login.btn_SignOut());
				
				UQAuthentication.successLogon();
					
				CreateDeck_Modal.view_ExistedDeck().click();
				
				Thread.sleep(1000);
				
				Card_PopOutPage.view_ExistedCard().click();
				
				   //scroll down 
				((JavascriptExecutor)driver).executeScript("scroll(0,350)");
				Thread.sleep(1000);
				
				Card_PopOutPage.icon_DownloadFileLink().click();
				
			
		
	  //  driver.findElement(By.linkText("mailmerge.xls")).click();
				
	    Assert.assertTrue(isFileDownloaded(downloadPath, "Maid with the Flaxen Hair.mp3"), "Failed to download Expected document");
	}
	
   //    @Test
	public void example_VerifyDownloadWithFileExtension() throws Exception  {
       //driver.get(Constant.URL);	
	   // driver.findElement(By.linkText("mailmerge.xls")).click();
       	
       	
      //setup.testSetup();
	//	Thread.sleep(100);  
	//	WebBrowser.refreshPage();
	//	Utils.waitForElement(Home_Page.lnk_SignIn());
				 
		element = UQAuthentication.InvokeSignInModal();
		// Call Login method
		element = UQAuthentication.Login(Constant.Username, Constant.Password);
		Thread.sleep(100);  
		//click on existed deck
		Utils.waitForElement(Success_Login.btn_SignOut());
			
		CreateDeck_Modal.view_ExistedDeck().click();
		
		Thread.sleep(1000);
		
		Card_PopOutPage.view_ExistedCard().click();
		
		   //scroll down 
		((JavascriptExecutor)driver).executeScript("scroll(0,350)");
		Thread.sleep(1000);
		
		Card_PopOutPage.icon_DownloadFileLink().click();
       	
	    Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ".mp3"), "Failed to download document which has extension .xls");
	}

	//@Test
	public void example_VerifyExpectedFileName() throws Exception {
		//driver.get(URL);
		Card_PopOutPage.icon_DownloadFileLink().click();
	   // driver.findElement(By.linkText("Maid with the Flaxen Hair.mp3")).click();
	    File getLatestFile = getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    Assert.assertTrue(fileName.equals("Maid with the Flaxen Hair.mp3"), "Downloaded file name is not matching with expected file name");
	}
	
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	
	/* Check the file from a specific directory with extension */
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	
	/* Get the latest file from a specific directory*/
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	
	
public static FirefoxProfile firefoxProfile() throws Exception {
		
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList",2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		firefoxProfile.setPreference("browser.download.dir",downloadPath);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
		
		return firefoxProfile;
	}
	

	/*@AfterTest
	public void tearDown() {
		driver.quit();
	}*/
	
}