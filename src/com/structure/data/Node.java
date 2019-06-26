package com.structure.data;

public class Node {
	public int iData;
	public Node left;
	public Node right;
	public Node parent;
	
	public Node(int iData) {
		this.iData = iData;
	}
	
	public void display() {
		System.out.print(iData + " ");
	}
}
