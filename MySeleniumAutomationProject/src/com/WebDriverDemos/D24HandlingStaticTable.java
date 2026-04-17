package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D24HandlingStaticTable {

	/*
	 * 1. Display all table headers
	 * 2. Display total no of rows
	 * 3. Display any row randomly
	 */
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		List<WebElement>headers = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr/th"));
		System.out.println("---------- All Headers -----------");
		for(WebElement h : headers)
			System.out.println(h.getText());
		
		List<WebElement>rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr"));
		System.out.println("Total Rows: " + rows.size());
		
		Random rnd = new Random();
		int n = rnd.nextInt(7);
		
		System.out.println(rows.get(n).getText());
		System.out.println(driver.findElement(By.xpath("//table[@name=\"BookTable\"]/tbody/tr["+(n+1)+"]")).getText());
		
		driver.close();
	}

}
