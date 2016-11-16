package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Login_Page_Validation extends BaseClass{

         private static WebElement element = null;
      
      public Login_Page_Validation(WebDriver driver){
          	super(driver);
      }   	
          	 public static WebElement label_UserName() throws Exception{
             	try{
     	            element = driver.findElement(By.id("email"));
     	            Log.info("Username label is found on the Login Page");
             	}catch (Exception e){
                		Log.error("UserName label is not found on the Login Page");
                		throw(e);
                		}
                	return element;
        
      } 
          	 
          	public static WebElement label_Password() throws Exception{
             	try{
     	            element = driver.findElement(By.id("password"));
     	            Log.info("Password  label is found on the Login Page");
             	}catch (Exception e){
                		Log.error("Password label is not found on the Login Page");
                		throw(e);
                		}
                	return element;
          	}
          	
          	public static WebElement general_LoginValidationMsg() throws Exception{ 
             	try{
     	            element = driver.findElement(By.cssSelector("#login-box .sign-in #login-error"));
     	            
     	            Log.info("Login page validation label is found on the Login Page");
             	}catch (Exception e){
                		Log.error("Login page validation  is not found on the Login Page");
                		throw(e);
                		}
                	return element;
          	}
          
}
