
package utility;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import org.testng.IInvokedMethodListener;
//import org.testng.ITestListener;

public abstract class BaseExtent   {
	
		protected static ExtentReports extent;
	    protected static ExtentTest test;
	    protected static WebDriver driver;
       
	 /*   @AfterMethod
	    protected void afterEachTest(ITestResult result) {*/
	    	
	    	protected String getStackTrace(Throwable t) {
	    		StringWriter sw = new StringWriter();
	    		PrintWriter pw = new PrintWriter(sw);
	    		t.printStackTrace(pw);
	    		return sw.toString();
	    	}
	    	
	    	
	    	@AfterMethod
	    	protected void afterEachTest(ITestResult result) {
	    			    		
	    		/*if (!result.isSuccess()) {
	    		  
	    	 	// test.log(LogStatus.FAIL, "<pre>" + getStackTrace(result.getThrowable()) + "</pre>");
	    		}*/
	    		
	    	 		
	    
	    		
	    		if (result.getStatus() == ITestResult.FAILURE) {
		    	    if (result.getThrowable() != null) {
		    	        test.log(LogStatus.FAIL, "<pre>" + result.getThrowable().getMessage() + "</pre>");
		    	    }
	    		}
	    		
	    		if (test != null) {
	    			extent.endTest(test);
	    		}
	    		
	    		extent.flush();
	    	}
	    	
	    	
	    	
	    
	    	
	    	
	    
	    	
	/*   /* 	  if (!result.isSuccess()) {
	          //    test.log(LogStatus.FAIL, result.getThrowable();
	       		  test.log(LogStatus.FAIL, result.getThrowable().getMessage());
	            // test.log(LogStatus.FAIL, result.getTestName());
	          }
	          
	          extent.endTest(test);        
	          extent.flush();
	    }*/
	 /*   	Reporter.log("TestName = " + result.getTestName(), true);
			Reporter.log("Test Method resides in: " + result.getTestClass().getName(), true);
			if (result.getParameters().length != 0) {
				String params = null;
				for (Object parameter : result.getParameters()) {
					params += parameter.toString() + ",";
				}
				Reporter.log("Test Method had the following parameters : " + params, true);
			} */

	  /*     int status = result.getStatus();
	        
	    //    if (!result.isSuccess()) {
	     //       test.log(LogStatus.FAIL, result.getThrowable().getMessage());
	           // extent.log(LogStatus.INFO, "HTML", "Usage: <span style='font-weight:bold;'>BOLD TEXT</span>");
	           
	        
		//	String status = null;   
	            switch (result.getStatus()) {
	                case ITestResult.SUCCESS:
	                	status = 1;
	        			break;
	                 
	                case ITestResult.FAILURE:
	                	 test.log(LogStatus.FAIL, result.getThrowable().getMessage());
	                	 status = 0;
	                    break;
	                case ITestResult.SKIP:
	                	status = -1;
	                    break;
	                default:
	                    throw new RuntimeException("Invalid status");
	           
	     
	        }
	        
	       
	        extent.endTest(test);        
	        extent.flush();
	        Reporter.log("Test Status: " + status, true);  
	    }
	 
	    
	    public void onTestSkipped(ITestResult arg0) {
	    	afterEachTest(arg0);
		}

		public void onTestStart(ITestResult arg0) {
		}

		public void onTestSuccess(ITestResult arg0) {
			afterEachTest(arg0);
		}

		public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
			String textMsg = "Completed executing " + returnMethodName(arg0.getTestMethod());
			Reporter.log(textMsg, true);

		}

		public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
			String textMsg = "About to begin executing " + returnMethodName(arg0.getTestMethod());
			Reporter.log(textMsg, true);
		}

		private String returnMethodName(ITestNGMethod method) {
			return method.getRealClass().getSimpleName() + "." + method.getMethodName();
		}   */

	 
	    @AfterSuite
	    protected void afterSuite() {
	    
	    	
	   // extent.log(LogStatus.INFO, "html", "Usage:<span style='font-weight:bold;'>BOLD TEXT</span>");
	        extent.close();
	    }
	
	    
}
