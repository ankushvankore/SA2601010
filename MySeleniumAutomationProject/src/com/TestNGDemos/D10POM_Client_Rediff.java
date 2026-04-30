package com.TestNGDemos;

import org.testng.annotations.Test;

import graphql.Assert;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class D10POM_Client_Rediff {
	WebDriver driver;
	RediffUtility r1;
	
	@Test
	public void register1() throws InterruptedException {
		r1.setFullName("Akansha Saraf");
		r1.setRediffId("akansha");
		r1.setPassword("akansha@123");
		r1.setBirthDate("29", "SEP", "2000");
		String msg = r1.checkAvailablity();
		Assert.assertTrue(msg.contains("Yippie"));
	}
	
	@Test
	public void register2() throws InterruptedException {
		r1.setFullName("Pratik Mahapatra");
		r1.setRediffId("pratik_m789654");
		r1.setPassword("Pratik@123");
		r1.setBirthDate("15", "MAR", "2000");
		//r1.checkAvailablity();
		Assert.assertTrue(r1.checkAvailablity().contains("Yippie"));
	}
	
	@AfterMethod
	public void refreshPage() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@BeforeTest
	public void beforeTest() throws IOException {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		r1 = new RediffUtility(driver);
	}

	@AfterTest
	public void afterTest() {
		//driver.close();
	}
}
