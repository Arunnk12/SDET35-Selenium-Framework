package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Test2 {
		
	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("./data/testcasespecificdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet1 = wb.getSheet("Sheet1");
		int n = wb.getSheetIndex("sheet1");
		for(int i=0;i<n;i++) {
			Row row = sheet1.getRow(i);
			Cell cell = row.getCell(i);
			String col1 = cell.getStringCellValue();
			System.out.println("col1: "+col1);
		}

	}

}
