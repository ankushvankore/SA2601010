package com.MyTests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D13ReadFromCSV {

	public static void main(String[] args) {
		// Open CSV
		// https://mvnrepository.com/artifact/org.apache.commons/commons-csv

		String path = "C:\\Users\\Dell\\Desktop\\Friends.csv";
		String line = "";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				String[] values = line.split(","); // split by comma
				System.out.println("Col1: " + values[0] + " | Col2: " + values[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

}
