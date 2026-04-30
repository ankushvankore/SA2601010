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

public class D12CreateStudentList {
	File file;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	@Test
	public void createList() {
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("Akansha");
		
		//row = sheet.createRow(0);
		cell = row.createCell(1);
		cell.setCellValue("Saraf");
		
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("Priyanka");
		
		cell = row.createCell(1);
		cell.setCellValue("Patel");
		
		sheet.createRow(2).createCell(0).setCellValue("Lakshmi");
		sheet.getRow(2).createCell(1).setCellValue("Narasian");
	}

	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		file = new File("ExcelFiles\\StudentsList.xlsx");
		fos = new FileOutputStream(file);
		wb = new XSSFWorkbook();
		sheet = wb.createSheet();
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
	}

}
