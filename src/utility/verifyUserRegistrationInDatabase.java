package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class verifyUserRegistrationInDatabase {
	static String uuid = UUID.randomUUID().toString();

	public static final String baseUrl = "http://deck.uniqreate.qa/";
	public static String strName = uuid;
	public static String strEmail = uuid + "@email.com";
	public static String strPassword = "123456";
	public static String strConfirmPassword = "123456";
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		// use firefox browser
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		// final String URL = "http://deck.uniqreate.qa/";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public static void DBVerify() throws SQLException, ClassNotFoundException,
			Exception {

		String dbUrl = "jdbc:mysql://192.168.0.212:3306/deckqa"; // This is DB URL
		String username = "qauser";
		String password = "S3cureP@55";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * from users";
		// String invitequery = null;

		Class.forName(dbClass);
		// Get connection to DB.
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create statement object which would be used in writing DDL and DML
		// SQL statement.
		Statement stmt = con.createStatement();

		try {
			ResultSet result = stmt.executeQuery(query);
			if (result.next()) {

				while (result.next()) {
					// Fetch value of "id" , "deck id " and "email" from
					// "result"
					String userid = result.getString("id");
					// String deckid = result.getString("deck_id");
					String email = result.getString("email");

					// print them on the console
					System.out.println(userid + " " + email);

				} // end while
				result.close();

			}
		}

		catch (SQLException ex) {
			System.out.println(ex);
		}

		driver.get(baseUrl);

		driver.findElement(By.xpath(".//*[@id='login_menu']/ul/li[1]/span/a"))
				.click();

		// Registration

		driver.findElement(By.xpath(".//*[@id='register']/div[1]/div/input"))
				.sendKeys(strName);
		driver.findElement(By.xpath(".//*[@id='register']/div[2]/div/input"))
				.sendKeys(strEmail);
		driver.findElement(By.xpath(".//*[@id='register']/div[3]/div/input"))
				.sendKeys(strPassword);
		driver.findElement(By.xpath(".//*[@id='register']/div[4]/div/input"))
				.sendKeys(strConfirmPassword);
		driver.findElement(By.xpath(".//*[@id='register']/div[5]/button"))
				.click();

		Thread.sleep(1000);
		System.out.println("New User registration verification in Database");
		
		// verify the new user in the database
		// create a query
		String newuserquery = "SELECT * From users where email=?";
		// create a statement
		PreparedStatement stat = con.prepareStatement(newuserquery);
		stat.setString(1, strEmail);
		try {
			boolean hasResultSet = stat.execute();
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();
				// get new user name from the table
				result.next();
				String newuseremail = result.getString("email");
				// assert that new user name should be
				Assert.assertEquals(strEmail, newuseremail);
				
				System.out.println("User registration records added in DB successfully");
			}
		} 
		catch (SQLException ex){
			System.out.println(ex);
		}

	}

	@AfterMethod
	public void aftermethod() throws Exception {
		// close the driver
		driver.close();
	}

} // end class