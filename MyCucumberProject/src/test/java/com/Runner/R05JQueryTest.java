package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/MyCucumberProject/MyCucumberProject/F05JQueryTest.feature",
					glue = "com.StepDefinition",
					tags = "@AllLinks",
					publish = true)
public class R05JQueryTest {
	/*
	 * Execute Single Scenario:			tags = "@DroppableTest"
	 * Execute Multiple Scenarios:		tags = "@DroppableTest or @SelectableTest"
	 * Skip Single Scenario:			tags = "not @SelectableTest"
	 * Skip Multiple Scenarios:			tags = "not @DraggableTest and not @ResizableTest"
	 * Execute All Scenarios:			tags = "@AllLinks"
	 */

}
