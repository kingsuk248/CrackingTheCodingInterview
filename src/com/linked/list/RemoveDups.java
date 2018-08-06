package com.linked.list;

import java.util.HashSet;
import java.util.Set;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.ScannerUtil;

public class RemoveDups {
	public static void main(String[] args) {
		int[] intArray = ScannerUtil.getIntegers(5);
		Node headNode = null;
		for (int i : intArray) {
			headNode = SinglyLinkedList.insertElements(i);
		}
		SinglyLinkedList.printLinkedList(headNode);
		execute(headNode);
	}

	private static void execute(Node headNode) {
		removeDuplicatesMethod1(headNode);
		System.out.print("Method 1: Unique list: ");
		SinglyLinkedList.printLinkedList(headNode);
		
		removeDuplicatesMethod2(headNode);
		System.out.print("Method 2: Unique list: ");
		SinglyLinkedList.printLinkedList(headNode);
	}

	// Remove duplicates by using an intermediary hash set in O(n)
	private static void removeDuplicatesMethod1(Node headNode) {
		Set<Integer> intSet = new HashSet<>();
		Node previous = headNode;
		Node current = headNode.next;
		intSet.add(previous.iData);
		while (current != null) {
			if (!intSet.add(current.iData)) {
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}
	}

	// Remove duplicates by using two loops, slow and fast pointer. O(n^2)
	private static void removeDuplicatesMethod2(Node headNode) {
		Node current = headNode;
		while (current != null) {
			Node next = current.next;
			while (next != null && current.iData == next.iData) {
				next = next.next;
			}
			current.next = next;
			current = next;
		}
	}
}
