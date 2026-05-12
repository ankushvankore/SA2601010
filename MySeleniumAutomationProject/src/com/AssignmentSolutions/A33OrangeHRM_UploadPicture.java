package com.AssignmentSolutions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class A33OrangeHRM_UploadPicture {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		//Admin Login
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).sendKeys(Keys.ENTER);

		//My Info
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[6]/a/span")).click();
		
		//Image
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[2]/div/img")).click();
		
		//Add Image (+) button
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[1]/div/div/div[2]/div/button")).click();
		
		//Upload image
		Robot rbt = new Robot();
		
		for(int i = 1; i <= 9; i++) {
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_TAB);
		}
		
		for(int i = 1; i <= 2; i++) {
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_DOWN);
		}
		
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_TAB);
		
		for(int i = 1; i <= 8; i++) {
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_DOWN);
		}
		
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div[2]/button")).click();

		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
		driver.findElement(By.partialLinkText("Log")).click();
		
		driver.close();
	}

}
