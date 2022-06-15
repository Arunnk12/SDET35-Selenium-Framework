package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.POMRepo.HomePage;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.PropertyFile_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateContactWithoutNameTest {

	public static void main(String[] args) throws Throwable {
		
		Excel_Utility exl = new Excel_Utility();
		PropertyFile_Utility pro = new PropertyFile_Utility();
		Java_Utility jav = new Java_Utility();
		WebDriver_Utility wd = new WebDriver_Utility();
		Base_Class ba = new Base_Class();
		
		String LastName =exl.getStringDataFromExcel("Sheet1", 4, 15)+jav.getRandomNum();
		String browser = pro.getDataFromProperty("browser");
		
		/*WebDriver driver=wd.getRemoteDriver(browser);
		wd.maximizeAndApplyImplicityWait(driver, 10);
		
		LoginPage loginP = new LoginPage(driver);
		driver.get(pro.getDataFromProperty("url"));
		loginP.loginToApp(pro.getDataFromProperty("username"), pro.getDataFromProperty("password"));
		
		HomePage homeP = new HomePage(driver);
		homeP.getContactsLink().click();
		
		ContactsPage contactsP = new ContactsPage(driver);
		contactsP.getContactsPlusLink().click();
		
		ContactsInfoPage contactsIP = new ContactsInfoPage(driver);
		contactsIP.getLastNameTF().sendKeys(LastName);
		contactsIP.getSaveButton().click();
		
		CreatedCntPage createdCP = new CreatedCntPage(driver);
		wd.pageCreateConfirmationMsg(createdCP.getCreatedCntPageName().getText(), LastName);
		
		wd.mouseOverOnElement(driver, homeP.getAdministratorSignout());
		homeP.getSignoutButton().click();
		
		driver.quit();
		System.out.println("Logout Successfully");

		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname"));
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String expectedMsg = "Last Name cannot be empty";
		Alert a = driver.switchTo().alert();
		if(a.getText().trim().equalsIgnoreCase(expectedMsg.trim())) {
			 System.out.println("Alert Message is verified");
		 }else {
			 System.out.println("Alert Message is not verified");
		 }
		a.accept();
		Actions ac = new Actions(driver);
		WebElement adm = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		ac.moveToElement(adm).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	*/
	}	
}
