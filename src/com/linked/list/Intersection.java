package com.linked.list;

import com.linked.list.components.Node;
import com.linked.list.components.SinglyLinkedList;
import com.util.FileUtil;

public class Intersection {
	public static void main(String[] args) {
		SinglyLinkedList listOne = new SinglyLinkedList();
		SinglyLinkedList listTwo = new SinglyLinkedList();
		FileUtil fileUtil = new FileUtil();
		int[] listOneIndividualElements = fileUtil.getIntegers(7, 0);
		int[] listTwoIndividualElements = fileUtil.getIntegers(3, 1);
		Node listOneHead = null;
		Node listTwoHead = null;
		for (int i : listOneIndividualElements) {
			listOneHead = listOne.insertElementsForListInstance(listOneHead, i);
		}
		for (int i : listTwoIndividualElements) {
			listTwoHead = listTwo.insertElementsForListInstance(listTwoHead, i);
		}
		int intersectionPoint = 5;
		Node currentListOneNode = listOneHead;
		for (int i = intersectionPoint; i > 0; i--) {
			currentListOneNode = currentListOneNode.next;
		}
		listTwo.insertNodeForListInstance(listTwoHead, currentListOneNode);
		System.out.print("List 1: ");
		SinglyLinkedList.printLinkedList(listOneHead);
		System.out.print("List 2: ");
		SinglyLinkedList.printLinkedList(listTwoHead);
		
		Intersection intersection = new Intersection();
		intersection.execute(listOneHead, listTwoHead);
	}

	private void execute(Node listOneHead, Node listTwoHead) {
		int length1 = SinglyLinkedList.getLength(listOneHead);
		int length2 = SinglyLinkedList.getLength(listTwoHead);
		if (length1 >= length2) {
			for (int i = 0; i < length1 - length2; i++) {
				listOneHead = listOneHead.next;
			}
		} else {
			for (int i = 0; i < length2 - length1; i++) {
				listTwoHead = listTwoHead.next;
			}
		}
		Node intersectionNode = findIntersection(listOneHead, listTwoHead);
		System.out.println("Intersection node data: " + intersectionNode.iData);
		
	}

	private Node findIntersection(Node listOneHead, Node listTwoHead) {
		if (listOneHead == null || listTwoHead == null) {
			return new Node();
		}
		Node node = findIntersection(listOneHead.next, listTwoHead.next);
		if (listOneHead == listTwoHead) {
			node = listOneHead;
		}
		return node;
	}
}
