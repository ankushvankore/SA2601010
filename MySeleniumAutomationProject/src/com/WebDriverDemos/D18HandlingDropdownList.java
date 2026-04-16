package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D18HandlingDropdownList {
	
	/*
	 * Handling Country Dropdown list
	 * 1. Display selected country
	 * 2. Display total no of countries
	 * 3. Display all countries
	 * 4. Select Denmark
	 * 5. Display selected country
	 */

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//Read the drop down list
		WebElement drpList = driver.findElement(By.id("country"));
		//Create object of Select class and pass this control to this object
		Select countries = new Select(drpList);
		//Now all the operations on drop down list can be performed only via this countries object
		
		System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());
		List<WebElement>allCountries = countries.getOptions();
		
		System.out.println("Total countries: " + allCountries.size());

		/*int i = 0;
		for(WebElement c : allCountries) {
			System.out.println(i + ". " + c.getText());
			i++;
		}*/
		
		//countries.selectByVisibleText("Denmark");
		//countries.selectByContainsVisibleText("Den");
		//countries.selectByValue("59");
		countries.selectByIndex(57);
		System.out.println("Selected Country: " + countries.getFirstSelectedOption().getText());
	}

}
