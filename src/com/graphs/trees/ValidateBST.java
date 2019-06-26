package com.graphs.trees;

import com.structure.data.BinarySearchTree;
import com.structure.data.BinaryTree;
import com.structure.data.Node;
import com.util.BTreePrinter;
import com.structure.data.BinaryTree.Queue;

/**
 * Implement a function to check if a binary tree is a binary search tree
 * 
 * @author kisarkar
 *
 */
public class ValidateBST {

	private static Integer prevValue = null;

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Queue queue = binaryTree.new Queue(10);
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i : intArray) {
			binaryTree.insertNode(i, queue);
		}
		System.out.println("====== Binary Tree ======");
		BTreePrinter.printNode(BinaryTree.root);
		inOrder(BinaryTree.root);

		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int[] intArray2 = { 3, 6, 2, 4, 0, 1, 8, 7, 5, 9 };
		for (int i : intArray2) {
			binarySearchTree.insertNode(i);
		}

		System.out.println("====== Binary Search Tree ======");
		BTreePrinter.printNode(BinarySearchTree.root);
		inOrder(BinarySearchTree.root);
		System.out.println();
		System.out.println("== Method 1 ==");
		System.out.println("Is Binary Search tree? " + checkAscending(BinarySearchTree.root));
		System.out.println("Is Binary Search tree? " + checkAscending(BinaryTree.root));
		System.out.println();
		System.out.println("== Method 2 ==");
		System.out.println("Is Binary Search tree? " + checkBst(BinarySearchTree.root));
		System.out.println("Is Binary Search tree? " + checkBst(BinaryTree.root));
	}

	private static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.iData + " ");
		inOrder(node.right);
	}

	/**
	 * In-order type traversal and passing back the previous value to compare with
	 * the current value. If at any point previous value > current value then BST
	 * condition fails
	 * 
	 * @param node
	 * @return
	 */
	private static boolean checkAscending(Node node) {
		if (node == null) {
			return true;
		}
		if (!checkAscending(node.left)) {
			return false;
		}
		if (prevValue != null && prevValue >= node.iData) {
			return false;
		}
		prevValue = node.iData;
		if (!checkAscending(node.right)) {
			return false;
		}
		return true;
	}

	private static boolean checkBst(Node node) {
		return checkBst(node, null, null);
	}

	/**
	 * Recursive traversal with the BST property that all left nodes to a node > the
	 * current node value and all right nodes <= current node value
	 * 
	 * @param node
	 * @return
	 */

	private static boolean checkBst(Node node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}
		if ((min != null && node.iData <= min) || (max != null && node.iData > max)) {
			return false;
		}
		if (!checkBst(node.left, min, node.iData)) {
			return false;
		}
		if (!checkBst(node.right, node.iData, max)) {
			return false;
		}
		return true;
	}
}
