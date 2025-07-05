package ownFramework.Trial;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class fectdatafromexcel {
  @Test
  public void f() throws IOException {

	//File file = new File("C:\\Users\\SKP\\Documents\\workspace\\NewProject\\data\\data.xlsx");
	FileInputStream fis=new FileInputStream("data.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook (fis);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	System.out.println(sheet.getRow(0).getCell(0).getStringCellValue());
	System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
	System.out.println(sheet.getRow(2).getCell(0).getStringCellValue());
	System.out.println(sheet.getRow(3).getCell(0).getStringCellValue());
	System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
	System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
	System.out.println(sheet.getRow(2).getCell(1).getStringCellValue());
	System.out.println(sheet.getRow(3).getCell(1).getStringCellValue());
	workbook.close();
	fis.close();
  }
}
