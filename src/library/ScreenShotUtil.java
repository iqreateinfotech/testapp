package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import utility.Constant;

public class ScreenShotUtil {

	public static String captureScreenShot(WebDriver driver,
			String screenshot_name)

	{

		try {
			// Take screenshot and store as a file format  

			// Convert web driver object to TakeScreenshot

			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			File src = scrShot.getScreenshotAs(OutputType.FILE);

			String dest = Constant.Path_ScreenShot + screenshot_name + ".png";
			// src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			// Move image file to new destination

			File destination = new File(dest);

			// Copy file at destination

			FileUtils.copyFile(src, destination);

			System.out.println("Screen shot is taken");

			return dest;
		}

		catch (Exception e) {
			System.out.println("Exception while taking screen shot "
					+ e.getMessage());

			return e.getMessage();
		}

	}
}
