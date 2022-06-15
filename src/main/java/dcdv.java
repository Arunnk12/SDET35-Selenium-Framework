import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dcdv {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.skillrary.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total no of links "  +links.size());
		
		for(int i=0; i<links.size();i++)
		{
			System.out.println("links on page are"  +links.get(i).getAttribute("href"));
			System.out.println("links on page are"  +links.get(i).getText());
		}
		
	}

}
