package Generic_Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/*
	 * This Method is used to get the Value from Excel sheet in String form
	 * @param SheetName
	 * @param rowNum
	 * @param CelNum
	 * @return String 
	 */
	
		public String getStringDataFromExcel(String SheetName, int rowNum, int CellNum) throws Throwable {
		
		String path1 = "./data/testspecificData1.xlsx";
		FileInputStream fis = new FileInputStream(path1);
		Workbook wb = WorkbookFactory.create(fis);
		String stringCellValue =wb.getSheet(SheetName).getRow(rowNum).getCell(CellNum).getStringCellValue();
		return stringCellValue;
	}
}
/*
  main program
 
  
  Excel_Utility exe = new Excel_Utility();
  String url = exe.getDataFromExcel("sheet1", 0, 0);

*/