package utility;

import java.io.File;
//import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class CaptureScreenShotUtil {
	
	public static String captureScreenShot(WebDriver driver,
			String screenshot_name)

	{   
	 
	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			
		 	String dest = Constant.Path_AllmoduleScreenShot + screenshot_name + ".png";


			// Move image file to new destination
	    	File destination = new File(dest);
			 // copy file object to designated location
	        FileUtils.copyFile(scrFile, destination);
			// Copy file at destination

		//   FileUtils.copyFile(srcFile, destination);

			System.out.println(screenshot_name + ".png" + ": screen shot is taken");
			
			return dest;
			
		}

		catch (Exception e) {
			System.out.println("Exception while taking screen shot "
					+ e.getMessage());
			
			return e.getMessage();
		}
			
	}
	
}

