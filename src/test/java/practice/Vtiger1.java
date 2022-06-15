	package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Vtiger1 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/data.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		WebDriver driver;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.close();

	}
	}
		

