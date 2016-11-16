package reusablecases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import pageObjects.Success_Login;
import utility.Log;

public class UQAuthentication extends BaseClass {
	public UQAuthentication(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static WebElement element;

	
	public static WebElement Login(String strUserName, String strPassword)
			throws Exception {

		Log.info("Click action is perfromed on Sign In link");
	//	LogIn_Page.txtbx_UserName().clear();
		LogIn_Page.txtbx_UserName().sendKeys(strUserName);
	//	LogIn_Page.txtbx_Password().clear();
		LogIn_Page.txtbx_Password().sendKeys(strPassword);
		LogIn_Page.btn_LogIn().click();
		Log.info("Click action is performed on Sign In Submit button");

		return element;
	}

	public static WebElement successLogon() throws Exception {
		WebElement SuccessSignIn;
		SuccessSignIn = Success_Login.btn_SignOut();
		Assert.assertTrue(SuccessSignIn.isDisplayed());
		Log.info("User Success Login verified");
		return element;
	}
	
	public static WebElement InvokeSignInModal() throws Exception{
		
	    Home_Page.lnk_SignIn().click();
	    
		return element;
	   	
	    }
	
	public static WebElement uniqreateSignout() throws Exception{
    	
		  Success_Login.btn_SignOut().click();
		  Log.info("Click action is performed on Sign Out button");
	   
	      return element;

	   }
}

/*
 * public static void verifyAllLoginCases() throws Exception {
 * 
 * try {
 * 
 * // Open the Excel file FileInputStream fis = new
 * FileInputStream("/home/muthu/work/Selenium/SeleniumUQ/TestData/LoginData.xlsx"
 * );
 * 
 * // Access the required test data sheet
 * 
 * @SuppressWarnings("resource") XSSFWorkbook wb = new XSSFWorkbook(fis);
 * XSSFSheet sheet = wb.getSheet("Sheet1"); //define a test result data object
 * // Map<String, Object[]> testresultdata;
 * 
 * 
 * for(int count = 1;count<=sheet.getLastRowNum();count++){ XSSFRow row =
 * sheet.getRow(count); System.out.println("Running test case " +
 * row.getCell(0).toString());
 * 
 * // int sTestCaseName1 = row.getCell(0).getRowIndex(); String sTestCaseName =
 * row.getCell(0).toString();
 * 
 * 
 * // Run the test for the current test data row
 * 
 * if(sTestCaseName.equals(new String("validLogin"))) {
 * validLogin(row.getCell(1).toString(), row.getCell(2).toString());
 * 
 * 
 * 
 * } else if (sTestCaseName.equals(new String("incorrectPassword"))) {
 * incorrectPassword(row.getCell(1).toString(),row.getCell(2).toString()); }
 * 
 * else if (sTestCaseName.equals(new String("incorrectEmail"))) {
 * incorrectEmail(row.getCell(1).toString(),row.getCell(2).toString()); }
 * 
 * else if (sTestCaseName.equals(new String("emptyEmail"))) {
 * emptyEmail(row.getCell(1).toString(),row.getCell(2).toString()); }
 * 
 * else if (sTestCaseName.equals(new String("emptyPassword"))) {
 * emptyPassword(row.getCell(1).toString(),row.getCell(2).toString()); }
 * 
 * 
 * else if (sTestCaseName.equals(new String("emptyUserName_Password"))) {
 * emptyUserName_Password(row.getCell(1).toString(),row.getCell(2).toString());
 * }
 * 
 * 
 * else if (sTestCaseName.equals(new String("passwordLengthLessThanSixChar"))) {
 * passwordLengthLessThanSixChar
 * (row.getCell(1).toString(),row.getCell(2).toString()); }
 * 
 * else if (sTestCaseName.equals(new String("verifyInvalidemailFormat"))) {
 * verifyInvalidemailFormat
 * (row.getCell(1).toString(),row.getCell(2).toString()); }
 * 
 * 
 * 
 * } fis.close(); } catch (IOException e) {
 * System.out.println("Test data file not found"); } } }
 */
