package com.MyTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class D06DetailedReport {
	ExtentSparkReporter htmlFile;
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;

	@Test
	public void login1() {
		test = report.createTest("Orange HRM Login1");
		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
		
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/i")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Test
	public void login2() {
		test = report.createTest("Orange HRM Login2");
		
		driver.findElement(By.name("username")).sendKeys("Nishma");
		driver.findElement(By.name("password")).sendKeys("nishma123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("dash"));
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		//ITestResult is an interface which gives you the detailed information about @Test
		if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		}
		else if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.fail(result.getThrowable());
			//getThrowable() will return the failure test log
		}
	}

	@BeforeTest
	public void beforeTest() {
		htmlFile = new ExtentSparkReporter("OrangeHRM_Report.html");
		report = new ExtentReports();
		report.attachReporter(htmlFile);

		// Add Environment details to project
		report.setSystemInfo("Project Name", "Orange HRM");
		report.setSystemInfo("Browser", "Google Chrome");
		report.setSystemInfo("User Name", "Dilshad");
		report.setSystemInfo("Machine Name", "Dell");
		report.setSystemInfo("Processor", "I5");

		// Configuration for look and feel of report
		htmlFile.config().setDocumentTitle("Orange HRM Login Report");
		htmlFile.config().setReportName("Orange HRM Report");
		htmlFile.config().setTheme(Theme.STANDARD);
		htmlFile.config().setTimeStampFormat("dd-MMM-yyyy");
		
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.close();
		report.flush();
	}

}
