package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.ScannerUtil;

public class Partition {
	public static void main(String[] args) {
		int[] intArray = ScannerUtil.getIntegers(5);
		Node headNode = null;
		for (int i : intArray) {
			headNode = SinglyLinkedList.insertElements(i);
		}
		int partitionValue = 3;
		execute(headNode, partitionValue);
	}

	private static void execute(Node headNode, int partitionValue) {
		SinglyLinkedList.printLinkedList(partition(headNode, partitionValue));
	}

	private static Node partition(Node node, int partitionValue) {
		Node head = new Node();
		Node tail = head;
		head.iData = node.iData;
		node = node.next;
		while (node != null) {
			if (node.iData < partitionValue) {
				head = insertAtHead(head, tail, node.iData);
			} else {
				tail = insertAtTail(head, tail, node.iData);
			}
			node = node.next;
		}
		return head;
	}

	private static Node insertAtHead(Node head, Node tail, int iData) {
		Node newNode = new Node();
		newNode.iData = iData;
		newNode.next = head;
		head = newNode;
		return head;
	}

	private static Node insertAtTail(Node head, Node tail, int iData) {
		Node newNode = new Node();
		newNode.iData = iData;
		tail.next = newNode;
		tail = newNode;
		return tail;
	}

}
