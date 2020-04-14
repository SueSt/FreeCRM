package com.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.crm.base.TestBase;


public class TestUtil extends TestBase{

	
	// this is for the ExcelsheetData
		public static String TestData_Sheet_Path="C:\\Users\\souad\\eclipse-Newworkspace\\ZZZFreeCrmTest\\src\\main\\java\\com\\crm\\testdata\\testdata.xlsx";
		static Workbook book;
		static Sheet sheet;

		public static Object[][] getTestData(String sheetName) {
			FileInputStream file=null;
			try {
				file = new FileInputStream(TestData_Sheet_Path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
			book = new XSSFWorkbook(file);
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			// Read sheet inside the workbook by its name
			 sheet =  book.getSheet(sheetName);

			int rowCount = sheet.getLastRowNum();
			int colCount = sheet.getRow(0).getLastCellNum();

			Object data[][] = new Object[rowCount][colCount];
			for (int rNum = 0; rNum < rowCount; rNum++) {
				for (int cNum = 0; cNum < colCount; cNum++) {
					data[rNum][cNum] = sheet.getRow(rNum + 1).getCell(cNum).toString();
				}
			}
			return data;
		}
	//ExcelsheetData Code ends here
	//________________________________________________________________________________	

		//IO Exception and taking screenshot
			
			public static void TakeScreenshotAtEndOfTest() throws IOException{
				File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				String currentDir = System.getProperty("user.dir");
				
				FileUtils.copyFile(scrFile, new File(currentDir+ "/screenshots/"+ System.currentTimeMillis()+".png"));	
			}
		//IO Exception and taking screenshot code end
		//___________________________________________________________________________________	
		}



