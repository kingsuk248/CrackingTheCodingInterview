package com.arrays.strings;

import com.util.ScannerUtil;

public class StringRotation {
	public static void main(String[] args) {
		String[] strArray = ScannerUtil.getStrings(2);
		System.out.println("Are rotated versions? " + execute(strArray[0], strArray[1]));
	}

	private static boolean execute(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if (len1 == len2) {
			String str3 = str1 + str1;
			return (str3.indexOf(str2) != -1);
		}
		return false;
	}
}
