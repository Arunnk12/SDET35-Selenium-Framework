package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Test3 {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./data/testcasespecificdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String finddata = "admin";
		int n=wb.getSheet("Sheet1").getLastRowNum();
		for(int i=0;i<n;i++) {
			  Sheet colcellvalue = wb.getSheet("Sheet1");
		}

	}

}
//login the v tiger application