package com.Assignments;

import java.util.Random;

public class RandomNoDemo {

	public static void main(String[] args) {
		//Genarates a random no
		Random rnd = new Random();
		int n = rnd.nextInt(5);		//Will genarate any number randomly in the range of 0 to 4
		System.out.println(n);
	}

}
