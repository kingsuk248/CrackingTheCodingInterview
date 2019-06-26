package com.test;

import com.structure.data.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree binaryTree = new BinarySearchTree();
		int[] treeArray = {3, 6, 2, 4, 0, 1, 8, 7, 5, 9};
		for (Integer i : treeArray) {
			binaryTree.insertNode(i);
		}
		
		System.out.print("Inorder ====> ");
		binaryTree.inOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("Preorder ====> ");
		binaryTree.preOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("Postorder ====> ");
		binaryTree.postOrder(binaryTree.root);
		System.out.println();
		
		System.out.println("Found 4 ? " + (binaryTree.findNode(4) == null ? "Nope" : "Yup"));
		System.out.println("Found 10 ? " + (binaryTree.findNode(20) == null ? "Nope" : "Yup"));
		
		System.out.println("Deleting '6' a two-children node");
		binaryTree.deleteNode(6);
		System.out.print("Inorder ====> ");
		binaryTree.inOrder(binaryTree.root);
		
		System.out.println("Deleting '8' a one-child node");
		binaryTree.deleteNode(8);
		System.out.print("Inorder ====> ");
		binaryTree.inOrder(binaryTree.root);
		
		System.out.println("Deleting '1' a leaf node");
		binaryTree.deleteNode(1);
		System.out.print("Inorder ====> ");
		binaryTree.inOrder(binaryTree.root);
	}
}
