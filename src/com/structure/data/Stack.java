package com.structure.data;

public class Stack {
	private int top;
	private int topCharStack;
	private int[] iArray;
	private char[] cArray;
	
	public Stack(int size) {
		iArray = new int[size];
		cArray = new char[size];
		top = -1;
		topCharStack = -1;
	}
	
	/** Integer array specific implementations **/
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
	
	public int peek() {
		return iArray[top];
	}
	
	/** Character array specific implementations **/
	public boolean isFullCharStack(){
		return topCharStack == (cArray.length - 1);
	}
	
	public boolean isEmptyCharStack(){
		return topCharStack == -1;
	}
	
	public void pushCharStack(char cData) {
		cArray[++topCharStack] = cData;
	}
	
	public int popCharStack() {
		return cArray[topCharStack--];
	}
}
