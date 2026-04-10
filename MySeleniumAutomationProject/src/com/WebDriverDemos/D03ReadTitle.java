package com.WebDriverDemos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D03ReadTitle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/downloads/");
		
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		/*if(title.equals("Downloads | Selenium"))
			System.out.println("Title verified!!! Test case pass");
		else
			System.out.println("Title not verified!!! Test case fail");
		*/
		
		if(title.contains("Downloads"))	
			System.out.println("Title verified!!! Test case pass");
		else
			System.out.println("Title not verified!!! Test case fail");
		
		driver.close();
	}

}
