package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

	/*
	 * It Contains External Files Specific Libraries 
	 * @author Arun
	 */

public class WebDriver_Utility {
	
	/*
	 * This Method is used to get the Value from Excel sheet in String form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return String 
	 */
	
	public String getStringDataFromExcel(String SheetName, int rowNum, int CelNum) throws Throwable {
		
		String path = "./data/testspecificData1.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		String stringCellValue =workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getStringCellValue();
		return stringCellValue;
	}
		
	/*
	 * This Method is used to get the Value from Excel sheet in numeric form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return double
	 */
	
	public double getNumDataFromExcel(String SheetName, int rowNum, int CelNum) throws Throwable {
			
		String path = "./data/testspecificData1.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		double stringCellValue = workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getNumericCellValue();
		return stringCellValue;
	}
	
	
	/*
	 * This Method is used to get the Value from Excel sheet in boolean form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return boolean
	 */
	
	public boolean getbooleanDataFromExcel(String SheetName, int rowNum, int CelNum) throws Throwable {
		
		String path = "./data/testspecificData1.xlsx";
		FileInputStream fin = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fin);
		boolean stringCellValue = workbook.getSheet(SheetName).getRow(rowNum).getCell(CelNum).getBooleanCellValue();
		return stringCellValue;
	}


	
	/*
	 * This Method is used to switch to another window based on the title
	 * @param driver
	 * @param partialWindowTitle
	 * @return void
	 */
	
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> allWin = driver.getWindowHandles(); 
		Iterator<String> it1 = allWin.iterator();
		while(it1.hasNext()) {
			String cid = it1.next();
			driver.switchTo().window(cid);
			String currentWinTitle = driver.getTitle();
			if(currentWinTitle.contains(partialWindowTitle)) 
				break;
		}
	}
	
	public void switchToParentWin(WebDriver driver, String parentWin) {
		driver.switchTo().window(parentWin);
	}
	
	
	
	/*
	 * This Method is used to switch to another window based on the title by initially excluding the parent window from the set of string
	 * @param driver
	 * @param partialWindowTitle
	 * @return void
	 */
	
	public void switchToWindowExcludeParent(WebDriver driver, String partialWindowTitle) {
		String parentWin = driver.getWindowHandle(); 
		Set<String> allWin = driver.getWindowHandles(); 
		allWin.remove(parentWin);
		Iterator<String> it1 = allWin.iterator();
		while(it1.hasNext()) {
			String cid = it1.next();
			driver.switchTo().window(cid);
			String currentWinTitle = driver.getTitle();
			if(currentWinTitle.contains(partialWindowTitle)) 
				break;
		}
	}
	
	
	/*
	 * This Method is used to switch to another window based on the title
	 * @param confirmationPageMsg
	 * @param pageName
	 * @return void
	 */
	public void pageCreateConfirmationMsg(String confirmationPageMsg, String pageName) {
		if(confirmationPageMsg.contains(pageName)) 
			System.out.println(pageName+" Page is successfully created and displayed :: Pass");
		else
			System.out.println(pageName+" Page is not created :: Fail");
	}
	
	/*
	 * This Method is used to Maximize the Window and Apply Implicit Wait 
	 * @param driver
	 * @param Implicity Wait value
	 * @return void
	 */
	
	public void maximizeAndApplyImplicityWait(WebDriver driver, int Value) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Value, TimeUnit.SECONDS);
	}
	
	/*
	 * This method is used to mouse over on a target element
	 * @param driver
	 * @param ele
	 * @return void
	 */
	
	public void mouseOverOnElement(WebDriver driver, WebElement ele) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
	}

	/*
	 * This method is used to scroll the webPage
	 * @param driver
	 * @param arguments
	 * @return void
	 */
	
	public void scrollTo(WebDriver driver, String arguments) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript(arguments); 
	}
	
	/*
	 * This method is used to accept the alert with verification
	 * @param driver
	 * @param alertTextMsg - Expected Message
	 * @return void
	 */
	
	public void switchToAlertAndAccept(WebDriver driver, String alertTextMsg) {
		
		Alert alert = driver.switchTo().alert();
		if(alert.getText().contains(alertTextMsg)) 
			System.out.println("Alert Message is Verified");
		else
			System.out.println("Alert Message is not verified :: alert Msg - "+alert.getText()+" :: Expected - "+alertTextMsg);
		
		alert.accept();
	}
	
}
