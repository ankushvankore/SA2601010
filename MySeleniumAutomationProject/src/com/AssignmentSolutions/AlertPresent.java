package com.AssignmentSolutions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class AlertPresent {

	public static void main(String[] args) {

			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("https://the-internet.herokuapp.com/javascript_alerts");

			//driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

			if(isAlertPresent(driver))
			{
				System.out.println("Alert is displayed");

				Alert alt = driver.switchTo().alert();

				System.out.println("Alert Text: " + alt.getText());

				alt.accept();
			}
			else
			{
				System.out.println("Alert is NOT displayed");
			}

			driver.quit();
		}

		public static boolean isAlertPresent(WebDriver driver)
		{
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

				wait.until(ExpectedConditions.alertIsPresent());

				return true;
			}
			catch (TimeoutException e)
			{
				return false;
			}
		}
	}
