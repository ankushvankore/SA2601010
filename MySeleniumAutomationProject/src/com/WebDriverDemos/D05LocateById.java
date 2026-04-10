package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D05LocateById {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement txtUserName = driver.findElement(By.id("username"));
		//Please locate / find a control on this page whose id is "username" and store in object txtUserName
		txtUserName.sendKeys("student");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("pavani123");
		WebElement btnSubmit = driver.findElement(By.id("submit"));
		btnSubmit.click();
	}

}
