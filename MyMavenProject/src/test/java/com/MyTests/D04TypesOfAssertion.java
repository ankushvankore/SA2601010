package com.MyTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class D04TypesOfAssertion {
	@Test
	public void test1() {
		System.out.println("Test 1 Started");
		
		Assert.assertTrue(false);
		
		System.out.println("Test 1 Complete");
	}
	
	@Test
	public void test2() {
		SoftAssert s1 = new SoftAssert();
		System.out.println("Test 2 Started");
		
		s1.assertTrue(false);
		
		System.out.println("Test 2 Complete");
		s1.assertAll();
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3 Started");
		System.out.println("Test 3 Complete");
	}
}
