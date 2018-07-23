package com.arrays.strings;

import com.util.ScannerUtil;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = ScannerUtil.getMByNMatrix(4, 4);
		rotate(matrix);
		ScannerUtil.printMByNMatrix(matrix);
	}
	
	private static void rotate(int[][] matrix) {
		int n = matrix.length;
		
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n - 1 - layer;
			
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = matrix[layer][i];
				// left to top
				matrix[layer][i] = matrix[last - offset][first];
				
				// bottom to left
				matrix[last - offset][i] = matrix[last][last - offset];
				
				// right to bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top to right
				matrix[i][last] = top;
			}
		}
	}
	
}
