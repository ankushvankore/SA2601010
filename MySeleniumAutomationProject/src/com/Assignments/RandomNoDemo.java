package com.Assignments;

import java.util.Random;

public class RandomNoDemo {

	public static void main(String[] args) {
		//Generates a random no
		Random rnd = new Random();
		int n = rnd.nextInt(5);		//Will generate any number randomly in the range of 0 to 4
		System.out.println(n);
		
		//Random number we have generated is 5 with Random Class
		String str = "Random number we have generated is "+n+" with Random Class";
		System.out.println(str);
	}

}
