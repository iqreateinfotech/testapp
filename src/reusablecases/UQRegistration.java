package reusablecases;

import org.openqa.selenium.WebElement;

import pageObjects.Home_Page;
import pageObjects.Registration_Page;
import utility.Log;

public class UQRegistration  {

	public static WebElement element;

	public static WebElement Registration(String strName, String strEmail,
			String strPassword, String strConfirmPassword) throws Exception {

		Log.info("Click action is perfromed on Registration link");

		Registration_Page.txtbx_Name().sendKeys(strName);
		Registration_Page.txtbx_Email().sendKeys(strEmail);
		Registration_Page.txtbx_Password().sendKeys(strPassword);
		Registration_Page.txtbx_ConfirmPassword().sendKeys(strConfirmPassword);
		Registration_Page.btn_NewRegistration().click();
		Log.info("Click action is performed on Registration Submit button");

		return element;

	}

	public static WebElement InvokeRegistrationModal() throws Exception {

		Home_Page.lnk_Registration().click();

		return element;

	}

}

/*
 * public static void verifyAllRegistrationCases () throws Exception {
 * 
 * try {
 * 
 * // Open the Excel file FileInputStream fis = new FileInputStream(
 * "/home/muthu/work/Selenium/SeleniumUQ/TestData/RegistrationData.xlsx");
 * 
 * // Access the required test data sheet
 * 
 * @SuppressWarnings("resource") XSSFWorkbook wb = new XSSFWorkbook(fis);
 * XSSFSheet sheet = wb.getSheet("Sheet1");
 * 
 * 
 * for(int count = 1;count<=sheet.getLastRowNum();count++){ XSSFRow row =
 * sheet.getRow(count); System.out.println("Running test case " +
 * row.getCell(0).toString());
 * 
 * String sTestCaseName = row.getCell(0).toString();
 * 
 * // Run the test for the current test data row
 * 
 * if(sTestCaseName.equals(new String("verifyNewRegistration"))) {
 * verifyNewRegistration(row.getCell(1).toString(),
 * row.getCell(2).toString(),row
 * .getCell(3).toString(),row.getCell(4).toString()); }
 * 
 * else if(sTestCaseName.equals(new String("verifyAlreadyUsedEmail"))) {
 * verifyAlreadyUsedEmail(row.getCell(1).toString(),
 * row.getCell(2).toString(),row
 * .getCell(3).toString(),row.getCell(4).toString()); }
 * 
 * else if(sTestCaseName.equals(new
 * String("verifyMismatchPassword_ConfirmPassword"))) {
 * verifyMismatchPassword_ConfirmPassword(row.getCell(1).toString(),
 * row.getCell(
 * 2).toString(),row.getCell(3).toString(),row.getCell(4).toString()); }
 * 
 * else if(sTestCaseName.equals(new String("emptyPassword"))) {
 * emptyPassword(row.getCell(1).toString(),
 * row.getCell(2).toString(),row.getCell
 * (3).toString(),row.getCell(4).toString()); }
 * 
 * else if(sTestCaseName.equals(new String("allFieldsEmpty"))) {
 * allFieldsEmpty(row.getCell(1).toString(),
 * row.getCell(2).toString(),row.getCell
 * (3).toString(),row.getCell(4).toString()); } else if(sTestCaseName.equals(new
 * String("verifyEmailFormat"))) { verifyEmailFormat(row.getCell(1).toString(),
 * row
 * .getCell(2).toString(),row.getCell(3).toString(),row.getCell(4).toString());
 * } /* else if(sTestCaseName.equals(new
 * String("verifyNewRegistrationByInvite"))) {
 * UQShareDeckThroughInvite.verifyNewRegistrationByInvite
 * (row.getCell(1).toString(),
 * row.getCell(2).toString(),row.getCell(3).toString(
 * ),row.getCell(4).toString()); } /* else if(sTestCaseName.equals(new
 * String("verifyAlreadyUsedInvitation"))) {
 * verifyAlreadyUsedInvitation(row.getCell(1).toString(),
 * row.getCell(2).toString
 * (),row.getCell(3).toString(),row.getCell(4).toString()); } else
 * if(sTestCaseName.equals(new String("verifyUQExistUser"))) {
 * verifyUQExistUser(row.getCell(1).toString(),
 * row.getCell(2).toString(),row.getCell
 * (3).toString(),row.getCell(4).toString()); }
 * 
 * else if(sTestCaseName.equals(new String("invitationNotSent"))) {
 * invitationNotSent(row.getCell(1).toString(),
 * row.getCell(2).toString(),row.getCell
 * (3).toString(),row.getCell(4).toString()); }
 * 
 * 
 * } fis.close(); } catch (IOException e) {
 * System.out.println("Test data file not found"); }
 * 
 * 
 * } }
 */