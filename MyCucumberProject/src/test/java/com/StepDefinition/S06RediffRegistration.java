package com.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S06RediffRegistration {
	WebDriver driver;
	@Given("Launch rediff registration page")
	public void launch_rediff_registration_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
	}

	@When("Enter the following data")
	public void enter_the_following_data(io.cucumber.datatable.DataTable dataTable) {
		System.out.println(dataTable);
		
		//Convert DataTable to List<List<STring>>
		
		List<List<String>>data = dataTable.asLists();
		System.out.println(data);
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		
		System.out.println(data.get(0).get(0));
		
		driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys(data.get(0).get(0));
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Rediffmail ID\"]")).sendKeys(data.get(0).get(1));
		driver.findElement(By.id("newpasswd")).sendKeys(data.get(0).get(2));
		driver.findElement(By.id("newpasswd1")).sendKeys(data.get(0).get(2));
		new Select(driver.findElement(By.className("day"))).selectByVisibleText(data.get(0).get(3));
		new Select(driver.findElement(By.className("middle"))).selectByVisibleText(data.get(0).get(4));
		new Select(driver.findElement(By.className("year"))).selectByVisibleText(data.get(0).get(5));
		
		if(data.get(0).get(6).equals("Male"))
			driver.findElement(By.xpath("//input[@value=\"m\"]")).click();
		else
			driver.findElement(By.xpath("//input[@value=\"f\"]")).click();
	}

	@Then("Registration process is successful")
	public void registration_process_is_successful() {

	}
}
