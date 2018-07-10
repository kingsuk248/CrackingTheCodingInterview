package com.arrays.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PalindromePermutation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();
		System.out.println("Is permutation of palindrome? " + method1(str));
		System.out.println("Is permutation of palindrome? " + method2(str));
	}

	private static boolean method1(String str) {
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (ch != ' ') {
				if (map.get(ch) == null)
					map.put(ch, 1);
				else
					map.put(ch, map.get(ch) + 1);
			}
		}
		int oddCounter = 0;
		for (int i : map.values()) {
			if (i % 2 == 0) {
				continue;
			} else {
				oddCounter++;
				if (oddCounter > 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean method2(String str) {
		int bitVector = 0;
		for (char ch : str.toCharArray()) {
			int charVal = getCharacterValue(ch);
			bitVector = toggleBits(bitVector, charVal);
		}
		return checkSingleOnBit(bitVector);
	}

	private static int getCharacterValue(char ch) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		int c = Character.getNumericValue(ch);
		if (c >= a && c <= z) {
			return c - a;
		} else if (c >= A && c <= Z) {
			return c - A;
		}
		return -1;
	}

	private static int toggleBits(int bitVector, int charVal) {
		int mask = 1 << charVal;
		if ((bitVector & mask) == 0) {
			bitVector |= mask;
		} else {
			bitVector &= ~mask;
		}
		return bitVector;
	}
	
	private static boolean checkSingleOnBit(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}
}
