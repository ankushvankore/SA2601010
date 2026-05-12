package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F07DataDrivenTesting.feature",
					glue = "com.StepDefinition")
public class R07DataDrivenTesting {

}
