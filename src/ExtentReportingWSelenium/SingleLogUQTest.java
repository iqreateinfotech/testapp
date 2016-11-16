package ExtentReportingWSelenium;

import java.util.concurrent.TimeUnit;

import library.ScreenShotUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class SingleLogUQTest extends BaseExtent_old {
		

private final String filePath = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQReport.html";
    
    @BeforeClass
    public void beforeClass() {
    	
        extent = new ExtentReports(filePath, true);
        
        // optional - to store all results in a database
       // extent.startReporter(ReporterType.DB, "extent.db");
        
        extent.addSystemInfo("Host Name", "Muthu");
    }
    
    @Test
	public void verifyUniQreateLoginTest() throws Exception {
        
				
	  //  report = new ExtentReports("/home/muthu/work/Selenium/SeleniumUQ/Reports/UQAutomationReport.html");

		test = extent.startTest("VerifyUQTestCasesWithScreenshot");
		
		test.assignCategory("Regression");
		

		
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser started ");

		driver.get("http://deck.uniqreate.qa/");

		test.log(LogStatus.INFO, "UQ Application is up and running");

		String homepage = ScreenShotUtil.captureScreenShot(driver, "homepage");

		String image1 = test.addScreenCapture(homepage);
		test.log(LogStatus.PASS, "home page", image1);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Uniqreate"));

		test.log(LogStatus.PASS, "Title verified");

		driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[2]/span/a")).click();

		test.log(LogStatus.INFO, "UQ Login modal is invoked");

		ScreenShotUtil.captureScreenShot(driver, "Loginmodal");
		String loginmodal = ScreenShotUtil.captureScreenShot(driver, "Loginmodal");
		String image2 = test.addScreenCapture(loginmodal);
		test.log(LogStatus.PASS, "login", image2);
		

		// Login

		test.log(LogStatus.INFO, "Entering UQ Login Creadentials");

		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("muthu@iqreateinfotech.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath(" .//*[@id='login']/div[4]/button")).click();

		// Assert.assertTrue(title.contains("SIGN OUT"));
		WebElement chk1;
		chk1 = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a"));

		Assert.assertTrue(chk1.isDisplayed());

		// Assert.assertTrue(title.contains("Uniqreate IDEAS INTELLIGENCE INNOVATION"));
		test.log(LogStatus.PASS, "Login verified");

		ScreenShotUtil.captureScreenShot(driver, "Loginsuccess");
		String Loginsuccess = ScreenShotUtil.captureScreenShot(driver, "Loginsuccess");
		String image3 = test.addScreenCapture(Loginsuccess);
		test.log(LogStatus.PASS, "login", image3);

		// driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
		// TestNGThread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		// SignOut

		test.log(LogStatus.INFO, "UQ Signout button is clicked");
     driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a")).click();
	//	driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/a")).click();
		Assert.assertTrue(title.contains("Uniqreate"));
		test.log(LogStatus.PASS, "UQ Signout verified");
		
		Registration reg =new Registration();
		reg.verifyUniQreateRegistrationTest();

	}
    
    /*
        
    @Test
    public void passTest() {
        test = extent.startTest("passTest");
        test.log(LogStatus.PASS, "Pass");
        
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
    }
    
         
    @Test
    public void failTest() {
        test = extent.startTest("failTest");
        test.log(LogStatus.FAIL, "Fail");
        
        Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
    }*/
    
    
}



