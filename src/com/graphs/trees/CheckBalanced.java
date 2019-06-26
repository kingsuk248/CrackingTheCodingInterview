package com.graphs.trees;

import java.util.Arrays;
import java.util.List;

import com.structure.data.BinarySearchTree;
import com.structure.data.Node;
import com.util.BTreePrinter;

/**
 * Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defined to be a tree such that the
 * heights of the two subtrees of any node never differ by more than one
 * 
 * @author kisarkar
 *
 */
public class CheckBalanced {
	private static BinarySearchTree tree;

	public static void main(String[] args) {
		tree = new BinarySearchTree();
		List<Integer> inputArray = Arrays.asList(50, 30, 80, 10, 40, 60, 100, 0, 150);
		inputArray.forEach(i -> tree.insertNode(i));
		BTreePrinter.printNode(BinarySearchTree.root);
		System.out.println();

		CheckBalanced checkBalanced = new CheckBalanced();
		System.out.println("Balanced? Huh? " + checkBalanced.checkIfBalanced());
	}

	private boolean checkIfBalanced() {
		return checkLevelCount(BinarySearchTree.root, 0) == 0 ? true : false;
	}

	private int checkLevelCount(Node node, int level) {
		if (node == null) {
			return level;
		}
		int leftCount = checkLevelCount(node.left, level + 1);
		int rightCount = checkLevelCount(node.right, level + 1);
		if (leftCount == rightCount) {
			return 0;
		} else {
			return -1;
		}
	}

	class NodeLevel {
		Node node;
		int level;

		public NodeLevel(Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}
}
