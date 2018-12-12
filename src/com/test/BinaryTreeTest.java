package com.test;

import com.structure.data.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.insertNode(3);
		binaryTree.insertNode(6);
		binaryTree.insertNode(2);
		binaryTree.insertNode(4);
		binaryTree.insertNode(0);
		binaryTree.insertNode(1);
		binaryTree.insertNode(8);
		binaryTree.insertNode(7);
		binaryTree.insertNode(5);
		
		System.out.print("Inorder ====> ");
		binaryTree.inOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("Preorder ====> ");
		binaryTree.preOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("Postorder ====> ");
		binaryTree.postOrder(binaryTree.root);
		System.out.println();
	}
}
