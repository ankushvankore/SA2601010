package com.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class A29W3SchoolName {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		
		//As the control is inside the iframe you need to switch to the frame
		//driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.name("iframeResult")));
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe[@allowfullscreen='true'])[1]")));
		
		driver.findElement(By.id("fname")).sendKeys("Priyanka");
		
		driver.switchTo().parentFrame();
		//This will exit / close the frame
	}

}
