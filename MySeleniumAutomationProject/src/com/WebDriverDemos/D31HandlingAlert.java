package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D31HandlingAlert {

	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/alerts");
		
		Alert alt;
		
		/*
		 * Click on 1st click me button
		 * Display the text on alert
		 * Click on Ok button
		 */
		
		//Simple Alert
		driver.findElement(By.id("alertButton")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(1000);
		alt.accept();			//Will click on Ok button of alert
		
		driver.findElement(By.id("timerAlertButton")).click();
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(1000);
		alt.accept();
		
		//Confirmation Alert
		driver.findElement(By.id("confirmButton")).click();
		alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		Thread.sleep(1000);
		alt.dismiss();		//Will click on Cancel button
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		
		//Prompt alert
		driver.findElement(By.id("promtButton")).click();
		alt = driver.switchTo().alert();
		alt.sendKeys("Pratik");
		Thread.sleep(3000);
		alt.accept();
		
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		driver.close();
	}

}
