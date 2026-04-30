package com.TestNGDemos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RediffUtility {
	WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[2]/div[2]/form/div/div[2]/input")WebElement fullName;
	@FindBy(css = "input[name^='login']")WebElement rediffId;
	@FindBy(id = "newpasswd")WebElement password;
	@FindBy(id = "newpasswd1")WebElement newPassword;
	@FindBy(className = "day")WebElement dayDD;
	@FindBy(className = "middle")WebElement monthDD;
	@FindBy(className = "year")WebElement yearDD;
	@FindBy(className = "btn_checkavail")WebElement chkAvl;
	
	
	public RediffUtility(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	public void setFullName(String fn) {
		//driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys(fn);
		fullName.sendKeys(fn);
	}
	
	public void setRediffId(String rid) {
		//driver.findElement(By.cssSelector("input[name^='login']")).sendKeys(rid);
		rediffId.sendKeys(rid);
	}
	
	public void setPassword(String ps) {
		//driver.findElement(By.id("newpasswd")).sendKeys(ps);
		//driver.findElement(By.id("newpasswd1")).sendKeys(ps);
		password.sendKeys(ps);
		newPassword.sendKeys(ps);
	}
	
	public void setBirthDate(String day, String month, String year) {
		//new Select(driver.findElement(By.className("day"))).selectByVisibleText(day);
		//new Select(driver.findElement(By.className("middle"))).selectByVisibleText(month);
		//new Select(driver.findElement(By.className("year"))).selectByVisibleText(year);
		
		new Select(dayDD).selectByVisibleText(day);
		new Select(monthDD).selectByVisibleText(month);
		new Select(yearDD).selectByVisibleText(year);
	}
	
	public String checkAvailablity() throws InterruptedException {
		//driver.findElement(By.className("btn_checkavail")).click();
		chkAvl.click();
		Thread.sleep(2000);
		String msg = driver.findElement(By.id("check_availability")).getText();
		System.out.println("Message: " + msg);
		
		return msg;
	}
}
