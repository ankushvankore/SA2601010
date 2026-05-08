package com.StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S05JQuaryTest {
	WebDriver driver;
	
	//@Before
	public void setup() {
		System.out.println("Before hook getting executed");
	}
	
	//@After
	public void closeBrowser() {
		System.out.println("After hook getting executed");
		driver.close();
	}
	
	@Given("Open JQuery Site")
	public void open_j_query_site() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	    driver.get("https://jqueryui.com/");
	}

	@When("Click on Draggable Link")
	public void click_on_draggable_link() {
	    driver.findElement(By.partialLinkText("Drag")).click();
	}

	@Then("Draggable page should open")
	public void draggable_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Drag"));
	}

	@When("Click on Droppable Link")
	public void click_on_droppable_link() {
	    driver.findElement(By.partialLinkText("Drop")).click();
	}

	@Then("Droppable page should open")
	public void droppable_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Drop"));
	}

	@When("Click on Resizable Link")
	public void click_on_resizable_link() {
		driver.findElement(By.partialLinkText("Resiz")).click();
	}

	@Then("Resizable page should open")
	public void resizable_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Resiz"));
	}

	@When("Click on Selectable Link")
	public void click_on_selectable_link() {
	    driver.findElement(By.partialLinkText("Select")).click();
	}

	@Then("Selectable page should open")
	public void selectable_page_should_open() {
		Assert.assertTrue(driver.getTitle().contains("Select"));
	}
}
