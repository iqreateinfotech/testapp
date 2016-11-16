package pageObjects;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

//import utility.Constant;
import utility.Log;
import utility.UQUploadFileUtilRobot;

public class CreateDeck_Modal extends BaseClass{
	
	
    private static WebElement element = null;
    
    public CreateDeck_Modal(WebDriver driver){
        	super(driver);
        	
    } 
    
    

    
    public static WebElement txtbx_DeckName() throws Exception{
    	try{
            element = driver.findElement(By.id("title"));
            Log.info("DeckName text box is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("DeckName text box is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
   
    
    public static WebElement drpbx_IdeaDeskTypeSelect() throws Exception{
    	try{
    
    		
    	 element=driver.findElement(By.cssSelector(".content-popup .deck-manage .field-group select.form-control"));
    	// Select se=new Select(element);
    //	 Thread.sleep(1000);
	 //    se.selectByIndex(3); 
           // element = driver.findElement(By.xpath(".//*[@id='create-project']/div/div/div[2]/div[2]/div/select"));
            //  Select se=new Select(element);
            // se.selectByValue("i_4055e9bc-5ed0-4468-b23c-7193ec49f804");
             
            Log.info("Ideadesk type dropdown box is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Ideadesk type dropdown box is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
    
    public static WebElement txtbx_People() throws Exception{
    	try{
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .field-group input.form-control[type='description']"));
            Log.info("People text box is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("People text box is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
   
    
  
    public static WebElement picdeck_PhotoUpload() throws Exception{
    	try{
            element = driver.findElement(By.xpath(".//*[@id='image-browse-button']/span"));
            Log.info("Pic Upload brose is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Pic Upload brose is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
//color selection    
    public static WebElement ch_Color_Purple() throws Exception{
    	try{
    		
    		
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .colorpallates .colorpallate[colorcode='#384772']"));
            Log.info("Blue Color is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Blue Color  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement ch_Color_Lightblue() throws Exception{
    	try{
    		
    		
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .colorpallates .colorpallate[colorcode='#79D0DA']"));
            Log.info("Blue Color is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Blue Color  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement ch_Color_Blue() throws Exception{
    	try{
    		
    	 
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .colorpallates .colorpallate[colorcode='#00CCFF']"));
            Log.info("Blue Color is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Blue Color  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement ch_Color_Green() throws Exception{
    	try{
    		
    	 
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .colorpallates .colorpallate[colorcode='#CCCC00']"));
            Log.info("Blue Color is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Blue Color  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement ch_Color_Orange() throws Exception{
    	try{
    		
    	 
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .colorpallates .colorpallate[colorcode='#FF9933']"));
            Log.info("Blue Color is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Blue Color  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
   
    public static WebElement ch_Color_Pink() throws Exception{
    	try{
    		
    	 
            element = driver.findElement(By.cssSelector(".deck-manage .dialog-details .colorpallates .colorpallate[colorcode='#993366']"));
            Log.info("Blue Color is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Blue Color  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }
    
    public static WebElement ch_excel_DiffColor() throws Exception{
    	try{
    		
    
    	
    		 Actions actions = new Actions(driver);
    		// WebElement menuElement = driver.findElement(By.tagName("colorcode"));
    		 WebElement menuElement = driver.findElement(By.className("row"));
    		 actions.moveToElement(menuElement).moveToElement(driver.findElement(By.xpath(".//*[@id='create-project']/div/div/div[3]/div[4]/div/div[1]")));
    		 System.out.println(menuElement); 
    		 Select se = new Select(menuElement);
    		 System.out.println(se); 
    		 se.selectByIndex(3); 
    	
            Log.info("Color palleate is found on the create deck modal");
    	}catch (Exception e){
       		Log.error("Color palleate is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
        }

    
  //Deck Creation button icon uq-icon-ok
    public static WebElement btn_CreateDeck() throws Exception{
        try{
	        	element = driver.findElement(By.cssSelector(".deck-manage .check-icon .uq-icon-ok"));
	        
	            Log.info("Create Deck Submit button is found on the create deck modal");
        }catch (Exception e){
        	Log.error("Create Deck Submit button  is not found on the create deck modal");
       		throw(e);
       		}
       	return element;
    }
    
   // Click on existing deck
    public static WebElement view_ExistedDeck() throws Exception{
        try{
	        	element = driver.findElement(By.xpath(".//*[@id='idea_desk_list']/div[1]/div[1]/div/div/div/div[1]/a/span"));
	        
	            Log.info("Created deck is found on the deck view page");
        }catch (Exception e){
        	Log.error("Created deck  is not found on the deck view page");
       		throw(e);
       		}
       	return element;
    }
    

    
    
    //close the deck
    
    public static WebElement close_CreateDeckModal() throws Exception{
        try{
	        	element = driver.findElement(By.cssSelector(".deck-manage .close"));
	        
	            Log.info("Close icon found on the create deck modal");
        }catch (Exception e){
        	Log.error("Close icon not found on the create deck modal");
       		throw(e);
       		}
       	return element;
    }
    
    public static WebElement val_OutSideDeckModal() throws Exception{
        try{
	        	element = driver.findElement(By.xpath(" .//*[@id='create-project']"));
	        
	            Log.info("Click outside deck modal is found on the create deck modal");
        }catch (Exception e){
        	Log.error("Click outside deck modal obj is found on the create deck modal");
       		throw(e);
       		}
       	return element;
    }
   
    
    //delete deck option
    
    public static WebElement deckoptiondot_InvokeContextMenu() throws Exception{
        try{
	        	element = driver.findElement(By.xpath(".//*[@id='idea_desk_list']/div[1]/div[3]/div/div/div/div[4]/div[2]/div/span"));
	        
	            Log.info("Deck option (dots) is found on the deck");
        }catch (Exception e){
        	Log.error("Deck option (dots) is not found on the deck");
       		throw(e);
       		}
       	return element;
    }
    
    //delete deck context menu 
    
    //verification -- after delete deck --"Deck has been removed"
    public static WebElement contextmenuitems_DeleteDeck() throws Exception{
        try{
	        	element = driver.findElement(By.xpath(".//*[@id='idea_desk_list']/div[1]/div[3]/div/div/div/div[4]/div[2]/ul/li/a"));
	        
	            Log.info("Deck context menu items is found on the deck");
        }catch (Exception e){
        	Log.error("Deck context menu items  is not found on the deck");
       		throw(e);
       		}
       	return element;
    }
    
    
    //created deck last update  .//*[@id='idea_desk_list']/div[1]/div[2]/div/div/div/div[2]/i
    
    public static WebElement lastupdateDate_Deck() throws Exception{
        try{
	        	element = driver.findElement(By.xpath(".//*[@id='idea_desk_list']/div[1]/div[1]/div/div/div/div[2]/i"));
	        
	            Log.info("Deck context menu items is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Deck context menu items  is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
    
    public static WebElement icon_DeckCloseButton() throws Exception{
        try{
	        	element = driver.findElement(By.xpath(".//*[@id='create-project']/div/div/div[1]/span"));
	        
	            Log.info("Deck context menu items is found on the UQ Page");
        }catch (Exception e){
        	Log.error("Deck context menu items  is not found on the UQ Page");
       		throw(e);
       		}
       	return element;
    }
    
   
    
    
    
    
        
    public static WebElement DeckCreation(String strDeckName,
			String strDeckType, String strPeople, String strColorcode,
			String strFilename) throws Exception {

		Log.info("Click action is perfromed on deck creation link");
		// CreateDeck_Modal.txtbx_DeckName().clear();
		CreateDeck_Modal.txtbx_DeckName().sendKeys(strDeckName);
	
		CreateDeck_Modal.drpbx_IdeaDeskTypeSelect().sendKeys(strDeckType);
		// CreateDeck_Modal.txtbx_People().clear();
		CreateDeck_Modal.txtbx_People().sendKeys(strPeople);
		
        //choose the color else deafult will be Orange
		if (strColorcode.equals("Pink")) {
			CreateDeck_Modal.ch_Color_Pink().click();
		}

		else if (strColorcode.equals("Green"))

		{
			CreateDeck_Modal.ch_Color_Green().click();
		}

		else if (strColorcode.equals("Blue"))

		{
			CreateDeck_Modal.ch_Color_Blue().click();
		}

		else if (strColorcode.equals("LightBlue"))

		{
			CreateDeck_Modal.ch_Color_Lightblue().click();
		} else if (strColorcode.equals("Orange"))

		{
			CreateDeck_Modal.ch_Color_Orange().click();
		} else if (strColorcode.equals("Purple"))

		{
			CreateDeck_Modal.ch_Color_Purple().click();
		} else
			//default color
          System.out.println("System default color is choosen");
		
		if(!strFilename.isEmpty())
		{ //Image selection
		CreateDeck_Modal.picdeck_PhotoUpload().click();
		Thread.sleep(1000);
		// deck creation image Upload file
		UQUploadFileUtilRobot.uploadFile(strFilename);
		}  
		
		Thread.sleep(10000);
		// file upload
		// JavascriptExecutor jsx = (JavascriptExecutor) element;
		// jsx.executeScript("document.getElementById('Bike.gif').value='" +
		// filePath + "';");
		System.out.println(strFilename +"Image is choosen/uploaded");
		CreateDeck_Modal.btn_CreateDeck().click();
		Log.info("Click action is performed on create deck submit button");
		
	    Thread.sleep(100);
	    System.out.println("New Deck is created");
	    
		return element;
	}

    
}
