package uqmoduletestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.Assert;

import uqmoduletestcases.testLog;



//import utility.Log;

//import com.relevantcodes.extentreports.LogStatus;



//import pageObjects.LogIn_Page;
//import utility.Log;
////import utility.Utils;

public class DataDriven {
	  public static WebDriver driver;	
	
	
public static void runTest(String strUserName, String strPassword) {
	
	DOMConfigurator.configure("log4j.xml");
 
  	// From above method we get long test case name including package and class name etc.
  	// The below method will refine your test case name, exactly the name use have used
  
  	
  	// Start printing the logs and printing the Test Case name
	
	
	   driver = new FirefoxDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    testLog.info("Implicit wait applied on the driver for 10 seconds");

	 driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
     driver.get("http://deck.uniqreate.qa/");
     //	Home_Page.lnk_SignIn().click();
     
     driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[2]/span/a")).click();
     testLog.info("Click action is perfromed on Sign In link" );
     driver.findElement(By.id("email")).sendKeys(strUserName);
     driver.findElement(By.id("password")).sendKeys(strPassword);
	 driver.findElement(By.xpath(" .//*[@id='login']/div[4]/button")).click();
	  testLog.info("Click action is performed on Submit button");
         
        // Start a browser driver and navigate to Google
      //  WebDriver driver = new HtmlUnitDriver();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

         // Assert.assertTrue(title.contains("SIGN OUT"));
     		WebElement chk1;
     		chk1 = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/a"));

     		Assert.assertTrue(chk1.isDisplayed());
     	  testLog.info("Login verified");
     		// Assert.assertTrue(title.contains("Uniqreate IDEAS INTELLIGENCE INNOVATION"));
     	
        
        
		// SignOut
		// driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/a")).click();
  
        //Close the browser
      driver.quit();
}


public static void main (String args[]) {
	 
    try {
        // Open the Excel file
        FileInputStream fis = new FileInputStream("/home/muthu/work/Selenium/SeleniumUQ/TestData/default.xlsx");
        // Access the required test data sheet
        @SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        // Loop through all rows in the sheet
        // Start at row 1 as row 0 is our header row
        for(int count = 1;count<=sheet.getLastRowNum();count++){
            XSSFRow row = sheet.getRow(count);
            System.out.println("Running test case " + row.getCell(0).toString());
            String sTestCaseName = row.getCell(0).toString();
            testLog.startTestCase(sTestCaseName);
            // Run the test for the current test data row
            runTest(row.getCell(1).toString(),row.getCell(2).toString());
        }
        fis.close();
    } catch (IOException e) {
        System.out.println("Test data file not found");
    }   
}

}
