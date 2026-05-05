package com.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D13ReadingDataFromExcel {
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test (enabled = false)
	public void readTheData() {
		row = sheet.getRow(0);	//Will read 1st row
		cell = row.getCell(0);	//Will read 1st cell from 1st row
		System.out.println(cell.getStringCellValue());
		
		System.out.println(sheet.getRow(0).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(0).getCell(2).getStringCellValue());
		
		System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());
		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());
		System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
	}
	
	@Test
	public void readAllData() {
		/*for(int i = 0; i < 5; i++) {
			row = sheet.getRow(i);
			for(int j = 0; j < 3; j++) {
				cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
			}
			System.out.println("--------------------");
		}*/
		
		int rows = sheet.getPhysicalNumberOfRows();
		//int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < rows; i++) {
			int cells = sheet.getRow(i).getPhysicalNumberOfCells();
			for(int j = 0; j < cells; j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println("----------------------------");
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("ExcelFiles\\LoginData.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		//As we are not creating the workbook rather we are reading the data from existing 
		//workbook so we need to pass fileinputstream to wb object
		sheet = wb.getSheet("Sheet1");
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.close();
		fis.close();
	}

}
