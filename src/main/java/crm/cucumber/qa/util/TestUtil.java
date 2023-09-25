package crm.cucumber.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import crm.cucumber.qa.base.TestBase;



public class TestUtil extends TestBase{
	
	static Workbook book;
	static Sheet sheet;
	
	public TestUtil() throws IOException {
		
	}

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	
	public void frame(String frame) {
		driver.switchTo().frame(frame);
	}
	
	public static Object [][] getTestData(String sheetName){
		FileInputStream file=null;
		
		try {
			String  TestDataPath="D:\\Automation Testing\\CucumberProject\\src\\main\\java\\crm\\cucumber\\qa\\testdata\\FreeCrmTestData.xlsx";
			file =new FileInputStream(TestDataPath);					
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try {
			book=WorkbookFactory.create(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
					
			}
		}
		return data;
	}
}
