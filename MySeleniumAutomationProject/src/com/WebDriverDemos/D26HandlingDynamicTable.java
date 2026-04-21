package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D26HandlingDynamicTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/?m=1");
		
		//Find the index of CPU column
		List<WebElement>headers = driver.findElements(By.xpath("//tr[@id='headers']/th"));
		int hIndex = 1;
		for(WebElement h : headers) {
			if(h.getText().contains("CPU"))
				break;
			hIndex++;
		}
		System.out.println("Header Index of CPU: " + hIndex);
		
		//Find the index of Chrome row
		List<WebElement>rows = driver.findElements(By.xpath("//tbody[@id='rows']/tr/td[1]"));
		int rIndex = 1;
		for(WebElement r : rows) {
			if(r.getText().contains("Chrome"))
				break;
			rIndex++;
		}
		System.out.println("Row Index of Chrome: " + rIndex);
		
		////*[@id="rows"]/tr[3]/td[5]
		//3 Is row index 5 is column index
		
		String actValue = driver.findElement(By.xpath("//*[@id=\"rows\"]/tr["+rIndex+"]/td["+hIndex+"]")).getText();
		System.out.println("Value of CPU: Chrome: " + actValue);
		
		String expValue = driver.findElement(By.xpath("//*[@id=\"displayValues\"]/p[1]/strong")).getText();
		
		if(expValue.equals(actValue))
			System.out.println("Both values are same\nTest Case Pass!!!");
		else
			System.out.println("Both values are not same\nTest Case Fail!!!");
		
		driver.close();
	}

}
