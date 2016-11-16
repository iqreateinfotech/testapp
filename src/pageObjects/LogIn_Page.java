package pageObjects;
        import org.openqa.selenium.*;


import utility.Log;
    public class LogIn_Page extends BaseClass {
           private static WebElement element = null;
        
        public LogIn_Page(WebDriver driver){
            	super(driver);
        }  
        
               
        public static WebElement txtbx_UserName() throws Exception{
        	try{
	            element = driver.findElement(By.id("email"));
	            Log.info("Username text box is found on the Login Page");
        	}catch (Exception e){
           		Log.error("UserName text box is not found on the Login Page");
           		throw(e);
           		}
           	return element;
            }
        
        public static WebElement txtbx_Password() throws Exception{
        	try{
	        	element = driver.findElement(By.id("password"));
	            Log.info("Password text box is found on the Login page");
        	}catch (Exception e){
        		Log.error("Password text box is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement btn_LogIn() throws Exception{
        	try{
	        	element = driver.findElement(By.cssSelector("#login-box .login_button"));
	    		//element = (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login .check-icon[title='Login']")));		
	        	        	
	            Log.info("Submit button is found on the Login page");
        	}catch (Exception e){
        		Log.error("Submit button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        }
       //xpath 
        public static WebElement lnk_ForgotPassword() throws Exception{
        	try{
	        	element = driver.findElement(By.cssSelector("#login-box .sign-in .forgot-password"));
	        	
	            Log.info("Forgot Password link is found on the Login page");
        	}catch (Exception e){
        		Log.error("Forgot Password link  is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        }
           
        
        public static WebElement close_LogInModal() throws Exception{
        	try{
	        	element = driver.findElement(By.cssSelector("#forgot-password-box .sign-in .show-login"));
	            Log.info("close button is found on the Login page");
        	}catch (Exception e){
        		Log.error("close button is not found on the Login Page");
           		throw(e);
           		}
           	return element;
        }
    	
    	public static WebElement Login(String strUserName, String strPassword) throws Exception{
    	
    	    Log.info("Click action is perfromed on Sign In link" );
    	    LogIn_Page.txtbx_UserName().clear();
    	    LogIn_Page.txtbx_UserName().sendKeys(strUserName);
    	    LogIn_Page.txtbx_Password().clear();
    	    LogIn_Page.txtbx_Password().sendKeys(strPassword);
    	    LogIn_Page.btn_LogIn().click();
    		Log.info("Click action is performed on Submit button");
    		  
    		return element;
    	}
        
    }
