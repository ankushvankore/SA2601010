package com.MyTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListners implements ITestListener {
	public void onStart(ITestContext result) {
		System.out.println("Class started");
	}

	public void onFinish(ITestContext result) {
		System.out.println("All tests ends!!!");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("This test: " + result.getName() + " is failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("This test: " + result.getName() + " is skipped");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started: " + result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("This test: " + result.getName() + " is passed");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}
}
