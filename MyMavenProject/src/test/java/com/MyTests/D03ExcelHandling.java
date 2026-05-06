package com.MyTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D03ExcelHandling {
	/*
	 * For Excel Handling (Apache POI) you need to add 2 dependencies
	 * 1. Apache POI
	 * 2. Apache POI OOXML
	 * 
	 * Make sure that both are having same version
	 */
	
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Test
	public void getData() {
		int rows = sheet.getPhysicalNumberOfRows();
		int cells = sheet.getRow(0).getPhysicalNumberOfCells();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cells; j++)
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
		}
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("D:\\StarAgile\\Demos\\SA2601010_08Apr\\MySeleniumAutomationProject\\ExcelFiles\\LoginData.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
	}

	@AfterTest
	public void afterTest() {
	}

}
