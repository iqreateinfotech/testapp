package appModules;



import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.Success_Login;
import utility.BaseExtent;
import utility.Log;

import com.relevantcodes.extentreports.LogStatus;

public  class SignOut_Action extends BaseExtent{


	public static void Execute(int iTestCaseRow) throws Exception{
    	
	  Success_Login.btn_SignOut().click();
	  
      Log.info("Click action is performed on Sign Out button");
      
      Thread.sleep(10000);
      
  	   String title = driver.getTitle();
     // Utils.waitForElement(Home_Page.lnk_AboutUs());
        Assert.assertTrue(title.contains("Uniqreate"));
		test.log(LogStatus.PASS, "UQ Signout verified");
      
      Reporter.log("Signout Action is successfully perfomred");

   }
}
