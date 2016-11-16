package reusablecases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BaseClass;

public class WebBrowser extends BaseClass{
	public static WebElement element;
	public WebBrowser(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public static WebElement closeBrowser() throws Exception{
	
	driver.quit();
	
	return element;
		
       
	
    }


public static WebElement refreshPage() throws Exception{ 
	
	driver.navigate().refresh();
	return element;
	
}



}
