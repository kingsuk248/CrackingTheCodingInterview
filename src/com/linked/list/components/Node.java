package com.linked.list.components;

/**
 * 
 * Node that populates integer data
 * 
 */
public class Node {
	public int iData;
	public Node next;
	
	public Node() {}
	
	public Node(int iData, Node next) {
		this.iData = iData;
		this.next = next;
	}
}
