package screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UQScreenShot {
	@Test
	public void SaveScreenShot() throws IOException{

	// Open Firefox

	WebDriver driver=new FirefoxDriver();
	
	String screenshot_path = "\\home\\muthu\\work\\Selenium\\SeleniumUQ\\ScreenShot\\"+System.currentTimeMillis()+".png";

	 // call method
		
	// UQScreenShot.captureScreenShot(driver,screenshot_path);

	// Maximize the window
	driver.manage().window().maximize();
	
	UQScreenShot.captureScreenShot(driver, screenshot_path);

	// Pass the url
	  driver.get("http://deck.uniqreate.qa/");
      UQScreenShot.captureScreenShot(driver,screenshot_path);
      
  	// Close the URL
      driver.quit();


	}

	public static String captureScreenShot(WebDriver driver, String screenshot_path) throws IOException{
	// Take screenshot and store as a file format   
		
		 //Convert web driver object to TakeScreenshot
		 
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        
        File src=scrShot.getScreenshotAs(OutputType.FILE);

		// File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		 //Move image file to new destination
		 
             
		File DestFile=new File(screenshot_path);

        //Copy file at destination
        
		FileUtils.copyFile(src, DestFile);
	    
		return screenshot_path;
        
	 
	    // now copy the  screenshot to desired location using copyFile method
	
        // FileUtils.copyFile(src, new File("\\home\\muthu\\software\\Selenium\\Screenshot"+System.currentTimeMillis()+".png"));
	    // String screenshotBase64 = ((TakesScreenshot)ldriver).getScreenshotAs(src);


	}
}
