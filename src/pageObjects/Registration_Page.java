package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Registration_Page extends BaseClass {
	public static WebElement element = null;
     
     public Registration_Page(WebDriver driver){
         	super(driver);
     }    
	
     public static WebElement txtbx_Name() throws Exception{
     	try{
     
	            element = driver.findElement(By.xpath(".//*[@id='register']/div[1]/div/input"));
	            Log.info("Name text box is found on the Registration Page");
     	}catch (Exception e){
        		Log.error("Name text box is not found on the Registration Page");
        		throw(e);
        		}
        	return element;
         }
     
     public static WebElement txtbx_Email() throws Exception{
      	try{
 	            element = driver.findElement(By.xpath(".//*[@id='register']/div[2]/div/input"));
 	            Log.info("Email text box is found on the Registration Page");
      	}catch (Exception e){
         		Log.error("Email text box is not found on the Registration Page");
         		throw(e);
         		}
         	return element;
          }
     
     
     public static WebElement txtbx_Password() throws Exception{
      	try{
 	            element = driver.findElement(By.xpath(".//*[@id='register']/div[3]/div/input"));
 	            Log.info("Password text box is found on the Registration Page");
      	}catch (Exception e){
         		Log.error("Password text box is not found on the Registration Page");
         		throw(e);
         		}
         	return element;
          }

     
     public static WebElement txtbx_ConfirmPassword() throws Exception{
       	try{
  	            element = driver.findElement(By.xpath(".//*[@id='register']/div[4]/div/input"));
  	            Log.info("ConfirmPassword text box is found on the Registration Page");
       	}catch (Exception e){
          		Log.error("ConfirmPassword text box is not found on the Registration Page");
          		throw(e);
          		}
          	return element;
           }
     
     public static WebElement btn_NewRegistration() throws Exception{
     	try{
	        	element = driver.findElement(By.xpath(".//*[@id='register']/div[5]/button"));
	            Log.info("Submit button is found on the Registration page");
     	}catch (Exception e){
     		Log.error("Submit button is not found on the Registration Page");
        		throw(e);
        		}
        	return element;
     }
     
     public static WebElement icon_CloseRegistrationModal() throws Exception{
      	try{
 	        	element = driver.findElement(By.xpath(".//*[@id='register-modal']/div/div/div[1]/div/button"));
 	            Log.info("Close button/icon is found on the Registration page");
      	}catch (Exception e){
      		Log.error("Close button/icon is not found on the Registration Page");
         		throw(e);
         		}
         	return element;
      }
}
