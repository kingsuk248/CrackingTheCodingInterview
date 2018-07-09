package com.arrays.strings;

import java.util.Scanner;

public class URLify {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		scanner.close();
		String[] strArr = inputString.split(",");
		go(strArr[0], Integer.valueOf(strArr[1]));
	}
	
	public static void go(String str, int n) {
		char[] chars = str.toCharArray();
		int blankCount = 0;
		for (int i = 0; i < n; i++) {
			if (chars[i] == ' ') {
				blankCount++;
			}
		}
		char[] newChars = new char[n + (blankCount * 2)];
		int newCharPtr = newChars.length - 1;
		for (int i = 0; i < n; i++) {
			if (chars[n - 1 - i] == ' ') {
				newChars[newCharPtr--] = '0';
				newChars[newCharPtr--] = '2';
				newChars[newCharPtr--] = '%';
			} else {
				newChars[newCharPtr--] = chars[n - 1 - i];
			}
		}
		System.out.println(newChars);
	}
}
