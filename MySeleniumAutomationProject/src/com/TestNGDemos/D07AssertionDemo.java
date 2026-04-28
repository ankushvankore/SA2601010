package com.TestNGDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D07AssertionDemo {
	WebDriver driver;
	String expUrl = "https://www.saucedemo.com/inventory.html", actUrl;

	@Test(dataProvider = "getLoginData")
	public void login(String un, String ps) {
		driver.findElement(By.id("user-name")).sendKeys(un);
		driver.findElement(By.id("password")).sendKeys(ps);
		driver.findElement(By.id("login-button")).click();
		
		actUrl = driver.getCurrentUrl();
		
		//Assert.assertEquals(actUrl, expUrl);
		//Assert.assertTrue(actUrl.equals(expUrl));
		Assert.assertTrue(actUrl.contains("inventory"));
		
	}

	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			new Object[] { "standard_user", "secret_sauce" },
			new Object[] { "lakshmi", "lakshmi" },
			new Object[] { "performance_glitch_user", "secret_sauce" },
			new Object[] { "nishma", "nishma" },
		};

		//Object[][] data = new Object[][] {{1, "a"}, {2, "b"}, {3, "c"}};

	}

	@BeforeMethod
	public void clearTextBoxes() {
		//driver.findElement(By.id("user-name")).clear();
		//driver.findElement(By.id("password")).clear();
		driver.navigate().refresh();
	}

	@AfterMethod
	public void logout() {
		if (driver.getCurrentUrl().contains("inventory")) {
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();

			//System.out.println("Login Successful!!!\nTest case pass");
			Reporter.log("Login Successful!!!\nTest case pass");
		}
		else {
			//System.out.println("Invalid credetionals!!!\nTest case fail");
			Reporter.log("Invalid credetionals!!!\nTest case fail");
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.saucedemo.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
