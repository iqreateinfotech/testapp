package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uqmoduletestcases.DeckDeleteCases;
import utility.Log;
import appModules.CreateDeck_Action;
//import utility.Utils;
//import utility.BaseExtent;
//import org.testng.Assert;

public class Upload_Page extends BaseClass {
    private static WebElement element = null;
   
    
    public Upload_Page(WebDriver driver){
      	super(driver);
  } 

	
	public static WebElement view_ExcelDeck() throws Exception{
        try{
        	//int iTestCaseRow = 1;
 
        // String wexcelDeckName = ExcelUtils.getCellData(iTestCaseRow,Constant.Col_DeckName);
        	String sDeckName = CreateDeck_Action.wexcelDeckName;	
           System.out.println(sDeckName);
           
           element = driver.findElement(By.cssSelector(".deck-title[title=\""
					+ sDeckName + "\"]" ));
      
	            Log.info("Excel Deck is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Excel Deck is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
       	
	}
	
	
	public static WebElement view_DatabaseVerifyDeck() throws Exception{
        try{
           	
        	String strDeckName = DeckDeleteCases.strDeckName;
        	System.out.println(strDeckName);
        	element = driver.findElement(By.partialLinkText(strDeckName));
   	        
	            Log.info("Database Deck is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Database Deck is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
       	
	}
	
	 public static WebElement btn_NewCard() throws Exception{
         try{
	        	element = driver.findElement(By.cssSelector(".cards .new-card"));
	        
	            Log.info("Add new card link is found on the UQ Page");
         }catch (Exception e){
         	Log.error("Add new card link is not found on the UQ Page");
        		throw(e);
        		}
        	return element;
	 }
	 
	
	 
	 public static WebElement txtbx_CardTitle() throws Exception{
         try{
	        	element = driver.findElement(By.xpath(".//*[@id='title-editor']"));
	        
	            Log.info("Enter Card title is found on the UQ Page");
         }catch (Exception e){
         	Log.error("Enter Card title  is not found on the UQ Page");
        		throw(e);
        		}
        	return element;
	 }
	 
	 
	 public static WebElement btn_FileUploadZone() throws Exception{
         try{
	        	element = driver.findElement(By.id("files-upload-header"));
	        
	            Log.info("File Upload Zone  is found on the UQ Page");
         }catch (Exception e){
         	Log.error("File Upload Zone  is not found on the UQ Page");
        		throw(e);
        		}
        	return element;
	 }
	 
	//.//*[@id='cardFileDropZone']/div[1]/div[2]
	   
	 public static WebElement icon_CardPopOutClose() throws Exception{
         try{
	        
        	        	 
        	 element = driver.findElement(By.xpath(".//*[@id='cardFileDropZone']/div[1]/div[2]/span"));
	        
	            Log.info("CardPopOutClose icon  is found on the UQ Page");
         }catch (Exception e){
         	Log.error("CardPopOutClose icon is not found on the UQ Page");
        		throw(e);
        		}
        	return element;
	 }
	 
	 public static WebElement ck_ContentEditor() throws Exception{
         try{
	        	element = driver.findElement(By.xpath(".//*[@id='default_canvas']"));
	        
	            Log.info("Content-editor on card  popout  is found on the UQ Page");
         }catch (Exception e){
         	Log.error("Content-editor on card  popout is not found on the UQ Page");
        		throw(e);
        		}
        	return element;
	 }
	
	 public static WebElement table_FileUploadContent() throws Exception{
         try{
	
        	 element = driver.findElement(By.cssSelector(".card-details-content-container .file-content .table .filename"));
        	//String fname = MultipleFileUploadCases.strFilename;
        	// element = driver.findElement(By.cssSelector( ".card-details-content-container .file-content .table .filename[title= \"" + fname + "\"]"));
        	   
	            Log.info("Uploaded file content table is found on the UQ Page");
         }catch (Exception e){
         	Log.error("Uploaded file content table is not found on the UQ Page");
        		
        		}
        	return element;
	 }
	
}
