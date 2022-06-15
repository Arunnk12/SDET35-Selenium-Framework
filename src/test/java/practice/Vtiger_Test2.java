package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Vtiger_Test2 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./commontestdata/testdata.xlsx");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		//excel
		FileInputStream fis1 = new FileInputStream("./commontestdata/testdata.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("Sheet1");
		 Row row = sh.getRow(2);
		 Cell cell = row.getCell(3);
		 String data = cell.getStringCellValue();
		
	}

}
