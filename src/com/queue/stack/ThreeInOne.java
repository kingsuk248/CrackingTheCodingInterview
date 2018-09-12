package com.queue.stack;

import java.util.EmptyStackException;

public class ThreeInOne {
	public static void main(String[] args) {
		ThreeInOne threeInOne = new ThreeInOne();
		threeInOne.execute();
	}

	private void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	private class FixedStack {
		int numOfStacks = 3;
		int stackCapacity; // Each stack capacity
		int[] sizes; // Each stack current size
		int[] stacksArray; // Complete array of three stacks

		public FixedStack(int stackCapacity) {
			this.stackCapacity = stackCapacity;
			this.sizes = new int[numOfStacks];
			this.stacksArray = new int[numOfStacks * stackCapacity];
		}

		public void push(int stackNum, int value) {
			if (isFull(stackNum))
				throw new StackOverflowError();
			int offset = stackNum * stackCapacity + sizes[stackNum];
			sizes[stackNum] = sizes[stackNum] + 1;
			stacksArray[offset] = value;
		}

		public int pop(int stackNum) {
			if (isEmpty(stackNum))
				throw new EmptyStackException();
			int offset = stackNum * stackCapacity + (sizes[stackNum] - 1);
			sizes[stackNum] = sizes[stackNum] - 1;
			int val = stacksArray[offset];
			stacksArray[offset] = 0;
			return val;
		}

		public int peek(int stackNum) {
			if (isEmpty(stackNum))
				throw new EmptyStackException();
			int offset = stackNum * stackCapacity + (sizes[stackNum] - 1);
			return stacksArray[offset];
		}

		public boolean isEmpty(int stackNum) {
			if (sizes[stackNum] == 0) {
				return true;
			}
			return false;
		}

		public boolean isFull(int stackNum) {
			if (sizes[stackNum] == stackCapacity - 1) {
				return true;
			}
			return false;
		}
	}

	private void execute() {
		FixedStack stack = new FixedStack(5);
		stack.push(0, 1);
		stack.push(0, 2);
		stack.push(0, 3);
		stack.push(1, 5);
		stack.push(1, 10);
		stack.push(1, 15);
		stack.push(2, 10);
		stack.push(2, 20);
		stack.push(2, 30);
		System.out.println("Stack current state: ");
		printArray(stack.stacksArray);
		System.out.println("Popping from stack 0: " + stack.pop(0));
		System.out.println("Popping from stack 1: " + stack.pop(1));
		System.out.println("Popping from stack 2: " + stack.pop(2));
		System.out.println("Stack current state: ");
		printArray(stack.stacksArray);
		stack.push(2,  50);
		stack.push(1,  25);
		stack.pop(0);
		printArray(stack.stacksArray);
		System.out.println("Peeking from stack 0: " + stack.peek(0));
		System.out.println("Peeking from stack 1: " + stack.peek(1));
		System.out.println("Peeking from stack 2: " + stack.peek(2));
		printArray(stack.stacksArray);
	}
}
