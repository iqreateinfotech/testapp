package ExtentReportingWSelenium;

import java.util.concurrent.TimeUnit;

import library.ScreenShotUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
// import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Registration extends BaseExtent_old {
		
	/*
private final String filePath = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQReport.html";
    
    @BeforeClass
    public void beforeClass() {
    	
        extent = new ExtentReports(filePath, true);
        
        // optional - to store all results in a database
       // extent.startReporter(ReporterType.DB, "extent.db");
        
        extent.addSystemInfo("Host Name", "Muthu");
        
 
    }*/
	
	@Test
	public  void verifyUniQreateRegistrationTest() throws Exception {
        
				
	  //  report = new ExtentReports("/home/muthu/work/Selenium/SeleniumUQ/Reports/UQAutomationReport.html");
	//	test = extent.startTest("VerifyUQReigistrationCasesWithScreenshot");
		/*	
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser started ");

		driver.get("http://deck.uniqreate.qa/");

		test.log(LogStatus.INFO, "UQ Application is up and running");

		String homepage = Utility.captureScreenShot(driver, "homepage");

		String Imagehomepage = test.addScreenCapture(homepage);
		test.log(LogStatus.PASS, "home page", Imagehomepage);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Uniqreate"));

		test.log(LogStatus.PASS, "Title verified");*/

		driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[1]/span/a")).click();

		test.log(LogStatus.INFO, "UQ Registration modal is invoked");

		ScreenShotUtil.captureScreenShot(driver, "Registrationmodal");
		String Registrationmodal = ScreenShotUtil.captureScreenShot(driver, "Registrationmodal");
		String ImageRegistration = test.addScreenCapture(Registrationmodal);
		test.log(LogStatus.PASS, "login", ImageRegistration);
		

		// Registration

		test.log(LogStatus.INFO, "Entering UQ Registration Creadentials");

		driver.findElement(By.xpath(".//*[@id='register']/div[1]/div/input")).sendKeys("RENGA SUBRAMANI5");
		driver.findElement(By.xpath(".//*[@id='register']/div[2]/div/input")).sendKeys("rengasubramani5@iqreateinfotech.com");
		driver.findElement(By.xpath(".//*[@id='register']/div[3]/div/input")).sendKeys("123456");
		driver.findElement(By.xpath(".//*[@id='register']/div[4]/div/input")).sendKeys("123456");
		driver.findElement(By.xpath(".//*[@id='register']/div[5]/button")).click();

		// Assert.assertTrue(title.contains("SIGN OUT"));
		WebElement chk1;
		chk1 = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a"));

		Assert.assertTrue(chk1.isDisplayed());

		// Assert.assertTrue(title.contains("Uniqreate IDEAS INTELLIGENCE INNOVATION"));
		test.log(LogStatus.PASS, "Registration verified");

		ScreenShotUtil.captureScreenShot(driver, "Registrationsuccess");
		String Registrationsuccess = ScreenShotUtil.captureScreenShot(driver, "Registrationsuccess");
		String ImageRegistrationsuccess = test.addScreenCapture(Registrationsuccess);
		test.log(LogStatus.PASS, "login", ImageRegistrationsuccess);

		// driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
		// TestNGThread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		// SignOut

		test.log(LogStatus.INFO, "UQ Signout button is clicked");
		driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/span/a")).click();
		//Assert.assertTrue(title.contains("Uniqreate"));
		test.log(LogStatus.PASS, "UQ Signout verified");
		
		

	}
	
	
	
	
	

}
