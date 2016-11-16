package uqmoduletestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import pageObjects.BaseClass;
import utility.Constant;


public class setup extends BaseClass {
	public static WebElement element;
	public setup(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public static WebElement testSetup()
	 
	{
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Log.info("Implicit wait applied on the driver for 10 seconds");
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	
	
	driver.get(Constant.URL);
	return element;

	}

	
}
