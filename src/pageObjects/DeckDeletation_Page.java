package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import uqmoduletestcases.DeckDeleteCases;
import utility.Log;

public abstract class DeckDeletation_Page extends BaseClass {

	private static WebElement element = null;

	public DeckDeletation_Page(WebDriver driver) {
		super(driver);

	}

	// delete deck objects
	public static WebElement options_DeckDeletation(String newdeckguid)
			throws Exception {
		try {

			String guid = DeckDeleteCases.newdeckguid;

			element = driver.findElement(By.cssSelector(".deck[guid=\""
					+ guid + "\"] .uq-icon-option-vertical"));

			Log.info("Deck option button is found on the UQ Page");
		} catch (Exception e) {
			Log.error("Deck option button is not found on the UQ Page");
			throw (e);
		}
		return element;
	}

	public static WebElement removebtn_DeckDeletation(String newdeckguid)
			throws Exception {
		try {

			String guid = DeckDeleteCases.newdeckguid;

			element = driver.findElement(By.cssSelector(".deck[guid=\""
					+ guid + "\"] .glyphicon-trash"));

			// element = (new WebDriverWait(driver,
			// 10)).until(ExpectedConditions.elementToBeClickable(By.className("dropdown-menu deck-context-menu-items"))).findElement(By.linkText("#"));

			Log.info("Deck delete button is found on the UQ Page");
		} catch (Exception e) {
			Log.error("Deck delete button is not found on the UQ Page");
			throw (e);
		}
		return element;
	}

}
