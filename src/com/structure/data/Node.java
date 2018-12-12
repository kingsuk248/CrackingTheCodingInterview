package com.structure.data;

public class Node {
	public int iData;
	Node left;
	Node right;
	
	public Node(int iData) {
		this.iData = iData;
	}
	
	public void display() {
		System.out.print(iData + " ");
	}
}
