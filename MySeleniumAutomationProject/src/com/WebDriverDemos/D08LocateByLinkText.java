package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D08LocateByLinkText {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://practicetestautomation.com/practice-test-login/");

		WebElement txtUserName = driver.findElement(By.name("username"));
		txtUserName.sendKeys("student");
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("Password123");
		WebElement btnLogin = driver.findElement(By.id("submit"));
		btnLogin.click();

		String url = driver.getCurrentUrl();

		if (url.contains("successfully")) {
			WebElement logoutLink = driver.findElement(By.linkText("Log out"));
			logoutLink.click();
		}
		else
		{
			System.out.println("Invalid credtionals");
		}
	}

}
