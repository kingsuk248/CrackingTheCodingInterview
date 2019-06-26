package com.graphs.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.structure.data.BinarySearchTree;
import com.structure.data.Node;
import com.util.BTreePrinter;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all
 * the nodes at each depth (e.g. if you have a tree with depth D, you'll have D
 * linked lists).
 * 
 * @author kisarkar
 *
 */
public class ListOfDepths {
	private static BinarySearchTree tree;

	public static void main(String[] args) {
		tree = new BinarySearchTree();
		List<Integer> inputArray = Arrays.asList(5, 2, 8, 1, 3, 6, 9, 4, 7, 10);
		inputArray.forEach(i -> tree.insertNode(i));
		BTreePrinter.printNode(BinarySearchTree.root);
		ListOfDepths listOfDepths = new ListOfDepths();
		List<LinkedList<Node>> listOfLinkedLists = listOfDepths.createLinkedListsByRecursion();
		listOfDepths.printListOfLinkedLists(listOfLinkedLists);
		System.out.println();
		listOfLinkedLists = listOfDepths.createLinkedListsByBfs();
		listOfDepths.printListOfLinkedLists(listOfLinkedLists);
	}

	private void printListOfLinkedLists(List<LinkedList<Node>> listOfLinkedLists) {
		int level = 0;
		for (LinkedList<Node> linkedList : listOfLinkedLists) {
			System.out.print("Level " + level + ": ");
			linkedList.forEach(i -> System.out.print(i.iData + " "));
			System.out.println();
			level++;
		}
	}

	private List<LinkedList<Node>> createLinkedListsByRecursion() {
		List<LinkedList<Node>> listOfLinkedLists = new ArrayList<LinkedList<Node>>();
		createLevelLinkedList(BinarySearchTree.root, listOfLinkedLists, 0);
		return listOfLinkedLists;
	}

	private void createLevelLinkedList(Node node, List<LinkedList<Node>> list, int level) {
		if (node == null) {
			return;
		}
		LinkedList<Node> linkedList = null;
		if (list.size() == level) {
			linkedList = new LinkedList<>();
			list.add(linkedList);
		} else {
			linkedList = list.get(level);
		}
		linkedList.add(node);
		createLevelLinkedList(node.left, list, level + 1);
		createLevelLinkedList(node.right, list, level + 1);
	}

	private List<LinkedList<Node>> createLinkedListsByBfs() {
		List<LinkedList<Node>> listOfLinkedList = new ArrayList<>();
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(BinarySearchTree.root);
		
		while (!currentList.isEmpty()) {
			listOfLinkedList.add(currentList);
			LinkedList<Node> parents = currentList;
			currentList = new LinkedList<>();
			for (Node parent : parents) {
				if (parent.left != null) {
					currentList.add(parent.left);
				}
				if (parent.right != null) {
					currentList.add(parent.right);
				}
			}
		}
		
		return listOfLinkedList;
	}
}
