package com.MyTests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class D10DependsOnMethodDemo {
	WebDriver driver;
	@Test
	public void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}
	
	@Test (dependsOnMethods = "login")
	public void logout() {
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@BeforeTest
	public void beforeTest() {
		Map<String, Object>pref = new HashMap();
		pref.put("profile.credentials_enable_serve", false);
		pref.put("profile.password_manager_leak_detection", false);
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("prefs", pref);
		
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
