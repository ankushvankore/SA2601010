package com.MyTests;

import org.testng.annotations.Test;

public class D09InvocationCountDemo {

	@Test (invocationCount = 5)
	public void test() {
		System.out.println("Test executed...");
	}
}
