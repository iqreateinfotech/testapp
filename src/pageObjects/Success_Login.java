package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Success_Login extends BaseClass {

          private static WebElement element = null;
         
      public Success_Login(WebDriver driver){
          	super(driver);
      } 
    
	  public static WebElement btn_SignOut() throws Exception{
          try{
	        	element = driver.findElement(By.linkText("SIGN OUT"));
	        
	            Log.info("Sign out link is found on the UQ Page");
          }catch (Exception e){
          	Log.error("Sign out link is not found on the UQ Page");
         		//throw(e);
         		}
         	return element;
      }
	  
	  public static WebElement icon_CreateDeck() throws Exception{ 
          try{
	        	element = driver.findElement(By.cssSelector(".new-deck .uq-icon-plus.icon"));
	        
	            Log.info("Create Deck icon found on the dashboard page");
          }catch (Exception e){
          	Log.error("Create Deck icon is not found on the dashboard Page");
         		//throw(e);
         		}
         	return element;
      }
	
}
