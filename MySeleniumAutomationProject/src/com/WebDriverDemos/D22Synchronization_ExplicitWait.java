package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class D22Synchronization_ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://omayo.blogspot.com/");
		
		//ExplicitWait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement cbox = driver.findElement(By.id("dte"));
		
		System.out.println("Before");
		System.out.println("Enabled : " + cbox.isEnabled());
		System.out.println("Selected: " + cbox.isSelected());
		
		driver.findElement(By.xpath("//*[@id=\"HTML47\"]/div[1]/button")).click();
		
		//wait.until(ExpectedConditions.elementToBeClickable(cbox));
		//cbox.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(cbox)).click();
		//ExpectedConditions --> here we can put the condition for wait
		
		System.out.println("After");
		System.out.println("Enabled : " + cbox.isEnabled());
		System.out.println("Selected: " + cbox.isSelected());
	}

}
