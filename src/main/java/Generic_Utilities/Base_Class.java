package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.comcast.POMRepo.HomePage;
import com.crm.comcast.POMRepo.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public PropertyFile_Utility filelib=new PropertyFile_Utility();
	public WebDriver_Utility drivelib=new WebDriver_Utility();
	
	public WebDriver driver=null;
	
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void bs() {
		System.out.println("Database connection");
	}
	@BeforeTest(groups= {"smoke","regression"})
	public void bt() {
		System.out.println("execute script in parallel mode");
	}
	@BeforeClass(groups= {"smoke","regression"})
	public void bc() throws Throwable {
		String browser = filelib.getDataFromProperty("browser");
		if(browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
					}
		else {
			driver = new ChromeDriver();	
			
		}
		
		drivelib.maximizeAndApplyImplicityWait(driver, 10);
		String url = filelib.getDataFromProperty("url");
		driver.get(url);
		}
	
		@BeforeMethod(groups= {"smoke","regression"})
		public void bm () throws Throwable{
			String un = filelib.getDataFromProperty("username");
			String pwd = filelib.getDataFromProperty("password");
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(un, pwd);	
		}
		
		@AfterMethod(groups= {"smoke","regression"})
		public void am() {
			HomePage hp = new HomePage(driver);
			hp.getSignoutButton().click();	
		}
		@AfterClass(groups= {"smoke","regression"})
		public void ac() {
			driver.quit();
		}
		@AfterTest(groups= {"smoke","regression"})
		public void at() {
			System.out.println("parallel execution is completed");
		}
		@AfterSuite(groups= {"smoke","regression"})
		public void as() {
			System.out.println("close the database connection");
		}
	}