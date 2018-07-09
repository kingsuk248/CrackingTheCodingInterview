package com.arrays.strings;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.next();
		String str2 = scanner.next();
		scanner.close();
		System.out.println("Are permutation? " + method1(str1, str2));
		System.out.println("Are permutation? " + method2(str1, str2));
	}
	
	public static boolean method1(String str1, String str2) {
		char[] str1Chars = str1.toCharArray();
		char[] str2Chars = str2.toCharArray();
		Arrays.sort(str1Chars);
		Arrays.sort(str2Chars);
		String sortedStr1 = new String(str1Chars);
		String sortedStr2 = new String(str2Chars);
		return sortedStr1.equals(sortedStr2);
	}
	
	public static boolean method2(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] arr = new int[128];
		for (char ch : str1.toCharArray()) {
			arr[ch]++;
		}
		for (char ch : str2.toCharArray()) {
			arr[ch]--;
			if (arr[ch] < 0) {
				return false;
			}
		}
		return true;
	}
}
