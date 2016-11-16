package utility;

import java.util.Map;

public class Constant {
    public static final String URL = "http://ui.uniqreate.qa/";
    public static final String URL11 = "http://demo.uniqreate.org/";
  //define a test result data object
    Map<String, Object[]> testresultdata;
    
    public static final String Username = "uqautomation@uniqreate.com";
    public static final String Password ="123456";
	public static final String Path_TestData = "/home/muthu/work/Selenium/SeleniumUQ/TestData/";
	public static final String File_TestData = "TestData.xlsx";
	public static final String PROP_PROJECT_BASE_DIR ="/home/muthu/work/Selenium/SeleniumUQ/";
	
	//All module
	public static final String Path_AllmoduleTestData = "/home/muthu/work/Selenium/SeleniumUQ/TestData/";
	public static final String File_AllmoduleTestData = "AllmoduleTestData.xlsx";
	
	//Test Data Sheet Columns
	public static final int Col_TestCaseName = 0;	
	public static final int Col_UserName =1 ;
	public static final int Col_Password = 2;
	public static final int Col_Browser = 3;
	public static final int Col_DeckName =4;
	public static final int Col_DeckType =5;
	public static final int Col_PeopleEmail =6;
	public static final int Col_Result = 7;
	
	public static final int Col_AllResult = 4;
	public static final int Col_LoginResult = 4;
	/*
	//Register Test Data Sheet Columns
	public static final int Col_TestCaseNameR = 0;	
	public static final int Col_BrowserR = 1;
	public static final int Col_UserNameR =2 ;
	public static final int Col_EmailR = 3;
	public static final int Col_PasswordR = 4;
	public static final int Col_ConfirmPasswordR = 5;
	public static final int Col_ResultR = 6;*/
	
	/*
	public static final int Col_Result = 13;*/
	public static final String Path_ScreenShot = "/home/muthu/work/Selenium/SeleniumUQ/ScreenShot/";
	public static final String Path_ExtentReport = "/home/muthu/work/Selenium/SeleniumUQ/Reports/";
	
	//All module results
	public static final String Path_AllmoduleScreenShot = "/home/muthu/work/Selenium/SeleniumUQ/AllmoduleScreenShot/";
//	public static final String Path_AllmoduleExtentReport = "/home/muthu/work/Selenium/SeleniumUQ/Reports/";
	
	public static final String Path_fileLocation = "/home/muthu/Uniqreate/TestData/seluploaddata/";
	public static final String Path_bulkfileLocation = "/home/muthu/Uniqreate/TestData/bulkuploaddata/";
			// "/home/muthu/Downloads/output/pums.txt";
	public static final String Src_UploadFile ="cron.txt";
}
