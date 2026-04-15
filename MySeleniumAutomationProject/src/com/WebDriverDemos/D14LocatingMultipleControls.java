package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D14LocatingMultipleControls {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.echotrak.com/Login.aspx?ReturnUrl=%2f");
		
		//List<WebElement>textBoxes =  driver.findElements(By.className("form-control"));
		//List<WebElement>textBoxes = driver.findElements(By.cssSelector("input[class='form-control']"));
		List<WebElement>textBoxes = driver.findElements(By.xpath("html/body/div/div/div[2]/div/div[2]/div/div/div/div/form/fieldset/div[2]/fieldset/input"));
		System.out.println("Total elements: " + textBoxes.size());
		
		textBoxes.get(0).sendKeys("sanjeevani");
		textBoxes.get(1).sendKeys("sanjeevani");
	}

}
