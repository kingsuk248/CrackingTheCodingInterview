package com.arrays.strings;

import java.util.Scanner;

public class OneAway {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		scanner.close();
		String str1 = inputStr.split(",")[0];
		String str2 = inputStr.split(",")[1];
		System.out.println(str1 + ", " + str2 + ": " + method1(str1, str2));
	}

	private static boolean method1(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		}
		if (str1.length() == str2.length()) {
			return oneEditReplace(str1, str2);
		}
		if (Math.abs(str1.length() - str2.length()) == 1) {
			return oneEditInsert(str1, str2);
		}
		return false;
	}

	private static boolean oneEditReplace(String str1, String str2) {
		boolean diffFound = false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (diffFound) {
					return false;
				}
				diffFound = true;
			}
		}
		return true;
	}

	private static boolean oneEditInsert(String str1, String str2) {
		int index1 = 0;
		int index2 = 0;
		boolean diffFound = false;
		while (index1 < str1.length() && index2 < str2.length()) {
			if (str1.charAt(index1) != str2.charAt(index2)) {
				if (diffFound) {
					return false;
				}
				diffFound = true;
				if (str1.length() > str2.length()) {
					index1++;
				} else {
					index2++;
				}
			} else {
				index1++;
				index2++;
			}
			
		}
		return true;
	}
}
