package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.structure.data.StackUnbound;
import com.util.FileUtil;

public class Palindrome {
	public static void main(String[] args) {
		FileUtil fileUtil = new FileUtil();
		int[] intArray = fileUtil.getIntegers(5, 0);
		Node headNode = null;
		for (int i : intArray) {
			headNode = SinglyLinkedList.insertElements(i);
		}
		System.out.print("Linked List : ");
		SinglyLinkedList.printLinkedList(headNode);
		new Palindrome().execute(headNode);
	}

	private void execute(Node headNode) {
		System.out.println("Method 1: Is Palindrome ? " + new Palindrome().method1ReverseAndCompare(headNode));
		System.out.println("Method 2: Is Palindrome ? " + new Palindrome().method2IterativeUsingStack(headNode));
		//System.out.println("Method 3: Is Palindrome ? " + new Palindrome().method3Recursive(headNode));
	}

	private boolean method1ReverseAndCompare(Node headNode) {
		HeadAndTail reversed = reverse(headNode);
		return isEqual(headNode, reversed.head);
	}
	
	private boolean method2IterativeUsingStack(Node headNode) {
		Node slow = headNode;
		Node fast = headNode;
		StackUnbound stack = new StackUnbound();
		while (fast != null && fast.next != null) {
			stack.push(slow.iData);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (!stack.isEmpty()) {
			if (slow == null) {
				return false;
			}
			if (slow.iData != stack.pop()) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
	
	/*private boolean method3Recursive(Node headNode) {
		return false;
	}*/

	private HeadAndTail reverse(Node head) {
		if (head == null) {
			return null;
		}
		HeadAndTail ht = reverse(head.next);
		Node clonedHead = head.clone(head);
		clonedHead.next = null;
		if (ht == null) {
			return new HeadAndTail(clonedHead, clonedHead);
		}
		ht.tail.next = clonedHead;
		return new HeadAndTail(ht.head, clonedHead);
	}

	public boolean isEqual(Node head, Node reversedHead) {
		while (head != null && reversedHead != null) {
			if (head.iData != reversedHead.iData) {
				return false;
			}
			head = head.next;
			reversedHead = reversedHead.next;
		}
		return head == null && reversedHead == null;
	}

	public class HeadAndTail {
		Node head;
		Node tail;

		HeadAndTail(Node head, Node tail) {
			this.head = head;
			this.tail = tail;
		}
	}
}
