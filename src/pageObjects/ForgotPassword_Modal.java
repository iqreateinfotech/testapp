package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class ForgotPassword_Modal extends BaseClass {
	
	private static WebElement element = null;
    
    public ForgotPassword_Modal(WebDriver driver){
        	super(driver);
    }  
       
    
    public static WebElement modal_forgotPassword() throws Exception{
    	try{
    		
            element = driver.findElement(By.xpath(".//*[@id='forgot-password']/div[1]"));
            Log.info("Forgot pass modal found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Forgot pass modal is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement txtbx_forgotPassEmail() throws Exception{
    	try{
    		//element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.className("request-reset-pass"))).findElement(By.id("email"));	
          //  element = driver.findElement(By.className("request-reset-pass")).findElement(By.id("email"));
    		element = driver.findElement(By.cssSelector("#forgot-password-box .sign-in #user-email"));
            Log.info("Email text box is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Email text box is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement btn_forgotPassButton() throws Exception{
    	try{
    	//	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("send-reset-email")));	
           element = driver.findElement(By.cssSelector("#forgot-password-box .login_button .login_link"));
            Log.info("Email text box is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Email text box is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement btn_forgotPassCloseButton() throws Exception{
    	try{
    		
    	 //	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='forgot-password']/div[1]/div[1]/button")));
         element = driver.findElement(By.cssSelector("#forgot-password-box .sign-in .show-login"));
            Log.info("Forgot Password Button is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Forgot Password Button is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    //validation .//*[@id='reset-password']/div/div[1]/label
    
    public static WebElement label_forgotPassEmail() throws Exception{
    	try{
    	//	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='reset-password']/div/div[1]/label")));
       element = driver.findElement(By.cssSelector("#forgot-password-box .sign-in .login-error"));
            Log.info("User message(label) is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("User message(label) is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement refreshPage() throws Exception{ 
    	
    	driver.navigate().refresh();
		return element;
		
    }
  
    
    
    
    //change pass link
    
    
    public static WebElement txtbx_ChangePassEmail() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector("#form-reset-password .sign-in #email"));	
          //  element = driver.findElement(By.className("request-reset-pass")).findElement(By.id("email"));
            Log.info("Email text box is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Email text box is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement txtbx_Password() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector("#form-reset-password .sign-in #password"));	
          //  element = driver.findElement(By.className("request-reset-pass")).findElement(By.id("email"));
            Log.info("Email text box is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Email text box is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    
    public static WebElement txtbx_ConfirmPassword() throws Exception{
    	try{
    		element = driver.findElement(By.cssSelector("#form-reset-password .sign-in #password_confirmation"));	
          //  element = driver.findElement(By.className("request-reset-pass")).findElement(By.id("email"));
            Log.info("Email text box is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Email text box is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }
    
    
    public static WebElement btn_ResetPassword() throws Exception{
    	try{
    		
    		element = driver.findElement(By.cssSelector("#form-reset-password .sign-in .register_button"));
        //  element = driver.findElement(By.xpath(".//*[@id='forgot-password']/div[1]/div[1]/button"));
            Log.info("Forgot Password Button is found on the forgot password modal");
    	}catch (Exception e){
       		Log.error("Forgot Password Button is not found on the forgot password modal");
       		throw(e);
       		}
       	return element;
        }

}
