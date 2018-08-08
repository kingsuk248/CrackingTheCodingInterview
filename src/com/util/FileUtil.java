package com.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {

	private static List<String> lines;

	private FileUtil(String pathname) {
		try {
			readAllLines(pathname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads all lines from a text file
	private void readAllLines(String pathname) throws IOException {
		lines = Files.readAllLines(Paths.get(pathname));
	}

	// Return 'n' integers from test case index 'i'
	public static int[] getIntegers(int n, int i) {
		int[] intArray = new int[n];
		String[] line = lines.get(i).split(" ");
		for (int index = 0; index < n; index++) {
			intArray[index] = Integer.valueOf(line[index]);
		}
		return intArray;
	}

	// Return 'n' characters from test case index 'i'
	public static int[] getCharacters(int n, int i) {
		int[] intArray = new int[n];
		String[] line = lines.get(i).split(" ");
		for (int index = 0; index < n; index++) {
			intArray[index] = line[index].charAt(0);
		}
		return intArray;
	}
}
