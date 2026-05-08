package com.StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class S04AutomobileTest {
	WebDriver driver;
	@Given("Launch Tricentis Insurance Application")
	public void launch_tricentis_insurance_application() {
		//System.setProperty("webdriver.chrome.driver", "path of chromedriver.exe file");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://sampleapp.tricentis.com/101/index.php");
	}

	@When("Click on Automobile link")
	public void click_on_automobile_link() {
	    driver.findElement(By.partialLinkText("Auto")).click();
	}

	@When("Select make as {string}")
	public void select_make_as(String vmake) {
	    new Select(driver.findElement(By.id("make"))).selectByVisibleText(vmake);
	}

	@When("Enter engine performance as {string}")
	public void enter_engine_performance_as(String ep) {
	    driver.findElement(By.id("engineperformance")).sendKeys(ep);
	}

	@When("Enter date of manifacture as {string}")
	public void enter_date_of_manifacture_as(String dom) {
		driver.findElement(By.id("dateofmanufacture")).sendKeys(dom);
	}

	@When("Select no of seats as {string}")
	public void select_no_of_seats_as(String no) {
		new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText(no);
	}

	@When("Select Fuel type as {string}")
	public void select_fuel_type_as(String fType) {
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText(fType);
	}

	@When("Enter List price as {string}")
	public void enter_list_price_as(String price) {
		driver.findElement(By.id("listprice")).sendKeys(price);
	}

	@When("Enter Licence plate no as {string}")
	public void enter_licence_plate_no_as(String lNo) {
	    driver.findElement(By.id("licenseplatenumber")).sendKeys(lNo);
	}

	@When("Enter annual milage as {string}")
	public void enter_annual_milage_as(String milage) {
	    driver.findElement(By.id("annualmileage")).sendKeys(milage);
	}

}
