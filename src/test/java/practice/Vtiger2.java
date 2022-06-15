package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Vtiger2 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./commontestdata/commontestdata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");

	}

}
