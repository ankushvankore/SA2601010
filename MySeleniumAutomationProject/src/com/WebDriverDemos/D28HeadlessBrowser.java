package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class D28HeadlessBrowser {

	public static void main(String[] args) {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless");

		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.selenium.dev/downloads/");

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		if (title.contains("Downloads"))
			System.out.println("Title verified!!! Test case pass");
		else
			System.out.println("Title not verified!!! Test case fail");

		driver.close();
	}

}
