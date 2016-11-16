package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;

public class CreateDeck_Modal_Validation extends BaseClass {

	private static WebElement element = null;

	public CreateDeck_Modal_Validation(WebDriver driver) {
		super(driver);
	}

	public static WebElement label_DeckName() throws Exception {
		try {
			//element = driver.findElement((By) By.name("title").findElement((SearchContext) By.tagName("label")));
			
			
			element = driver.findElement(By.cssSelector(".deck-manage .field-group label[for='title']"));
			Log.info("DeckNamelabel is found on the Create Deck Page");
		} catch (Exception e) {
			Log.error("DeckName label is not found on the Create Deck Page");
			throw (e);
		}
		return element;

	}

	public static WebElement label_IdeaDeskTypeSelect() throws Exception {
		try {
			
			element = driver.findElement(By.cssSelector(".deck-manage .field-group label[for='ideadesk_guid']"));
			Log.info("IdeaDeskTypeSelect label is found on the Create Deck Page");
		} catch (Exception e) {
			Log.error("IdeaDeskTypeSelect label is not found on the Create Deck Page");
			throw (e);
		}
		return element;

	}
	
	
	
	
}
