package utility;

//import java.io.File;
import java.util.concurrent.TimeUnit;



//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;



//import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public  class Utils extends BaseExtent  {


	// static ExtentReports extent = ExtentManager.getInstance();
	// ExtentTest test;
	
	
	//ExtentReports report = new ExtentManager
	
	@Test
	public void infoTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.INFO, "Info");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	}
	
	@Test
	public void passTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.PASS, "Pass");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
	}
	
	@Test
	public void failTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.FAIL, "Fail");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.FAIL);
	}
	
	@Test
	public void fatalTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.FATAL, "Fatal");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.FATAL);
	}
	
	@Test
	public void errorTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.ERROR, "Error");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.ERROR);
	}
	
	@Test
	public void warningTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.WARNING, "Warning");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.WARNING);
	}
	
	@Test
	public void skipTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		test.log(LogStatus.SKIP, "Skip");
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.SKIP);
	}
	
	@Test
	public void unknownTest() {
		test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Assert.assertEquals(test.getRunStatus(), LogStatus.UNKNOWN);
	}


	@Test (groups={"positive"})
	public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
		String sBrowserName;
		
		try
		{
			  test = extent.startTest("UQAutomation:RegressionTestSuite");	
			  
	   		//  test = extent.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			           
						
		sBrowserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
		if(sBrowserName.equals("Mozilla")){
			

			if(sBrowserName.equalsIgnoreCase("Chrome"))
				{
					System.out.println("Firefox will be used as a browser");
				     driver = new FirefoxDriver();
					
				}
			
			else
		
			System.setProperty("webdriver.chrome.driver", "/home/muthu/software/Selenium/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Chrome will be used as a browser");		
			
			
		  //test = extent.startTest("VerifyUQTestCasesWithScreenshot");
		//	test.assignCategory("Regression");
			
			// driver = new FirefoxDriver();
			Log.info("New driver instantiated");
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    Log.info("Implicit wait applied on the driver for 10 seconds");
	
		    driver.manage().deleteAllCookies();
		    driver.manage().window().maximize();
		   
		    driver.get(Constant.URL);
			
			
		  //  Log.info("Web application launched successfully");
		    
		    
		    test.log(LogStatus.INFO, "UQ Application is up and running");
            String uqhomepage = CaptureScreenShotUtil.captureScreenShot(driver, "uqhomepage");
			String homepageimg = test.addScreenCapture(uqhomepage);
			test.log(LogStatus.PASS, "home page", homepageimg); 
			
		/*	//verify the title of UQ home page
			String title = driver.getTitle();
			Assert.assertTrue(title.contains("Uniqreate"));
			test.log(LogStatus.PASS, "Title verified");  */
		    
			}
		}catch (Exception e){
			Log.error("Class Utils | Method OpenBrowser | Exception desc : "+e.getMessage());
		}
		return driver;
	}
	
	public static String getTestCaseName(String sTestCase)throws Exception{
		String value = sTestCase;
		try{
			int posi = value.indexOf("@");
			value = value.substring(0, posi);
			posi = value.lastIndexOf(".");	
			value = value.substring(posi + 1);
			return value;
				}catch (Exception e){
			Log.error("Class Utils | Method getTestCaseName | Exception desc : "+e.getMessage());
			throw (e);
					}
			}
	/*
	 public static void mouseHoverAction(WebElement mainElement, String subElement){
		
		 Actions action = new Actions(driver);
         action.moveToElement(mainElement).perform();
         if(subElement.equals("Accessories")){
        	 action.moveToElement(driver.findElement(By.linkText("Accessories")));
        	 Log.info("Accessories link is found under Product Category");
         }
         if(subElement.equals("iMacs")){
        	 action.moveToElement(driver.findElement(By.linkText("iMacs")));
        	 Log.info("iMacs link is found under Product Category");
         }
         if(subElement.equals("iPads")){
        	 action.moveToElement(driver.findElement(By.linkText("iPads")));
        	 Log.info("iPads link is found under Product Category");
         }
         if(subElement.equals("iPhones")){
        	 action.moveToElement(driver.findElement(By.linkText("iPhones")));
        	 Log.info("iPhones link is found under Product Category");
         }
         action.click();
         action.perform();
         Log.info("Click action is performed on the selected Product Type");
	 }*/
	
	
	 public static void waitForElement(WebElement element){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 	}
	 
	 
 public static void waitForFileUploadList(WebElement element, String data){
		 
		 WebDriverWait wait = new WebDriverWait(driver, 10);

	     wait.until(ExpectedConditions.textToBePresentInElementValue(element, data));
	 	}
	 
	 
	 @AfterMethod /* this annotation would run once test script execution would complete*/

		public void closeBrowser()
			{try{
				
				driver.wait(15000);
				}
			catch(Exception e){}
				driver.close();
				driver.quit();
			}
		
	/* public static void takeScreenshot(WebDriver driver, String sTestCaseName) throws Exception{
			try{
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				FileUtils.copyFile(scrFile, new File(Constant.Path_ScreenShot + sTestCaseName +".jpg"));
				
			} catch (Exception e){
				Log.error("Class Utils | Method takeScreenshot | Exception occured while capturing ScreenShot : "+e.getMessage());
				throw new Exception();
			}
		}*/
	 
	 
	}
