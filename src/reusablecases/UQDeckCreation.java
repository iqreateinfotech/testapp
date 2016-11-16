package reusablecases;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import pageObjects.CreateDeck_Modal;
import pageObjects.Success_Login;
import utility.Log;
import utility.UQUploadFileUtilRobot;

public class UQDeckCreation {
	public static WebElement element;

	
	public static WebElement DeckCreation(String strDeckName,
			String strDeckType, String strPeople, String strColorcode,
			String strFilename) throws Exception {

		Log.info("Click action is perfromed on deck creation link");
		CreateDeck_Modal.txtbx_DeckName().clear();
		CreateDeck_Modal.txtbx_DeckName().sendKeys(strDeckName);
		CreateDeck_Modal.drpbx_IdeaDeskTypeSelect().sendKeys(strDeckType);
		CreateDeck_Modal.txtbx_People().clear();
		CreateDeck_Modal.txtbx_People().sendKeys(strPeople);
		
        //choose the color else deafult will be Orange
		if (strColorcode.equals("Pink")) {
			CreateDeck_Modal.ch_Color_Pink().click();
		}

		else if (strColorcode.equals("Green"))

		{
			CreateDeck_Modal.ch_Color_Green().click();
		}

		else if (strColorcode.equals("Blue"))

		{
			CreateDeck_Modal.ch_Color_Blue().click();
		}

		else if (strColorcode.equals("LightBlue"))

		{
			CreateDeck_Modal.ch_Color_Lightblue().click();
		} else if (strColorcode.equals("Orange"))

		{
			CreateDeck_Modal.ch_Color_Orange().click();
		} else if (strColorcode.equals("Purple"))

		{
			CreateDeck_Modal.ch_Color_Purple().click();
		} else
			//default color
          System.out.println("System default color is choosen");
		
		if(!strFilename.isEmpty())
		{ //Image selection
		CreateDeck_Modal.picdeck_PhotoUpload().click();
		Thread.sleep(1000);
		// deck creation image Upload file
		UQUploadFileUtilRobot.uploadFile(strFilename);
		}  
		Thread.sleep(1000);
	//	Thread.sleep(10000);
		// file upload
		// JavascriptExecutor jsx = (JavascriptExecutor) element;
		// jsx.executeScript("document.getElementById('Bike.gif').value='" +
		// filePath + "';");
		System.out.println(strFilename +"Image is choosen/uploaded");
		
		CreateDeck_Modal.btn_CreateDeck().click();
		Log.info("Click action is performed on create deck submit button");
		System.out.println(strDeckName +"New Deck is created");
		return element;
	 }
	
	
	
	public static WebElement InvokeDeckCreationModal() throws Exception {

		Success_Login.icon_CreateDeck().click();

		return element;

	}
	
	}

	/*
	public static void verifyDeckCreationCases() throws Throwable {

		try {

			// Open the Excel file
			FileInputStream fis = new FileInputStream(
					"/home/muthu/work/Selenium/SeleniumUQ/TestData/DeckCreationData.xlsx");

			// Access the required test data sheet
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Sheet1");

		
			for (int count = 1; count <= sheet.getLastRowNum(); count++) {
				XSSFRow row = sheet.getRow(count);
				System.out.println("Running test case "
						+ row.getCell(0).toString());

				String sTestCaseName = row.getCell(0).toString();

				// Run the test for the current test data row

				if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskAdmin"))) {
					verifyNewDeckCreationWithIdeadeskAdmin(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());

				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskFinance"))) {
					verifyNewDeckCreationWithIdeadeskFinance(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskPersonal"))) {
					verifyNewDeckCreationWithIdeadeskPersonal(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskOperations"))) {
					verifyNewDeckCreationWithIdeadeskOperations(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				} else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskRnD"))) {
					verifyNewDeckCreationWithIdeadeskRnD(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskWithoutImage"))) {
					verifyNewDeckCreationWithIdeadeskWithoutImage(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
                     
				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskWithoutImagenColor"))) {
					verifyNewDeckCreationWithIdeadeskWithoutImagenColor(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithIdeadeskWithoutImagenColorEmail"))) {
					verifyNewDeckCreationWithIdeadeskWithoutImagenColorEmail(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithoutDeckName"))) {
					verifyNewDeckCreationWithoutDeckName(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithoutIdeaDeskType"))) {
					verifyNewDeckCreationWithoutIdeaDeskType(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
				else if (sTestCaseName.equals(new String(
						"verifyNewDeckCreationWithBiggerDeckName"))) {
					verifyNewDeckCreationWithBiggerDeckName(row.getCell(1)
							.toString(), row.getCell(2).toString(), row
							.getCell(3).toString(), row.getCell(4).toString(),
							row.getCell(5).toString());
				}
				
				else if (sTestCaseName.equals(new String(
						"verifyIdeaskType"))) {
					verifyIdeaskType();
				}
				
			}
			fis.close();
		} catch (IOException e) {
			System.out.println("Test data file not found");
		}
	}

}*/
