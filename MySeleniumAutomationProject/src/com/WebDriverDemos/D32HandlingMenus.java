package com.WebDriverDemos;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D32HandlingMenus {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("oxd-button")).click();
		
		Thread.sleep(3000);
		
		if(driver.getCurrentUrl().contains("dashboard")) {
			List<WebElement>menus = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']/li/a/span"));
			System.out.println("Total menus: " + menus.size());
			
			for(WebElement m : menus)
				System.out.println(m.getText());
		}
		
		driver.close();
	}

}
