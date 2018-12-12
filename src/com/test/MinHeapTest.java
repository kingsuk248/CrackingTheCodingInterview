package com.test;

import com.structure.data.MinHeap;
import com.structure.data.Node;

public class MinHeapTest {
	public static void main(String[] args) throws InterruptedException {
		MinHeap minHeap = new MinHeap(15);
		int[] inputArray = new int[]{5, 7, 8, 9, 12, 10, 2, 11, 15, 3, 20, 6, 4, 14, 1};
		for (int i = 0; i < 15; i++) {
			minHeap.insert(inputArray[i]);
			minHeap.printHeapArray();
		}
		for (int i = 0; i < 15; i++) {
			Node delNode = minHeap.remove();
			System.out.print("Removed: " + delNode.iData + " ");
			System.out.print("Heap now ===> ");
			minHeap.printHeapArray();
			Thread.sleep(1000);
		}
	}
}
