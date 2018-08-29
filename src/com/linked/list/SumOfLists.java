package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.FileUtil;

public class SumOfLists {
	public static void main(String[] args) {

		FileUtil fileUtil = new FileUtil();
		int[] intArray1 = fileUtil.getIntegers(4, 0);
		int[] intArray2 = fileUtil.getIntegers(2, 1);
		SinglyLinkedList sll1 = new SinglyLinkedList();
		SinglyLinkedList sll2 = new SinglyLinkedList();
		Node headNode1 = null;
		for (int i : intArray1) {
			headNode1 = sll1.insertElementsForListInstance(headNode1, i);
		}
		System.out.print("Linked List 1: ");
		SinglyLinkedList.printLinkedList(headNode1);

		Node headNode2 = null;
		for (int i : intArray2) {
			headNode2 = sll2.insertElementsForListInstance(headNode2, i);
		}
		System.out.print("Linked List 2: ");
		SinglyLinkedList.printLinkedList(headNode2);
		SumOfLists sol = new SumOfLists();
		sol.execute(headNode1, headNode2);
	}

	private void execute(Node headNode1, Node headNode2) {
		getSumBackward(headNode1, headNode2);

		Node sum2 = getSumForward(headNode1, headNode2);
		System.out.print("Sum calculated forwards: ");
		SinglyLinkedList.printLinkedList(sum2);
	}

	private void getSumBackward(Node headNode1, Node headNode2) {
		Node current1 = headNode1;
		Node current2 = headNode2;
		int carryOver = 0;
		Node newHead = null;
		Node newNode = null;
		while (current1 != null && current2 != null) {
			int digitSum = current1.iData + current2.iData;
			int unitsDigit = (digitSum + carryOver) % 10;
			carryOver = (digitSum) / 10;
			newNode = new Node();
			newNode.iData = unitsDigit;
			if (newHead == null) {
				newHead = newNode;
			} else {
				newNode.next = newHead;
				newHead = newNode;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		while (current1 != null) {
			newNode = new Node();
			newNode.iData = (current1.iData + carryOver) % 10;
			newNode.next = newHead;
			newHead = newNode;
			carryOver = (current1.iData + carryOver) / 10;
			current1 = current1.next;
		}
		while (current2 != null) {
			newNode = new Node();
			newNode.iData = (current2.iData + carryOver) % 10;
			newNode.next = newHead;
			newHead = newNode;
			carryOver = (current2.iData + carryOver) / 10;
			current2 = current2.next;
		}
		if (carryOver != 0) {
			newNode = new Node();
			newNode.iData = carryOver;
			newNode.next = newHead;
			newHead = newNode;
		}
		System.out.print("Sum calculated backwards: ");
		SinglyLinkedList.printLinkedList(newHead);
	}

	private Node getSumForward(Node node1, Node node2) {
		int length1 = getLength(node1);
		int length2 = getLength(node2);
		if (length1 > length2) {
			node2 = padList(node2, length1 - length2);
		}
		if (length1 < length2) {
			node1 = padList(node1, length2 - length1);
		}
		PartialSum sum = addListHelper(node1, node2);
		if (sum.carry == 0) {
			return sum.sum;
		} else {
			Node newNode = new Node();
			newNode.iData = sum.carry;
			return insertBefore(sum.sum, newNode);
		}
	}

	private int getLength(Node head) {
		Node current = head;
		int length = 0;
		while (current != null) {
			length++;
			current = current.next;
		}
		return length;
	}

	private Node padList(Node head, int num) {
		for (int i = 0; i < num; i++) {
			Node node = new Node();
			node.iData = 0;
			head = insertBefore(head, node);
		}
		return head;
	}

	private PartialSum addListHelper(Node l1, Node l2) {
		if (l1 == null && l2 == null) {
			PartialSum partialSum = new PartialSum();
			return partialSum;
		}
		PartialSum result = addListHelper(l1.next, l2.next);
		int sumUnits = l1.iData + l2.iData + result.carry;
		Node newNode = new Node();
		newNode.iData = sumUnits % 10;
		Node resultHead = insertBefore(result.sum, newNode);
		result.sum = resultHead;
		result.carry = sumUnits / 10;
		return result;
	}

	private Node insertBefore(Node head, Node node) {
		if (head != null) {
			node.next = head;
		}
		head = node;
		return head;
	}

	public class PartialSum {
		Node sum = null;
		int carry = 0;
	}
}
