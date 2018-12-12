package com.structure.data;

public class MinHeap {
	private Node[] heapArray;
	private int currentSize;

	public MinHeap(int maxSize) {
		heapArray = new Node[maxSize];
	}

	public void insert(int iData) {
		Node newNode = new Node(iData);
		heapArray[currentSize] = newNode;
		tickleUp(currentSize++);
	}

	private void tickleUp(int index) {
		int parent = (index - 1) / 2;
		Node newNode = heapArray[index];
		while (index > 0 && heapArray[parent].iData > newNode.iData) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (index - 1) / 2;
		}
		heapArray[index] = newNode;
	}

	public Node remove() {
		Node delNode = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickleDown(0);
		return delNode;
	}

	private void trickleDown(int index) {
		Node delNode = heapArray[index];
		int smallerChild;
		while (index < currentSize/2) {
			int left = index * 2 + 1;
			int right = left + 1;
			
			if (right < currentSize && heapArray[left].iData < heapArray[right].iData) {
				smallerChild = left;
			} else {
				smallerChild = right;
			}
			if (delNode.iData <= heapArray[smallerChild].iData) {
				break;
			}
			heapArray[index] = heapArray[smallerChild];
			index = smallerChild;
		}
		heapArray[index] = delNode;
	}

	public void printHeapArray() {
		for (int i = 0; i < currentSize; i++) {
			System.out.print(heapArray[i].iData + " ");
		}
		System.out.println();
	}
}
