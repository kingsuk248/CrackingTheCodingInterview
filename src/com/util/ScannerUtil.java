package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerUtil {

	public static int[][] getMByNMatrix(int m, int n) {
		Scanner scanner = new Scanner(System.in);
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = scanner.nextInt();
			}
			scanner.nextLine();
		}
		scanner.close();
		return matrix;
	}
	
	public static void printMByNMatrix(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				System.out.print(matrix[r][c]);
				if (c < columns) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static String[] getStrings(int n) {
		String[] strArray = new String[n];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			strArray[i] = scanner.next();
		}
		scanner.close();
		return strArray;
	}
	
	public static int[] getIntegers(int n) {
		int[] intArray = new int[n];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}
		scanner.close();
		return intArray;
	}
	
	public static List<int[]> getDoubleLineIntegers(int m, int n) {
		int[] intArray = new int[m];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < m; i++) {
			intArray[i] = scanner.nextInt();
		}
		scanner.nextLine();
		List<int[]> listOfIntegerArray = new ArrayList<>();
		listOfIntegerArray.add(intArray);
		
		intArray = new int[n];
		for (int i = 0; i < n; i++) {
			intArray[i] = scanner.nextInt();
		}
		scanner.close();
		listOfIntegerArray.add(intArray);
		
		return listOfIntegerArray;
	}
	
	public static char[] getChars(int n) {
		char[] charArray = new char[n];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			charArray[i] = scanner.next().charAt(0);
		}
		scanner.close();
		return charArray;
	}
}
