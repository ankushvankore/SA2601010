package com.TestNGDemos;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class D10POM_Client_Rediff {
	WebDriver driver;
	RediffUtility r1;
	
	@Test
	public void register() {
		r1.setFullName("Akansha Saraf");
		r1.setRediffId("akansha");
		r1.setPassword("akansha@123");
		r1.setBirthDate("29", "SEP", "2000");
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
