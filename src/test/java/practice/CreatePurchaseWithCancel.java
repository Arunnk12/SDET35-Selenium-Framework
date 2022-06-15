package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

class CreatePurchaseWithCancel {

	public static void main(String[] args) throws IOException {
		//Tc=46 create purchase order click on the area at the top end 
		//click on Duplicate and create one non mandatory field and click on Cancel
		
		String path="./data/common.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties pro = new Properties();
		pro.load(fis);
		
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String pass = pro.getProperty("password");
		
		WebDriver driver = null;
		String browse = pro.getProperty("browser");
		System.out.println(browse);
		
		if(browse.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browse.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();
		
		Random ran = new Random();
		 int ranNum = ran.nextInt();
			String path1 = "./data/testspecificData.xlsx";
			FileInputStream fi = new FileInputStream(path1);
			Workbook wb = WorkbookFactory.create(fi);
			String orgName = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions a = new Actions(driver);
		a.moveToElement(more).perform();
		driver.findElement(By.linkText("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		driver.findElement(By.name("subject")).sendKeys("Shoes");
		driver.findElement(By.xpath("//img[@alt='Select'][1]")).click();
		
		String parentwind = driver.getWindowHandle();
		Set<String> allwind = driver.getWindowHandles();
		allwind.remove(parentwind);
		
		System.out.println(allwind);
		
		Iterator<String> it1 = allwind.iterator();
		while(it1.hasNext()) {
			String cid = it1.next();
			driver.switchTo().window(cid);
			String title1 = driver.getTitle();
			if(title1.contains("Vendors&action")) 
				break;
			}
		
		driver.findElement(By.linkText("Mary")).click();
		
		Set<String> allwind1 = driver.getWindowHandles();
		System.out.println(allwind1);
		
		Iterator<String> it2 = allwind1.iterator();
		while(it2.hasNext()) {
			String cid1 = it2.next();
			driver.switchTo().window(cid1);
			String title2 = driver.getTitle();
			if(title2.contains("PurchaseOrder&action")) 
				break;
			
			
		
			
		}
		

	}

}
