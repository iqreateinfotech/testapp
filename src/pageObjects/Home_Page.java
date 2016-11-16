package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import utility.Log;

    public class Home_Page extends BaseClass{
            public static WebElement element = null;
           
        public Home_Page(WebDriver driver){
            	super(driver);
        }    
        
        public static WebElement lnk_AboutUs() throws Exception{
            try{ 
	        	 element = driver.findElement(By.linkText("ABOUT US"));
	             Log.info("ABOUT US link is found on the Home Page");
            }catch (Exception e){
           		Log.error("ABOUT US link is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_Learn() throws Exception{
            try{ 
	        	 element = driver.findElement(By.linkText("LEARN"));
	             Log.info("LEARN link is found on the Home Page");
            }catch (Exception e){
           		Log.error("LEARN link is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
        
        public static WebElement lnk_Registration() throws Exception{
            try{ 
	        	 element = driver.findElement(By.linkText("REGISTRATION"));
	             Log.info("REGISTRATION link is found on the Home Page");
            }catch (Exception e){
           		Log.error("REGISTRATION link is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement lnk_JoinUS() throws Exception{
            try{ 
	        	 element = driver.findElement(By.linkText("JOIN US"));
	             Log.info("JOIN US link is found on the Home Page");
            }catch (Exception e){
           		Log.error("JOIN US link is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }

        public static WebElement lnk_SignIn() throws Exception{
            try{
	        	element = driver.findElement(By.cssSelector(".logo .uq-icon-logo"));
	        
	            Log.info("Sign In link is found on the Home Page");
            }catch (Exception e){
            	Log.error("Sign In link is not found on the Home Page");
           		throw(e);
           		}
           	return element;
        }
        
                      
    }
