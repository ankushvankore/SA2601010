package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D11LocateByCssSelector_SpeacialCharacters {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//^ - Starts with
		driver.findElement(By.cssSelector("input[name^='name']")).sendKeys("Dilshad Jabeen M");
		driver.findElement(By.cssSelector("input[id^='login']")).sendKeys("dilshadj");
		
		//$ - Ends With
		driver.findElement(By.cssSelector("input[onblur$='(this);'][placeholder=\"Enter password\"]")).sendKeys("dilshad");
		
		//* - Contains
		driver.findElement(By.cssSelector("input[placeholder*='type']")).sendKeys("dilshad");
	}

}
