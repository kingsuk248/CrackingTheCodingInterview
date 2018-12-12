package com.structure.data;

public class BinaryTree {
	public Node root;

	public void insertNode(int iData) {
		Node newNode = new Node(iData);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (iData <= current.iData) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						break;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						break;
					}
				}
			}
		}
	}

	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			node.display();
			inOrder(node.right);
		}
	}

	public void preOrder(Node node) {
		if (node != null) {
			node.display();
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			node.display();
		}
	}
}
