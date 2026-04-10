package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D06LocateByName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		WebElement txtUserName = driver.findElement(By.name("username"));
		txtUserName.sendKeys("diksha");
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("Password123");
		WebElement btnLogin = driver.findElement(By.id("submit"));
		btnLogin.click();
	
		//Display error message
		WebElement errMessage = driver.findElement(By.id("error"));
		String text = errMessage.getText();
		
		System.out.println(text);
		
		if(text.contains("invalid"))
			System.out.println("Test case pass");
		else
			System.out.println("test case fail");
		
		driver.close();
	}

}
