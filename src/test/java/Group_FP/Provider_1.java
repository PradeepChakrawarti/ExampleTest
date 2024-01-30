package Group_FP;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class Provider_1 {

	 public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException{
		 
		 
		 
		 
		 FileInputStream file = new FileInputStream("C:\\Users\\Prade\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\masaiproject\\src\\main\\resources\\Project_Data.xlsx");
		 
		 Workbook newBook = WorkbookFactory.create(file);
		 
		 
		 Sheet sheet1 = newBook.getSheet("Sheet1");
		 
		 int RowCount = sheet1.getRow(0).getLastCellNum();
		 int CellCount = sheet1.getRow(0).getLastCellNum();
		 
		 Object[][] obj = new Object[RowCount][CellCount];
		 
		 for(int i=0;i<RowCount;i++) {
			 
			 for(int j=0;j<CellCount;j++) {
				 
				 obj[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
			 }
		 }
		 
		return obj;
		 
		 
	 }

	
	 
	
}
