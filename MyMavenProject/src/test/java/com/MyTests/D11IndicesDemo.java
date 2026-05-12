package com.MyTests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class D11IndicesDemo {
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
		System.out.println(n);
		System.out.println(s);
	}

	@DataProvider (indices = {2,3})
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { 1, "a" },
			new Object[] { 2, "b" },
			new Object[] { 3, "c" },
			new Object[] { 4, "d" },
		};
	}
}
