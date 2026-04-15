package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D13LocateByXPath_Relative {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		driver.findElement(By.xpath("//div[@id='form']/div[1]/input")).sendKeys("student");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password123");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		
		if(driver.getCurrentUrl().contains("success"))
			driver.findElement(By.linkText("Log out")).click();
	}

}
