package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RediffUtility {
	WebDriver driver;
	
	public RediffUtility(WebDriver d) {
		this.driver = d;
	}
	
	public void setFullName(String fn) {
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys(fn);
	}
	
	public void setRediffId(String rid) {
		driver.findElement(By.cssSelector("input[name^='login']")).sendKeys(rid);
	}
	
	public void setPassword(String ps) {
		driver.findElement(By.id("newpasswd")).sendKeys(ps);
		driver.findElement(By.id("newpasswd1")).sendKeys(ps);
	}
	
	public void setBirthDate(String day, String month, String year) {
		new Select(driver.findElement(By.className("day"))).selectByVisibleText(day);
		new Select(driver.findElement(By.className("middle"))).selectByVisibleText(month);
		new Select(driver.findElement(By.className("year"))).selectByVisibleText(year);
	}
}
