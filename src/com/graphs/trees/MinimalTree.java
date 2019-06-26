package com.graphs.trees;

import com.structure.data.BinarySearchTree;
import com.structure.data.Node;
import com.util.BTreePrinter;

/**
 * Given a sorted (increasing order) array with unique integer elements, 
 * write and algorithm to create a binary search tree with minimal height.
 * 
 * @author kisarkar
 *
 */
public class MinimalTree {
	private static BinarySearchTree tree;
	
	public static void main(String[] args) {
		tree = new BinarySearchTree();
		MinimalTree minimalTree = new MinimalTree();
		int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		minimalTree.createMinimalTree(inputArray, 0, inputArray.length - 1);
		BTreePrinter.printNode(BinarySearchTree.root);
	}

	private Node createMinimalTree(int[] array, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		Node newNode = tree.insertNode(array[mid]);
		newNode.left = createMinimalTree(array, start, mid - 1);
		newNode.right = createMinimalTree(array, mid + 1, end);
		return newNode;
	}
}
