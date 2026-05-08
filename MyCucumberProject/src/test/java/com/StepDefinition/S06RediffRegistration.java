package com.StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S06RediffRegistration {
	@Given("Launch rediff registration page")
	public void launch_rediff_registration_page() {
	    
	}

	@When("Enter the following data")
	public void enter_the_following_data(io.cucumber.datatable.DataTable dataTable) {
	 System.out.println(dataTable);   
	}

	@Then("Registration process is successful")
	public void registration_process_is_successful() {
	    
	}
}
