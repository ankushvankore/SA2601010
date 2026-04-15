package com.WebDriverDemos;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D15LocateByTagName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com");
		
		List<WebElement>allLinks = driver.findElements(By.tagName("a"));	
		System.out.println("Total Links: " + allLinks.size());
		
		/*System.out.println("Text: " + allLinks.get(0).getText());
		System.out.println("href: " + allLinks.get(0).getAttribute("href"));
		System.out.println("Text: " + allLinks.get(1).getText());
		System.out.println("href: " + allLinks.get(1).getAttribute("href"));*/
		
		/*for(int i = 0; i < allLinks.size(); i++) {
			System.out.println("Text: " + allLinks.get(i).getText());
			System.out.println("href: " + allLinks.get(i).getAttribute("href"));
		}*/
		
		for(WebElement link : allLinks) {
			System.out.println("Text: " + link.getText());
			System.out.println("href: " + link.getAttribute("href"));
		}
		
		driver.close();
	}

}
