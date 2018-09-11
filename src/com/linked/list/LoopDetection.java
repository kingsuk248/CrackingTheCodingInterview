package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.FileUtil;

public class LoopDetection {
	public static void main(String[] args) {
		LoopDetection loopDetection = new LoopDetection();
		FileUtil fileUtil = new FileUtil();
		char[] inputChars = fileUtil.getCharacters(8, 0);
		Node headNode = null;
		for (char ch : inputChars) {
			headNode = SinglyLinkedList.insertCharacterElements(ch);
		}
		System.out.print("Linked List: ");
		SinglyLinkedList.printCharLinkedList(headNode);
		System.out.println("Has Loop 1? " + loopDetection.checkIfHasLoop(headNode));
		int loopIndex = 4;
		Node currentNode = headNode;
		while (loopIndex > 0) {
			currentNode = currentNode.next;
			loopIndex--;
		}
		SinglyLinkedList.insertNodeForList(headNode, currentNode);
		System.out.print("Linked List Looped: ");
		SinglyLinkedList.printNElementsOfLinkedList(headNode, 20);
		loopDetection.execute(headNode);
	}

	private void execute(Node headNode) {
		boolean hasLoop = checkIfHasLoop(headNode);
		System.out.println("Has Loop 2 ? " + hasLoop);
		if (hasLoop) {
			System.out.println("Starting point: " + findLoopStart(headNode));
		}
	}
	
	private boolean checkIfHasLoop(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	private char findLoopStart(Node head) {
		Node slow = head;
		Node fast = head;
		slow = slow.next;
		fast = fast.next.next;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return fast.cData;
	}
}
