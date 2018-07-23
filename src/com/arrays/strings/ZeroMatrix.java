package com.arrays.strings;

import com.util.ScannerUtil;

public class ZeroMatrix {
	public static void main(String[] args) {
		int[][] matrix = ScannerUtil.getMByNMatrix(3, 4);
		ScannerUtil.printMByNMatrix(matrix);
		setZeros(matrix);
		System.out.println("=== Post conversion ===");
		ScannerUtil.printMByNMatrix(matrix);
	}

	private static void setZeros(int[][] matrix) {
		boolean[] rowZeroes = new boolean[matrix.length];
		boolean[] columnZeroes = new boolean[matrix[0].length];
		for (int r = 0; r < rowZeroes.length; r++) {
			for (int c = 0; c < columnZeroes.length; c++) {
				if (matrix[r][c] == 0) {
					rowZeroes[r] = true;
					columnZeroes[c] = true;
				}
			}
		}
		for (int i = 0; i < rowZeroes.length; i++) {
			if (rowZeroes[i]) {
				nullifyRows(matrix, i);
			}
		}
		for (int i = 0; i < columnZeroes.length; i++) {
			if (columnZeroes[i]) {
				nullifyColumns(matrix, i);
			}
		}
	}

	private static void nullifyRows(int[][] matrix, int i) {
		for (int index = 0; index < matrix[0].length; index++) {
			matrix[i][index] = 0;
		}
	}

	private static void nullifyColumns(int[][] matrix, int i) {
		for (int index = 0; index < matrix.length; index++) {
			matrix[index][i] = 0;
		}
	}
}
