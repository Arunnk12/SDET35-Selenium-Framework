import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bjh {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	List<WebElement> alllinks = driver.findElements(By.tagName("a"));
System.out.println("get all links"+alllinks.size());

for(int i=0;i<alllinks.size();i++) {
	System.out.println("print all links"+alllinks.get(i).getAttribute("href"));
	System.out.println("print all links"+alllinks.get(i).getText());
}
	}

}
