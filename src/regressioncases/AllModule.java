package regressioncases;

import java.io.File;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import uqmoduletestcases.DeckDeleteCases;
import uqmoduletestcases.MultipleFileUploadCases;
import uqmoduletestcases.UQCreateDeckCases;
import uqmoduletestcases.UQDeckShareCases;
import uqmoduletestcases.UQForgotPasswordCases;
import uqmoduletestcases.UQLoginCases;
//import uqmoduletestcases.UQRegistrationCases;
//import utility.AfterTest;
import utility.BaseExtent;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ReporterType;

public class AllModule extends BaseExtent {

	// static final ExtentReports extent = ExtentReports.get(AllModule.class);
	// private ExtentReports extent =
	// ExtentReports.this.toString().getClass(AllModule.class);

	private final String reportPath = Constant.Path_ExtentReport
			+ AllModule.class.getSimpleName() + ".html";

	private String sTestCaseName;

	private static int iTestCaseRow;

	// private final String reportPath = Constant.Path_AllmoduleExtentReport;

	@BeforeClass
	public void beforeClass() {

		extent = new ExtentReports(reportPath, true);
		extent.startReporter(ReporterType.DB,
				(new File(reportPath)).getParent() + File.separator
						+ "extent.db");
		extent.config().documentTitle("IQreateInfotechReports_UQAutomotion");
		// optional - to store all results in a database
		// extent.startReporter(ReporterType.DB, "extent.db");

		extent.addSystemInfo("MuthuComputer", "Muthu");

	}

	@BeforeMethod
	public void beforeMethod() throws Exception {
		// Configuring Log4j logs, please see the following posts to learn about
		// Log4j Logging
		// http://www.deck.uniqreate.qa/log4j-logging/
		DOMConfigurator.configure("log4j.xml");

		sTestCaseName = this.toString();
		// From above method we get long test case name including package and
		// class name etc.
		// The below method will refine your test case name, exactly the name
		// use have used
		sTestCaseName = Utils.getTestCaseName(this.toString());

		Log.startTestCase(sTestCaseName);

		ExcelUtils.setExcelFile(Constant.Path_AllmoduleTestData
				+ Constant.File_AllmoduleTestData, "Sheet1");
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,
				Constant.Col_TestCaseName);

		driver = Utils.OpenBrowser(iTestCaseRow);
		new BaseClass(driver);

	}

	@Test(priority = 1, alwaysRun = true)
	public static void main() throws  Throwable ,Exception {

		try {

		/*	test.log(
					LogStatus.INFO,
					"----------------*** UQRegistrationCases verification started***----------------");
			UQRegistrationCases.verifyAllRegistrationCases();
			test.log(
					LogStatus.INFO,
					"----------------*** UQRegistrationCases verification completed***----------------"); 

			test.log(LogStatus.INFO,
					"----------------*** UQLoginCases verification started ***----------------");
			UQLoginCases.verifyAllLoginCases();
			Thread.sleep(1000);
			test.log(LogStatus.INFO,
					"----------------*** UQLoginCases verification completed***----------------");

			test.log(
					LogStatus.INFO,
					"----------------*** UQForgotPasswordCases verification started ***----------------");
			UQForgotPasswordCases.verifyAllForgotPasswordCases();
			Thread.sleep(1000);
			test.log(
					LogStatus.INFO,
					"----------------*** UQForgotPasswordCases verification completed***----------------");

			test.log(
					LogStatus.INFO,
					"----------------*** UQCreateDeckCases verification started ***----------------");
			UQCreateDeckCases.verifyAllDeckCreationCases();
			Thread.sleep(1000);
			test.log(
					LogStatus.INFO,
					"----------------*** UQCreateDeckCases verification completed***----------------");*/

			test.log(LogStatus.INFO,
					"----------------*** UQDeckShareCases verification started ***----------------");
			UQDeckShareCases.verifyAllDeckShareCases();
			Thread.sleep(1000);
			test.log(
					LogStatus.INFO,
					"----------------*** UQDeckShareCases verification completed***----------------");

			test.log(LogStatus.INFO,
					"----------------*** DeckDeleteCases verification started ***----------------");
			DeckDeleteCases.VerifyDeckCreationDeletion_Database();
			Thread.sleep(1000);
			test.log(LogStatus.INFO,
					"----------------*** DeckDeleteCases verification completed***----------------");

			test.log(
					LogStatus.INFO,
					"----------------*** MultipleFileUploadCases verification started ***----------------");
			MultipleFileUploadCases.verifyMultiFileUpload();
			test.log(
					LogStatus.INFO,
					"----------------*** MultipleFileUploadCases verification completed***----------------");

		
			if (BaseClass.bResult == true) {
				// If the value of boolean variable is True, then your test is
				// complete pass and do this
				ExcelUtils.setCellData("Pass", iTestCaseRow,
						Constant.Col_AllResult);
			} else {
				// If the value of boolean variable is False, then your test is
				// fail, and you like to report it accordingly
				// This is to throw exception in case of fail test, this
				// exception will be caught by catch block below
				throw new Exception("Test Case Failed because of Verification");
			}

			// extent.endTest(AllModule);
			// ExcelUtils.setCellData("Pass", iTestCaseRow,
			// Constant.Col_Result);

		} catch (Exception e) {
			// ExcelUtils.setCellData("Fail", iTestCaseRow,
			// Constant.Col_Result);
			// utility.CaptureScreenShotUtil.captureScreenShot(driver,
			// sTestCaseName);
		
			Log.error(e.getMessage());
			 System.out.println("Exception thrown  :" + e);
		}
		
		finally{
	    	System.out.println("Inside finally. Please take appropriate action");
	    }
		System.out.println("Code after try catch block");
	

	}

	@AfterMethod
	public void afterMethod() {
		Log.endTestCase(sTestCaseName);
		// driver.close();
	}

}
