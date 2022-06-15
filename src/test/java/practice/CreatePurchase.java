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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchase {

	public static void main(String[] args) throws IOException {
		//Tc=33 Create purchase order with contact name
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
			driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[2]")).click();
				//String parentwind2 = driver.getWindowHandle();
				Set<String> allwind2 = driver.getWindowHandles();
				//allwind2.remove(parentwind2);
				System.out.println(allwind2);
				
				Iterator<String> it3 = allwind.iterator();
				while(it3.hasNext()) {
					String cid2 = it3.next();
					driver.switchTo().window(cid2);
					String title3 = driver.getTitle();
					if(title3.contains("Contacts&action")) 
						break;
				}
				driver.findElement(By.linkText("Mary Smith")).click();

				Set<String> allwind4 = driver.getWindowHandles();
				System.out.println(allwind4);
				
				Iterator<String> it4 = allwind4.iterator();
				while(it4.hasNext()) {
					String cid4 = it4.next();
					driver.switchTo().window(cid4);
					String title4 = driver.getTitle();
					if(title4.contains("PurchaseOrder&action")) 
						break;
					}
				driver.findElement(By.name("bill_street")).sendKeys("Bangalore");
				driver.findElement(By.name("ship_street")).sendKeys("Davangere");

				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollTo(0,1000)");
				
				driver.findElement(By.id("searchIcon1")).click();
				String parentwind5 = driver.getWindowHandle();
				Set<String> allwind5 = driver.getWindowHandles();
				allwind5.remove(parentwind5);
				System.out.println(allwind5);
				
				Iterator<String> it5 = allwind5.iterator();
				while(it5.hasNext()) {
					String cid5 = it5.next();
					driver.switchTo().window(cid5);
					String title5 = driver.getTitle();
					if(title5.contains("Products&action")) 
						break;
				}
				
				driver.findElement(By.id("search_txt")).sendKeys("Mobiles");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.id("all_contacts")).click();
				driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
				//driver.findElement(By.linkText("Product Name ")).click();
				Set<String> allwind6 = driver.getWindowHandles();
				//allwind4.remove(parentwind4);
				System.out.println(allwind6);
				
				Iterator<String> it6 = allwind6.iterator();
				while(it6.hasNext()) {
					String cid6 = it6.next();
					driver.switchTo().window(cid6);
					String title6 = driver.getTitle();
					if(title6.contains("PurchaseOrder&action")) 
						break;
				}
				
	}}


