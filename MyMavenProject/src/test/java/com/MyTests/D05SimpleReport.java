package com.MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class D05SimpleReport {

	/*
	 * For using ExtentReport you need to add following Dependency 1. ExtentReports
	 */

	public static void main(String[] args) {
		ExtentSparkReporter htmlFile = new ExtentSparkReporter("SimpleReport.html");
		// Represents the report file
		ExtentReports report = new ExtentReports();
		// Represents the report
		ExtentTest test;
		// Represents the test case
		WebDriver driver;

		report.attachReporter(htmlFile);
		// Attaching the report with html file

		// Add Environment details to project
		report.setSystemInfo("Project Name", "Google");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("User Name", "Dilshad");
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("Processor", "I5");

		// Configuration for look and feel of report
		htmlFile.config().setDocumentTitle("First Extent Report");
		htmlFile.config().setReportName("Google Test Report");
		htmlFile.config().setTheme(Theme.STANDARD);
		htmlFile.config().setTimeStampFormat("dd-MMM-yyyy");

		// Create the test
		test = report.createTest("Google Title Test");

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());

		driver.close();

		test.log(Status.PASS, MarkupHelper.createLabel("Google Title", ExtentColor.GREEN));

		//Create another test
		
		test = report.createTest("Google Search Test");

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Maven", Keys.ENTER);

		driver.close();
		
		test.log(Status.FAIL, MarkupHelper.createLabel("Google Search", ExtentColor.RED));

		report.flush(); // This method will generate the report file
	}

}
