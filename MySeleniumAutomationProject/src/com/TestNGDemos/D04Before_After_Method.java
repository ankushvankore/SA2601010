package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D04Before_After_Method {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before method");
	}
	
	@AfterMethod
	public void printTitle() {
		System.out.println("Title: " + driver.getTitle());
	}

	@Test(priority = 3)
	public void testFlipkart() {
		driver.get("https://www.flipkart.com/");
	}

	@Test(priority = 1)
	public void testMyntra() {
		driver.get("https://www.myntra.com/");
	}

	@Test(priority = 2)
	public void testAmazon() {
		driver.get("https://www.amazon.in/");
	}

	@Test(priority = 4)
	public void testNykaa() {
		driver.get("https://www.nykaa.com/");
	}
}
