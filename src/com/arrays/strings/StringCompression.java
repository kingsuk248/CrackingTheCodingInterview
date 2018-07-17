package com.arrays.strings;

import java.util.Scanner;

public class StringCompression {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		scanner.close();
		System.out.println("Input: " + str + " Output: " + compress(str));
	}

	private static String compress(String str) {
		char charVal = str.charAt(0);
		int count = 1;
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(charVal);
		for (int i = 1; i < str.length(); i++) {
			if (charVal == str.charAt(i)) {
				count++;
			} else {
				strBuilder.append(count);
				charVal = str.charAt(i);
				strBuilder.append(charVal);
				count = 1;
			}
			if (i == str.length() - 1) {
				strBuilder.append(count);
			}
		}
		return strBuilder.toString();
	}
}
