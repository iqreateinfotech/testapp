package appModules;


//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.WebElement;
import java.util.UUID;

import org.testng.Assert;
import org.testng.Reporter;

import pageObjects.CreateDeck_Modal;
import pageObjects.Success_Login;
import utility.BaseExtent;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

import com.relevantcodes.extentreports.LogStatus;

public  class CreateDeck_Action extends BaseExtent {

	public static String wexcelDeckName;
	//private static WebElement element = null;
	 public static void Execute(int iTestCaseRow) throws Exception{
		 
		 
			// Clicking on the Create Deck  on the UQ Page
		 Success_Login.icon_CreateDeck().click();
     	 Log.info("Click action is perfromed on Create deck" );
         Thread.sleep(1000);
     	   test.log(LogStatus.INFO, "UQ Create Deck modal is invoked");
    	   String uqcreatedeckmodal = utility.CaptureScreenShotUtil.captureScreenShot(driver,"uqcreatedeckmodal");
		   String uqcreatedeckimg = test.addScreenCapture(uqcreatedeckmodal);
		   test.log(LogStatus.PASS, "Dashboard", uqcreatedeckimg);
		   
		   
			String excelDeckName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_DeckName);
        	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
			String uuid = UUID.randomUUID().toString();
			wexcelDeckName =  excelDeckName + uuid; 
             CreateDeck_Modal.txtbx_DeckName().sendKeys(wexcelDeckName);
            // Printing the logs for what we have just performed
             Log.info(wexcelDeckName +" is entered in deckname text box" );
            
            // WebElement element=driver.findElement(By.name("Mobiles"));  .//*[@id='create-project']/div/div/div[2]/div[2]/div/select
          //   String sDeckType = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_DeckType);
             String sDeckType= ExcelUtils.getCellData(iTestCaseRow, Constant.Col_DeckType);
             
             CreateDeck_Modal.drpbx_IdeaDeskTypeSelect().sendKeys(sDeckType);
         	  
             Log.info(sDeckType +" is entered in deckname text box" );
             
             Thread.sleep(1000);
             
            // String sDeckType = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_DeckType);
           //      element = driver.findElement(By.xpath(".//*[@id='create-project']/div/div/div[2]/div[2]/div/select/option[2]"))
        
         //    element = driver.findElement(By.xpath(".//*[@id='create-project']/div/div/div[2]/div[2]/div/select/option[2]"));
           // .//*[@id='create-project']/div/div/div[2]/div[2]/div/select/option[2]
            // Select se=new Select(element);
             // se.selectByValue("i_4055e9bc-5ed0-4468-b23c-7193ec49f804");
          //  se.selectByIndex(0);
                                    
        //    Log.info(data +" is selected from decktype dropdown list" );
    		
    		String sPeopleEmail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_PeopleEmail);
        	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
        	
             CreateDeck_Modal.txtbx_People().sendKeys(sPeopleEmail);
            // Printing the logs for what we have just performed
             Log.info(sPeopleEmail +" is entered in people text box" );
             
             
             CreateDeck_Modal.ch_Color_Orange().click();
             Thread.sleep(1000);
             CreateDeck_Modal.btn_CreateDeck().click();
             Log.info("Click action is performed on Submit button");
             
             Thread.sleep(10000);
         	
     	    Assert.assertEquals("Deck has been saved successfully", "Deck has been saved successfully");
     	         	    		 
            Reporter.log("CreateDeck Action is successfully perfomred");
	 }

}
