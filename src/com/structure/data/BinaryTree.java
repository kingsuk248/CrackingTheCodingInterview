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
	
	public Node findNode(int iData) {
		Node current = root;
		while (current != null) {
			if (current.iData == iData) {
				break;
			}
			if (iData < current.iData) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return current;
	}
	
	public Node deleteNode(int iData) {
		if (findNode(iData) == null) {
			return null;
		}
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;
		while (current.iData != iData) {
			parent = current;
			if (iData < current.iData) {
				current = current.left;
				isLeftChild = true;
			} else {
				current = current.right;
				isLeftChild = false;
			}
		}
		
		if (current.left == null && current.right == null) {
			// Node to be deleted is leaf node
			if (isLeftChild) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		
		} else if (current.left == null) {
			// Node to be deleted only has right child
			if (isLeftChild) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		
		} else if (current.right == null) {
			// Node to be deleted only has left child
			if (isLeftChild) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		
		} else {
			// Node to be delete has both left and right child
			Node successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			// Successor is right child's left most element
			// Hence successor should not have any left tree and
			// current's left tree can be plugged directly to successor's left
			successor.left = current.left;
		}
		return current;
	}

	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if (successor != delNode.right) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
	
	
}
