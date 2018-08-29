package com.structure.data;

import java.util.ArrayList;
import java.util.List;

public class StackUnbound {
	private int top;
	private List<Integer> iList;
	
	public StackUnbound() {
		top = -1;
		iList = new ArrayList<Integer>();
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public void push(int iData) {
		iList.add(iData);
		top++;
	}
	
	public int pop() {
		if (top == -1) {
			System.out.println("Stack is Empty. Exception ahead !!!");
		}
		return iList.get(top--);
	}
}
