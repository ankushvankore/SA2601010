package com.MyTests;

import org.testng.annotations.Test;

public class D12InvocationTimeoutDemo {

	@Test (invocationTimeOut = 3000)
	public void test() throws InterruptedException {
		System.out.println("Test started...");
		
		Thread.sleep(4000);
		
		System.out.println("Test ends...");
	}
}
