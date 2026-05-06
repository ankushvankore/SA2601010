package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D01JOT_Registration {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.jotform.com/form-templates/exam-registration-form");
		System.out.println("Title: " + driver.getTitle());
		
		driver.switchTo().frame(driver.findElement(By.id("formPreviewArea")));
		
		driver.findElement(By.id("first_9")).sendKeys("Ayush");
		
		//driver.close();

	}

}
