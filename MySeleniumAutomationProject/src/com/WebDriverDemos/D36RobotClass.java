package com.WebDriverDemos;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D36RobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://sampleapp.tricentis.com/101/index.php");

		Robot rbt = new Robot();

		driver.findElement(By.linkText("Automobile")).click();
		driver.findElement(By.partialLinkText("Insurant")).click();
		driver.findElement(By.id("open")).click();

		for (int i = 1; i <= 8; i++) {
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_TAB); // This will press Tab from keyboard
		}
		
		for(int i = 1; i <= 2; i++) {
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_DOWN);		//Will press Down Arrow Key
		}
		
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_TAB);

		for(int i = 1; i <= 9; i++) {
			Thread.sleep(500);
			rbt.keyPress(KeyEvent.VK_DOWN);		//Will press Down Arrow Key
		}
		
		Thread.sleep(500);
		rbt.keyPress(KeyEvent.VK_ENTER);
	}

}
