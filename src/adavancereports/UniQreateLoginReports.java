package adavancereports;

import java.util.concurrent.TimeUnit;

import library.ScreenShotUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class UniQreateLoginReports {

	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;


	@Test
	public void verifyUniQreateScreenshots() throws Exception {
        
		String Rpath = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQAutomationReport.html";
		// new instance
		ExtentReports report = new ExtentReports(Rpath, false);
		
			
	  //  report = new ExtentReports("/home/muthu/work/Selenium/SeleniumUQ/Reports/UQAutomationReport.html");

		logger = report.startTest("VerifyUQTestCasesWithScreenshots");
		
		logger.assignCategory("Regression");
		

		
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		logger.log(LogStatus.INFO, "Browser started ");

		driver.get("http://deck.uniqreate.qa/");

		logger.log(LogStatus.INFO, "UQ Application is up and running");

		String homepage = ScreenShotUtil.captureScreenShot(driver, "homepage");

		String image1 = logger.addScreenCapture(homepage);
		logger.log(LogStatus.PASS, "home page", image1);

		String title = driver.getTitle();

		Assert.assertTrue(title.contains("Uniqreate"));

		logger.log(LogStatus.PASS, "Title verified");

		driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[2]/span/a")).click();

		logger.log(LogStatus.INFO, "UQ Login modal is invoked");

		ScreenShotUtil.captureScreenShot(driver, "Loginmodal");
		String loginmodal = ScreenShotUtil.captureScreenShot(driver, "Loginmodal");
		String image2 = logger.addScreenCapture(loginmodal);
		logger.log(LogStatus.PASS, "login", image2);
		

		// Login

		logger.log(LogStatus.INFO, "Entering UQ Login Creadentials");

		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("muthu@iqreateinfotech.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath(" .//*[@id='login']/div[4]/button")).click();

		// Assert.assertTrue(title.contains("SIGN OUT"));
		WebElement chk1;
		chk1 = driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/a"));

		Assert.assertTrue(chk1.isDisplayed());

		// Assert.assertTrue(title.contains("Uniqreate IDEAS INTELLIGENCE INNOVATION"));
		logger.log(LogStatus.PASS, "Login verified");

		ScreenShotUtil.captureScreenShot(driver, "Loginsuccess");
		String Loginsuccess = ScreenShotUtil.captureScreenShot(driver, "Loginsuccess");
		String image3 = logger.addScreenCapture(Loginsuccess);
		logger.log(LogStatus.PASS, "login", image3);

		// driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
		// TestNGThread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		// SignOut

		logger.log(LogStatus.INFO, "UQ Signout button is clicked");
		driver.findElement(By.xpath(".//*[@id='navbarCollapse']/ul[2]/li[2]/a")).click();
		Assert.assertTrue(title.contains("Uniqreate"));
		logger.log(LogStatus.PASS, "UQ Signout verified");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			String scname = ScreenShotUtil.captureScreenShot(driver, result.getName());
			String image = logger.addScreenCapture(scname);
			logger.log(LogStatus.FAIL, "Title verification", image);

		}

		report.endTest(logger);
		report.flush();
		driver.get("/home/muthu/work/Selenium/SeleniumUQ/Reports/UQAutomationReport.html");
	}

}
