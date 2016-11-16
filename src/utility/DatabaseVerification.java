package utility;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatabaseVerification {

	public static String uuid = UUID.randomUUID().toString();
	public static String strDeckName123 = uuid + "Databaseverify";

	public static final String baseUrl = "http://deck.uniqreate.qa/";
	public static String strPassword = "123456";
	public static String strConfirmPassword = "123456";
	public static WebElement element;
	public static WebDriver driver;
	public static Statement stat = null;
	public static ResultSet result = null;


	public static void VerifyDataInDatabase_test() throws SQLException,
			ClassNotFoundException, Exception {

		String dbUrl = "jdbc:mysql://192.168.0.212:3306/deckqa"; // This is DB
																	// URL
		String username = "qauser";
		String password = "S3cureP@55";
		String dbClass = "com.mysql.jdbc.Driver";
		String newdeckcreationquery123 =null;;
		
		Class.forName(dbClass);
		// Get connection to DB.
		Connection con = DriverManager.getConnection(dbUrl, username, password);
		
		
		//String newdeckcreationquery = "SELECT * From decks where title=?";
		// create a statement
		PreparedStatement stat = con.prepareStatement(newdeckcreationquery123);
		stat.setString(1, strDeckName123);
		try {
			boolean hasResultSet = stat.execute();
			if (hasResultSet) {
				ResultSet result = stat.getResultSet();
				// get new deck name from the table
				result.next();
				String newdeckname = result.getString("title");
				// assert that new deck name should be
				
				assertEquals(strDeckName123, newdeckname);

				System.out
						.println("Deck Creation record is added in DB successfully: " +strDeckName123);

	     }
			
		}
		
		catch (SQLException ex) {
			System.out.println(ex);
		}
}

}	
	
