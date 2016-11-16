package reusablecases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class ResubaleUQCases {
	WebDriver driver;
	// Login
	public void verifyUQLogin() throws Exception {
		
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://deck.uniqreate.qa/");
			driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[2]/span/a")).click();
			Thread.sleep(1000); 
			driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("muthu@iqreateinfotech.com");
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
			driver.findElement(By.xpath(" .//*[@id='login']/div[4]/button")).click();

	}
	
	
	public void verifyUQLogout() throws Exception {
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("muthu@iqreateinfotech.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath(" .//*[@id='login']/div[4]/button")).click();

}
}
