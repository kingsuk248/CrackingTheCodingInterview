package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.ScannerUtil;

public class KthToLast {
	public static void main(String[] args) {
		int[] intArray = ScannerUtil.getIntegers(5);
		Node headNode = null;
		for (int i : intArray) {
			headNode = SinglyLinkedList.insertElements(i);
		}
		SinglyLinkedList.printLinkedList(headNode);
		int k = 2;
		execute(headNode, k);
	}

	private static void execute(Node headNode, int k) {
		System.out.println("Kth from Last, Method 1: " + getKthFromLastMethod1(headNode, k));
		getKthFromLastMethod2(headNode, k);

	}

	private static int getKthFromLastMethod1(Node headNode, int k) {
		Node slow = headNode;
		Node fast = headNode;
		while (k > 0) {
			fast = fast.next;
			k--;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.iData;
	}

	private static int getKthFromLastMethod2(Node headNode, int k) {
		if (headNode == null) {
			return 0;
		}
		int index = getKthFromLastMethod2(headNode.next, k) + 1;
		if (index == k) {
			System.out.println("Kth from Last, Method 2: " + headNode.iData);
		}
		return index;
	}
}
