package practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class gridPractice {
@Test
 public void gridPractice1() throws MalformedURLException {
	URL url=new URL("http://192.168.10.77:6666/wd/hub");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setBrowserName("chrome");
	cap.setPlatform(Platform.WINDOWS);
	RemoteWebDriver driver=new RemoteWebDriver(url, cap);
	driver.get("http://gmail.com");
}
}
