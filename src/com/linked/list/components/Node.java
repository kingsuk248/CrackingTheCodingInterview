package com.linked.list.components;

/**
 * 
 * Node that populates integer data
 * 
 */
public class Node {
	public int iData;
	public char cData;
	public Node next;
	
	public Node() {}
	
	public Node(int iData, Node next) {
		this.iData = iData;
		this.next = next;
	}
	
	public Node clone(Node node) {
		Node newNode = new Node();
		newNode.iData = node.iData;
		newNode.cData = node.cData;
		return newNode;
	}
}
