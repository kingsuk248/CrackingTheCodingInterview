package com.util;

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
}
