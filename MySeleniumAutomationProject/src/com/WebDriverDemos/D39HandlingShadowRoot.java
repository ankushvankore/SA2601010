package com.WebDriverDemos;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D39HandlingShadowRoot {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		//If any one of the control is inside the #shadow-root then 
		//you need to use getShadowRoot() and then read the control
		//You cannot use any other locator than cssSelector to read the controls from #shadow-root
		
		/*
		 * Steps
		 * 1. Read the parent control of #shadow-root store this in SearchContext object
		 * 2. call findElement method via SearchContext object
		 */
		SearchContext ss = driver.findElement(By.id("shadow_host")).getShadowRoot();
		ss.findElement(By.cssSelector("input[type='text']")).sendKeys("Deeksha");
	}

}
