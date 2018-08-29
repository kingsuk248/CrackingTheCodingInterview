package com.structure.data;

public class Stack {
	private int top;
	private int[] iArray;
	
	public Stack(int size, int top) {
		iArray = new int[size];
		top = -1;
	}
	
	public boolean isFull(){
		return top == (iArray.length - 1);
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void push(int iData) {
		iArray[++top] = iData;
	}
	
	public int pop() {
		return iArray[top--];
	}
}
