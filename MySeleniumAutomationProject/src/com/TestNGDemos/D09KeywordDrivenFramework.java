package com.TestNGDemos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D09KeywordDrivenFramework {
	WebDriver driver;
	File file;				//As we are handling the file
	FileInputStream fis;	//As we are trying to read the data from file
	Properties prop;		//As we are reading the properties from .properties file	
	
	@Test
	public void automobileTest() {
		driver.findElement(By.linkText(prop.getProperty("autoLinkText"))).click();
		Select dd = new Select(driver.findElement(By.id(prop.getProperty("makeDDId"))));
		dd.selectByIndex(3);
		driver.findElement(By.name(prop.getProperty("epName"))).sendKeys("2000");
		driver.findElement(By.cssSelector(prop.getProperty("domCss"))).sendKeys("04/01/2026");
		new Select(driver.findElement(By.xpath(prop.getProperty("seatsXpath")))).selectByIndex(2);
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		file = new File("src/com/TestNGDemos/MyLocators.properties");
		fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);				//Copy and load all the properties to prop object
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}

}
