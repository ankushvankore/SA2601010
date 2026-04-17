package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A19BlingAssignment {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://dash.bling-center.com/platform/signIn.html");
		
		driver.findElement(By.className("forget-password-btn")).click();
		
		driver.findElement(By.id("email1")).sendKeys("akansha@gmail.com");
		driver.findElement(By.className("reset-pwd")).click();
		Thread.sleep(2000);
		System.out.println("Message is: " + driver.findElement(By.id("resetsuccess")).getText());
	}

}
