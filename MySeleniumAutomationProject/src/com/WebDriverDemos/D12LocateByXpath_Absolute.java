package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D12LocateByXpath_Absolute {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys("Gopika Nair");
		driver.findElement(By.xpath("html/body/div[2]/div[2]/form/div/div[3]/div/input")).sendKeys("gopikan");
	}

}
