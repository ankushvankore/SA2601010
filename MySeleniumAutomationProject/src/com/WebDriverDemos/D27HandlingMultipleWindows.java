package com.WebDriverDemos;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D27HandlingMultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.naukri.com/");
		
		driver.findElement(By.xpath("//span[contains(text(), 'Remote')]")).click();
		System.out.println("Title: " + driver.getTitle());
		
		//Read the handles / name of all the windows
		Set<String>windows = driver.getWindowHandles();
		//System.out.println(windows);
		
		Object[]winArray = windows.toArray();
		String homePage = winArray[0].toString();
		String newPage = winArray[1].toString();
		
		//System.out.println(homePage);
		//System.out.println(newPage);
		
		driver.switchTo().window(newPage);
		Thread.sleep(5000);
		System.out.println("Title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"search-result-container\"]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/label/i")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(homePage);
		driver.findElement(By.linkText("Login")).click();
		
		//driver.close();
		driver.quit();
	}

}
