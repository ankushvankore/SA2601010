package com.WebDriverDemos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D19HandlingListBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://omayo.blogspot.com/");

		// WebElement lstBox = driver.findElement(By.id("multiselect1"));
		// Select cars = new Select(lstBox);
		Select cars = new Select(driver.findElement(By.id("multiselect1")));

		List<WebElement> allCars = cars.getOptions();
		System.out.println("----------- All Cars ------------");
		for (WebElement c : allCars)
			System.out.println(c.getText());

		if (cars.isMultiple()) {
			cars.selectByIndex(1);
			cars.selectByIndex(3);

			List<WebElement> selectedCars = cars.getAllSelectedOptions();
			System.out.println("---------- Selected Cars -----------");
			for (WebElement c : selectedCars)
				System.out.println(c.getText());
		}
		
		//cars.deselectByIndex(1);
		//cars.deselectByVisibleText("Swift");
		//cars.deSelectByContainsVisibleText("Swi");
		//cars.deselectByValue("swiftx");
		cars.deselectAll();
	}

}
