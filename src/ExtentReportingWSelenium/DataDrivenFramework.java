package ExtentReportingWSelenium;

//import utility.Constant;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


//import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.DataHelper;
import utility.Log;

public class DataDrivenFramework {
    public static WebDriver driver;
  
    public static List<HashMap<String,String>> datamap;
    public final String Path = "/home/muthu/work/Selenium/SeleniumUQ/TestData/default.xlsx";
    public DataDrivenFramework()
    {
    
     	datamap = DataHelper.data(System.getProperty("user.dir")+"//TestData/default.xlsx","Sheet1");
    }
    
    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
    	 
        // The number of times data is repeated, test will be executed the same no. of times
 
        // Here it will execute two times
 
        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
 
  }
    /*
    @DataProvider(name = "DP1")
    public Object[][] createData1() throws Exception{
        Object[][] retObjArr=ExcelUtils.getTableArray("test\\Resources\\Data\\data1.xls","DataPool", "imdbTestData1");
        return(retObjArr);
    }
   //	public void Login(String arg1) throws Throwable 
*/

   @SuppressWarnings("rawtypes")
@Test(dataProvider = "Authentication")
    public static void Login(String UserName,String Password )throws Throwable{
         
        int index = Integer.parseInt(UserName)-1;
     
        System.out.println("Printing current data set...");
        for(HashMap h:datamap)
        {
            System.out.println(h.keySet());
            System.out.println(h.values());
        }
        driver = new FirefoxDriver();
        driver.get("http://deck.uniqreate.qa/");
      //	Home_Page.lnk_SignIn().click();
        
        driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[2]/span/a")).click();
     	Log.info("Click action is perfromed on Sign In link" );
        driver.findElement(By.id("email")).sendKeys(datamap.get(index).get("UserName"));
        driver.findElement(By.id("password")).sendKeys(datamap.get(index).get("Password"));
        LogIn_Page.btn_LogIn().click();
        Log.info("Click action is performed on Submit button");
        
     
    }
}