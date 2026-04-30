package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class D11WritingToExcel {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test
	public void writeTheData() {
		row = sheet.createRow(0);		//Will create 1st row
		cell = row.createCell(0);		//Will create 1st cell inside 1st row
		
		cell.setCellValue("Lakshmi");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File("MyFirstExcelFile.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet("My First Sheet");
		//If you didn't specify the name of sheet then by default it will create a sheet with name Sheet0
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);				//Will write the data physically to the file
		
	}

}
