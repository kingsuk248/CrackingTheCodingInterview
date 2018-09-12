package com.queue.stack;

import java.util.EmptyStackException;

import com.structure.data.StackLL;

public class StackMin {
	public static void main(String[] args) {
		StackMin stackMin = new StackMin();
		stackMin.executeWithStackNodeWithMin();
		stackMin.executeWithMinStack();
	}

	class StackWithMin extends StackLL<NodeWithMin> {
		public void push(int iData) {
			NodeWithMin nodeWithMin = new NodeWithMin(iData, Integer.MAX_VALUE);
			if (peek() == null || peek().minValue > nodeWithMin.iData) {
				nodeWithMin.minValue = nodeWithMin.iData;
			} else {
				nodeWithMin.minValue = peek().minValue;
			}
			StackNode<NodeWithMin> stackNode = new StackNode<>(nodeWithMin);
			stackNode.next = top;
			top = stackNode;
		}

		public NodeWithMin pop() {
			if (isEmpty())
				throw new EmptyStackException();
			StackNode<NodeWithMin> stackNode = top;
			top = top.next;
			return stackNode.data;
		}

		public NodeWithMin peek() {
			if (isEmpty())
				return null;
			StackNode<NodeWithMin> stackNode = top;
			return stackNode.data;
		}

		public Integer min() {
			if (top == null) {
				System.out.println("Stack is Empty !!!");
				return null;
			}
			return top.data.minValue;
		}

		public boolean isEmpty() {
			return top == null;
		}
	}

	private class NodeWithMin {
		private int iData;
		private Integer minValue;

		private NodeWithMin(int iData, int minValue) {
			this.iData = iData;
			this.minValue = minValue;
		}
	}

	class SeperateMinStack {
		StackLL<Integer> primaryStack = new StackLL<Integer>();
		StackLL<Integer> minStack = new StackLL<Integer>();
		
		public void push(int iData) {
			if (primaryStack.isEmpty() || minStack.peek() == null || minStack.peek() > iData) {
				minStack.push(iData);
			}
			primaryStack.push(iData);
		}
		
		public int pop() {
			if (primaryStack.isEmpty())
				throw new EmptyStackException();
			Integer primaryTopData = primaryStack.top.data;
			primaryStack.top = primaryStack.top.next;
			if (primaryTopData == minStack.peek()) {
				minStack.top = minStack.top.next;
			}
			return primaryTopData;
		}
		
		public Integer peek() {
			return primaryStack.top.data;
		}
		
		public Integer min() {
			if (minStack.isEmpty()) {
				System.out.println("Stack is Empty !!!");
				return null;
			}
			return minStack.peek();
		}
		
		public boolean isEmpty() {
			return primaryStack.top == null;
		}
	}

	private void executeWithStackNodeWithMin() {
		StackWithMin stackWithMin = new StackWithMin();
		stackWithMin.push(5);
		System.out.println("Top Value: " + stackWithMin.peek().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		stackWithMin.push(6);
		System.out.println("Top Value: " + stackWithMin.peek().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		stackWithMin.push(3);
		System.out.println("Top Value: " + stackWithMin.peek().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		stackWithMin.push(4);
		System.out.println("Top Value: " + stackWithMin.peek().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		System.out.println("Popping --> " + stackWithMin.pop().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		System.out.println("Popping --> " + stackWithMin.pop().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		System.out.println("Popping --> " + stackWithMin.pop().iData);
		System.out.println("Min Value: " + stackWithMin.min());
		System.out.println("Popping --> " + stackWithMin.pop().iData);
		System.out.println("Min Value: " + stackWithMin.min());
	}

	private void executeWithMinStack() {
		SeperateMinStack seperateMinStack = new SeperateMinStack();
		seperateMinStack.push(50);
		System.out.println("Top Value: " + seperateMinStack.peek());
		System.out.println("Min Value: " + seperateMinStack.min());
		seperateMinStack.push(60);
		System.out.println("Top Value: " + seperateMinStack.peek());
		System.out.println("Min Value: " + seperateMinStack.min());
		seperateMinStack.push(30);
		System.out.println("Top Value: " + seperateMinStack.peek());
		System.out.println("Min Value: " + seperateMinStack.min());
		seperateMinStack.push(40);
		System.out.println("Top Value: " + seperateMinStack.peek());
		System.out.println("Min Value: " + seperateMinStack.min());
		System.out.println("Popping --> " + seperateMinStack.pop());
		System.out.println("Min Value: " + seperateMinStack.min());
		System.out.println("Popping --> " + seperateMinStack.pop());
		System.out.println("Min Value: " + seperateMinStack.min());
		System.out.println("Popping --> " + seperateMinStack.pop());
		System.out.println("Min Value: " + seperateMinStack.min());
		System.out.println("Popping --> " + seperateMinStack.pop());
		System.out.println("Min Value: " + seperateMinStack.min());
	}
}
