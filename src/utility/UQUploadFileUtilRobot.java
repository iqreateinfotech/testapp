package utility;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class UQUploadFileUtilRobot {

	static String fileLocation = "/home/muthu/Uniqreate/TestData/seluploaddata/";
	static String strFilename;
	static String pathoffile = fileLocation + strFilename;

	public static WebElement element;


	/* This method will set any parameter string to the system's clipboard. */

	public static void setClipboardData(String strFilename) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		// Specify the file location with extension
		StringSelection stringSelection = new StringSelection(strFilename);
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(stringSelection, null);
		
	}

	public static void uploadFile(String strFilename) {
		try {

		    String fileLocation = "/home/muthu/Uniqreate/TestData/seluploaddata/";

			String pathoffile = fileLocation + strFilename;

			// Setting clipboard with file location
			System.out.println(pathoffile);
			setClipboardData(pathoffile);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			Thread.sleep(1000);

			// to clear the previous text in file upload loction
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyPress(KeyEvent.VK_DELETE);

			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_DELETE);

			// Press Enter - Calling key press event to press Enter Key from
			// keyboard to place cursor in window textbox
			// robot.keyPress(KeyEvent.VK_ENTER);
			// Release Enter
			// robot.keyRelease(KeyEvent.VK_ENTER);
			/*
			 * // Press CTRL+V Now we are going to trigger CTRL+V action so
			 * first we will press CTRL and then V and finally will release
			 * these key.
			 */
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			// Release CTRL+V
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			Thread.sleep(100);
			// Press Enter
			// After pasting path now we are going to click on Open and that can
			// be triggered by pressing enter key from Keyboard.
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			// Release open
			Thread.sleep(1000);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
