package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class DeckShare_Popout extends BaseClass{
private static WebElement element = null;
    
    public DeckShare_Popout(WebDriver driver){
        	super(driver);
        	
    } 
	
  //  WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.id("someid")));
	 
    //share deck objects
    public static WebElement dots_ShareDeckPeople() throws Exception{
        try{
   	//element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".page-content .ideadesk .decks-container .deck.show-options-layer .deck-option-list .deck-option-item.invite-deck")));
        	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".page-container .ideadesk .deck .deck-actions.dax-icon-options[title='Tools']"))); 			
        	       
	            Log.info("Share deck icon is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Share deck icon is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
    
    public static WebElement lnk_inviteToDeck() throws Exception{
        try{
   	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".page-content .ideadesk .decks-container .deck.show-options-layer .deck-option-list .deck-option-item.invite-deck")));
        	        
	            Log.info("Invite to deck option is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Invite to deck option is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
    public static WebElement txtbox_PeopleEmail() throws Exception{
        try{
	        	element = driver.findElement(By.id("people"));
	        
	            Log.info("Email textbox is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Email textbox is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
    public static WebElement txtbox_ShareMessage() throws Exception{
        try{
	        	element = driver.findElement(By.id("message"));
	        
	            Log.info("Share Message textbox is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Share Message  is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    

    public static WebElement btn_ShareDeckButton() throws Exception{
        try{
	        //	element = driver.findElement(By.cssSelector("#share-deck .check-icon .uq-icon-share-alt"));
	        	
	        	element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".content .deck-share .dialog-details #share-deck .deck-invite[title='Invite']")));
	        
	            Log.info("Share Message textbox is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Share Message  is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
   
    
    public static WebElement cross_ShareDeckCloseButton() throws Exception{
        try{
	        	element = driver.findElement(By.cssSelector(".content .deck-share .close"));
	        
	            Log.info("Share deck close button is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Share deck close button is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
    

    
    public static WebElement title_ShareDeckModal() throws Exception{
        try{
	        	element = driver.findElement(By.cssSelector(".content .deck-share .dialog-title .deck-title"));
	        
	            Log.info("Share deck title is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Share deck title is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
}
