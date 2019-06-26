package com.structure.data;

public class BinaryTree {
	public static Node root;

	public Node insertNode(int iData, Queue queue) {
		Node newNode = new Node(iData);
		if (root == null) {
			root = newNode;
		} else {
			Node frontNode = queue.peekFront();
			if (frontNode.left == null) {
				frontNode.left = newNode;
			} else if (frontNode.right == null) {
				frontNode.right = newNode;
			} 
			if (frontNode.left != null && frontNode.right != null) {
				queue.dequeue();
			}
		}
		queue.enqueue(newNode);
		return newNode;
	}

	public class Queue {
		private Node[] nodeArray;
		private int front;
		private int rear;
		private int maxSize;
		private int numItems;

		public Queue(int maxSize) {
			nodeArray = new Node[maxSize];
			this.maxSize = maxSize;
			front = 0;
			rear = -1;
		}

		public void enqueue(Node node) {
			if (!isFull()) {
				if (rear == maxSize - 1) {
					rear = -1;
				}
				nodeArray[++rear] = node;
				numItems++;
			}
		}

		public Node dequeue() {
			if (isEmpty()) {
				return null;
			}
			Node node = nodeArray[front++];
			if (front == maxSize) {
				front = 0;
			}
			numItems--;
			return node;
		}

		public Node peekFront() {
			return nodeArray[front];
		}

		public boolean isFull() {
			return numItems == maxSize;
		}

		public boolean isEmpty() {
			return numItems == 0;
		}
	}
}
