package com.WebDriverDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class D10LocateByCssSelector_Attributes {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");

		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[class=\"input_error form_input\"][type=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[class=\"submit-button btn_action\"]")).click();
		
		//Logout
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		
	}

}
