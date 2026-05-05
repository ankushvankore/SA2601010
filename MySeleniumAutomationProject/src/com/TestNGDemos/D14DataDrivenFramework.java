package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

/*
 * Data Driven Framework
 * 1. Read the user name and password from excel file
 * 2. Pass this data to test case (application) for login
 * 3. Update the result column from excel file with Pass or Fail
 */

public class D14DataDrivenFramework {
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	int index = 1;
	
	WebDriver driver;

	@Test(dataProvider = "getLoginData")
	public void login(String un, String ps) {
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(ps);
		driver.findElement(By.id("login-button")).click();
	}
	
	@AfterMethod
	public void logout() {
		cell = sheet.getRow(index).getCell(2);
		
		if (driver.getCurrentUrl().contains("inventory")) {
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();
			
			System.out.println("Login Successful!!!\nTest case pass");
			cell.setCellValue("Pass");
		}
		else {
			System.out.println("Invalid credetionals!!!\nTest case fail");
			cell.setCellValue("Fail");
		}
		
		driver.navigate().refresh();
		
		index++;
	}

	@DataProvider
	public Object[][] getLoginData() {
		int rows = sheet.getPhysicalNumberOfRows();
		String[][]loginData = new String[rows-1][2];
		
		for(int i = 1; i < rows; i++) {
			row = sheet.getRow(i);
			for(int j = 0; j < 2; j++) {
				cell = row.getCell(j);
				loginData[i-1][j] = cell.getStringCellValue();
			}
		}
		return loginData;
	}
	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("ExcelFiles\\LoginData.xlsx");
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
		fos = new FileOutputStream(file);
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");
		
	}

	@AfterTest
	public void afterTest() throws IOException {
		wb.write(fos);
		wb.close();
		
		driver.close();
	}

}
