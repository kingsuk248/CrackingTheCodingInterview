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

	public static void printLinkedList(Node headNode) {
		Node currentNode = headNode;
		while (currentNode != null) {
			System.out.print(currentNode.iData + " ");
			currentNode = currentNode.next;
		}
		System.out.println();
	}
}
