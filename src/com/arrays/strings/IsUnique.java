package com.arrays.strings;

import java.util.Scanner;

public class IsUnique {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.next();
		scanner.close();
		IsUnique app = new IsUnique();
		boolean isUnique = app.go(inputString);
		System.out.println("Is Unique? " + isUnique);
	}

	private boolean go(String inputString) {
		boolean[] intArray = new boolean[255];
		for (char ch : inputString.toCharArray()) {
			int position = (int)ch;
			if (intArray[position] == true) {
				return false;
			} else {
				intArray[position] = true;
			}
		}
		return true;
	}
}
