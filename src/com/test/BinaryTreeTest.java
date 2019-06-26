package com.test;

import com.structure.data.BinaryTree;
import com.structure.data.BinaryTree.Queue;
import com.util.BTreePrinter;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Queue queue = binaryTree.new Queue(10);
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i : intArray) {
			binaryTree.insertNode(i, queue);
		}
		BTreePrinter.printNode(BinaryTree.root);
	}
}
