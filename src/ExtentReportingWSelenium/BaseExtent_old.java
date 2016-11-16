package ExtentReportingWSelenium;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class BaseExtent_old
{
	
	
	    protected static ExtentReports extent;
	    protected static ExtentTest test;
		protected static WebDriver driver;
		

	    @AfterMethod
	    protected void afterEachTest(ITestResult result) {
	        if (!result.isSuccess()) {
	            test.log(LogStatus.FAIL, result.getThrowable().getMessage());
	           // extent.log(LogStatus.INFO, "HTML", "Usage: <span style='font-weight:bold;'>BOLD TEXT</span>");
	            
	     
	        }
	        
	        extent.endTest(test);        
	        extent.flush();
	        
	        
	    }
	    
	    @AfterSuite
	    protected void afterSuite() {
	    	//extent.log(LogStatus.INFO, "html", "Usage:<span style='font-weight:bold;'>BOLD TEXT</span>");
	        extent.close();
	    }
	
	    
}
