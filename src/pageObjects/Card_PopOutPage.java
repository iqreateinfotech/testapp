package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class Card_PopOutPage extends BaseClass {

        public static WebElement element = null;
       
    public Card_PopOutPage(WebDriver driver){
        	super(driver);
    }
    
    public static WebElement icon_AddNewCard() throws Exception{
        try{ 
        	 element = driver.findElement(By.cssSelector(".content .cards-container .add-card-caption"));
             Log.info("Create Card is found on the card Page");
        }catch (Exception e){
       		Log.error("Create Card is not found on the card Page");
       		throw(e);
       		}
       	return element;
    }
    
	// existing card By.xpath(".//*[@id='cards-container']/div[3]/div[2]/div/div[2]/div[1]"))
  
  
    public static WebElement view_ExistedCard() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath("html/body/div/div[2]/div[5]/div[3]/div[3]/div[1]"));
             Log.info("Card is found on the card view");
        }catch (Exception e){
       		Log.error("Card is not found on the card view");
       		throw(e);
       		}
       	return element;
    }
    
    public static WebElement txtbox_CardContent() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath(" .//*[@id='default_canvas']"));
             Log.info("Card is found on the card view");
        }catch (Exception e){
       		Log.error("Card is not found on the card view");
       		throw(e);
       		}
       	return element;
    }
    
    public static WebElement icon_DownloadFileLink() throws Exception{
        try{ 
        	 element = driver.findElement(By.xpath(".//*[@id='cardFileDropZone']/div[2]/div/div[2]/div[3]/div[3]/div[2]/table/tbody/tr[1]/td[4]/a/span"));
             Log.info("Card is found on the card view");
        }catch (Exception e){
       		Log.error("Card is not found on the card view");
       		throw(e);
       		}
       	return element;
    }
    
    
    public static WebElement icon_AddtoAnalysis() throws Exception{
        try{ 
        	 element = driver.findElement(By.cssSelector("#cardpopout-container .card-header-bottom-action .uq-icon-research-add"));
             Log.info("Add to anlaysis icon found on the card pop-out");
        }catch (Exception e){
       		Log.error("Add to anlaysis icon not found on the card pop-out");
       		throw(e);
       		}
       	return element;
    }
    
    
   
}
