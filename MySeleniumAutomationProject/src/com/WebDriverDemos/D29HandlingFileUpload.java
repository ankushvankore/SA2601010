package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D29HandlingFileUpload {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demoqa.com/automation-practice-form");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.id("firstName")).sendKeys("Akansha");
		driver.findElement(By.id("lastName")).sendKeys("Soni");
		driver.findElement(By.id("userEmail")).sendKeys("akansha@gmail.com");
		driver.findElement(By.id("gender-radio-2")).click();
		driver.findElement(By.id("userNumber")).sendKeys("9898989898");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.CONTROL + "A");
		driver.findElement(By.id("dateOfBirthInput")).sendKeys("29 Sep 2000", Keys.ENTER);
		
		//Javascript method to scroll window.scrollBy(hScroll, vScroll)
		
		js.executeScript("window.scrollBy(0, 200)", "");
		
		driver.findElement(By.id("hobbies-checkbox-1")).click();
		
		//driver.findElement(By.id("uploadPicture")).sendKeys("D:\\StarAgile\\Demos\\SA2601010_08Apr\\Assignment_SA2601010.docx");
		WebElement fileUpload = driver.findElement(By.id("uploadPicture"));
		fileUpload.sendKeys("D:\\StarAgile\\Demos\\SA2601010_08Apr\\Assignment_SA2601010.docx");
		
		//Javascript method to highlight a control --> control.style.border='3px solid red'"
		js.executeScript("arguments[0].style.border='3px solid red'", fileUpload);
	}

}
