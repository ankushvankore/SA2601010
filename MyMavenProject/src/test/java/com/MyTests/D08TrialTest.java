package com.MyTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class D08TrialTest {
	@Test(dataProvider = "getData")
	public void test(String f) {
		System.out.println("Test");
	}

	@DataProvider
	public String[][] getData() {
		String[][] data = { { "1" }, { "2" }, { "3" }, { "4" }, { "5" } };
		return data;
	}
}
