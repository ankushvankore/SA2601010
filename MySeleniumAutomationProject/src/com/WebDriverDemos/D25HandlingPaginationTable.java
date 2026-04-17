package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D25HandlingPaginationTable {
	
	/*
	 * 1. Display total no of pages
	 * 2. Open each page
	 * 3. Display each row from each page
	 * 4. Click on Checkbox on each row
	 */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		List<WebElement>pages = driver.findElements(By.xpath("//ul[@id='pagination']/li/a"));
		System.out.println("Total pages from this table: " + pages.size());
		
		for(WebElement p : pages) {
			p.click();
			Thread.sleep(2000);
			
			List<WebElement>rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));
			for(WebElement r : rows)
				System.out.println(r.getText());
			
			List<WebElement>cBoxes = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[4]/input"));
			for(WebElement c : cBoxes)
				c.click();
		}
		
		driver.close();
	}
}
