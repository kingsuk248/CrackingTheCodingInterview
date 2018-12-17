package com.structure.data;

import java.util.EmptyStackException;

public class Queue {
	private int front;
	private int rear;
	private int[] iArray;
	private int maxSize;
	private int numItems;

	public Queue(int size) {
		iArray = new int[size];
		this.maxSize = size;
		this.front = 0;
		this.rear = -1;
	}

	public void insert(int iData) {
		if (numItems == maxSize) {
			// No more space to insert
			return;
		} else {
			if (rear == maxSize -1) {
				// Deal with wrap-around
				rear = -1;
			}
			iArray[++rear] = iData;
			numItems++;
		}
	}

	public int remove() {
		if (numItems == 0) {
			throw new EmptyStackException();
		} else {
			int retVal = iArray[front++];
			if (front == maxSize) {
				// Deal with wrap-around
				front = 0;
			}
			numItems--;
			return retVal;
		}
	}

	public int peekFront() {
		return iArray[front];
	}

	public int peekRear() {
		return iArray[rear];
	}

	public boolean isEmpty() {
		return numItems == 0;
	}

	public boolean isFull() {
		return (numItems == maxSize);
	}
	
	public void displayQueue() {
		System.out.print("Front: " + iArray[front]);
		System.out.println("  Rear: " + iArray[rear]);
		System.out.print("Queue ==> ");
		for (int i = 0, frontPtr = front; i < numItems; i++, frontPtr++) {
			if (frontPtr == maxSize) {
				frontPtr = 0;
			}
			System.out.print(iArray[frontPtr] + " ");
		}
		System.out.println();
	}
}
