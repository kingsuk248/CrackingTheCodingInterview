package com.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	private static List<String> lines;

	public FileUtil() {
		try {
			String pathname = "testcaseinput";
			ClassLoader classLoader = FileUtil.class.getClassLoader();
			File file = new File(classLoader.getResource(pathname).getFile());
			readAllLines(file.getPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Reads all lines from a text file
	private void readAllLines(String pathname) throws IOException {
		lines = Files.readAllLines(Paths.get(pathname));
	}

	// Return 'n' integers from test case index 'i'
	public int[] getIntegers(int n, int i) {
		int[] intArray = new int[n];
		String[] line = lines.get(i).split(" ");
		for (int index = 0; index < n; index++) {
			intArray[index] = Integer.valueOf(line[index]);
		}
		return intArray;
	}

	// Return 'n' characters from test case index 'i'
	public int[] getCharacters(int n, int i) {
		int[] intArray = new int[n];
		String[] line = lines.get(i).split(" ");
		for (int index = 0; index < n; index++) {
			intArray[index] = line[index].charAt(0);
		}
		return intArray;
	}
}
