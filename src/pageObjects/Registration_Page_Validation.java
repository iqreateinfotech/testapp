package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Registration_Page_Validation extends BaseClass {

	private static WebElement element = null;

	public Registration_Page_Validation(WebDriver driver) {
		super(driver);
	}

	public static WebElement label_strName() throws Exception {
		try {
			element = driver.findElement(By
					.xpath(".//*[@id='register']/div[1]/div/label"));
			Log.info("Name label is found on the Login Page");
		} catch (Exception e) {
			Log.error("Name label is not found on the Login Page");
			throw (e);
		}
		return element;
	}		
		public static WebElement label_strEmail() throws Exception {
			try {
				element = driver.findElement(By
						.xpath(".//*[@id='register']/div[2]/div/label"));
				Log.info("Email label is found on the Login Page");
			} catch (Exception e) {
				Log.error("Email label is not found on the Login Page");
				throw (e);
			}
			return element;

	}
	
		public static WebElement label_strPassword() throws Exception {
			try {
				element = driver.findElement(By
						.xpath(".//*[@id='register']/div[3]/div/label"));
				Log.info("Password label is found on the Login Page");
			} catch (Exception e) {
				Log.error("Password label is not found on the Login Page");
				throw (e);
			}
			return element;

	}
	
		public static WebElement label_strConfirmPassword() throws Exception {
			try {
				element = driver.findElement(By
						.xpath(".//*[@id='register']/div[4]/div/label"));
				Log.info("ConfirmPassword label is found on the Login Page");
			} catch (Exception e) {
				Log.error("ConfirmPassword label is not found on the Login Page");
				throw (e);
			}
			return element;

	}
	

}
