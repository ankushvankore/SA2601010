package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class D14RelativeLocator {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@id='txtPassword']"))).sendKeys("admin");
	}

}
