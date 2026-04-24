package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauseLoginAssignment {
	WebDriver driver;

	@Test
	public void login1() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test
	public void login2() {
		driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test
	public void login3() {
		driver.findElement(By.id("user-name")).sendKeys("amreshwari");
		driver.findElement(By.id("password")).sendKeys("amreshwari");
		driver.findElement(By.id("login-button")).click();
	}

	@AfterMethod
	public void logout() {
		if (driver.getCurrentUrl().contains("inventory")) {
			driver.findElement(By.id("react-burger-menu-btn")).click();
			driver.findElement(By.linkText("Logout")).click();
		}
		else {
			System.out.println("Invalid credetionals");
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
