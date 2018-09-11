package com.linked.list.components;

public class SinglyLinkedList {
	public static Node head;

	public static Node insertElements(int data) {
		Node newNode = new Node();
		newNode.iData = data;
		if (head == null) {
			head = newNode;
			return head;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return head;
	}
	
	public static Node insertCharacterElements(char data) {
		Node newNode = new Node();
		newNode.cData = data;
		if (head == null) {
			head = newNode;
			return head;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return head;
	}
	
	public Node insertElementsForListInstance(Node head, int data) {
		Node newNode = new Node();
		newNode.iData = data;
		if (head == null) {
			head = newNode;
			return head;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return head;
	}
	
	public static Node insertNodeForList(Node head, Node newNode) {
		if (head == null) {
			head = newNode;
			return head;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return head;
	}
	
	public Node insertNodeForListInstance(Node head, Node newNode) {
		if (head == null) {
			head = newNode;
			return head;
		}
		Node currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		return head;
	}

	public static void printLinkedList(Node headNode) {
		Node currentNode = headNode;
		while (currentNode.next != null) {
			System.out.print(currentNode.iData + "-->");
			currentNode = currentNode.next;
		}
		System.out.print(currentNode.iData);
		System.out.println();
	}
	
	public static void printCharLinkedList(Node headNode) {
		Node currentNode = headNode;
		while (currentNode.next != null) {
			System.out.print(currentNode.cData + "-->");
			currentNode = currentNode.next;
		}
		System.out.print(currentNode.cData);
		System.out.println();
	}
	
	public static void printNElementsOfLinkedList(Node headNode, int n) {
		Node currentNode = headNode;
		for (int i = 0; i < n - 1; i++) {
			if (currentNode != null) {
				System.out.print(currentNode.cData + "-->");
				currentNode = currentNode.next;
			}
		}
		if (currentNode != null) {
			System.out.print(currentNode.cData);
		}
		System.out.println();
	}
	
	public static int getLength(Node headNode) {
		int length = 0;
		if (headNode == null) {
			return 0;
		}
		Node currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.next;
		}
		return length;
	}
}
