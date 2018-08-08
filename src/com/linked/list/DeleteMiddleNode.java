package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.ScannerUtil;

public class DeleteMiddleNode {
	public static void main(String[] args) {
		int[] intArray = ScannerUtil.getIntegers(5);
		Node headNode = null;
		for (int i : intArray) {
			headNode = SinglyLinkedList.insertElements(i);
		}
		SinglyLinkedList.printLinkedList(headNode);
		int k = 3;
		Node current = headNode;
		while (current != null && k > 0) {
			k--;
			current = current.next;
		}
		System.out.println(current.iData);
		execute(current);
		SinglyLinkedList.printLinkedList(headNode);
	}

	private static void execute(Node delNode) {
		if (delNode == null || delNode.next == null) {
			return;
		}
		delNode.iData = delNode.next.iData;
		delNode.next = delNode.next.next;
	}
}
