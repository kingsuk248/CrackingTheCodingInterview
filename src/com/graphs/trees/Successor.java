package com.graphs.trees;

import com.structure.data.BinarySearchTree;
import com.structure.data.Node;
import com.util.BTreePrinter;

/**
 * Write an algorithm to find the "next" node (i.e. in-order successor) of a
 * given node in a binary search tree. You may assume that each node has a link
 * to its parent
 * 
 * @author kisarkar
 *
 */
public class Successor {
	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		int[] intArray2 = { 30, 60, 20, 40, 45, 0, 10, 80, 70, 50, 90, 55 };
		for (int i : intArray2) {
			binarySearchTree.insertNode(i);
		}
		BTreePrinter.printNode(BinarySearchTree.root);
		Successor successor = new Successor();
		int searchNodeVal = 55;
		Node node = findNode(searchNodeVal);
		Node successorNode = successor.go(node);
		System.out.println("Successor of " + node.iData + " is " + successorNode.iData);
	}

	private static Node findNode(int searchNodeVal) {
		Node currentNode = BinarySearchTree.root;
		while (currentNode.iData != searchNodeVal) {
			if (currentNode.iData < searchNodeVal) {
				currentNode = currentNode.right;
			} else {
				currentNode = currentNode.left;
			}
		}
		return currentNode;
	}

	private Node go(Node node) {
		if (node.right == null) {
			if (node == node.parent.left) { // Node is left child of parent
				return node.parent;
			} else { // Node is right child of parent
				Node p = node.parent;
				while (p != null && p.right == node) { // Traverse until parent is left subtree of a node
					node = p;
					p = node.parent;
				}
				return p;
			}
		} else {
			return findLeftMostNode(node.right);
		}
	}

	private Node findLeftMostNode(Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

}
