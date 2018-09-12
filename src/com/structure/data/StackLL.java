package com.structure.data;

import java.util.EmptyStackException;

public class StackLL<T> {
	
	public static class StackNode<T> {
		public T data;
		public StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}
	
	public StackNode<T> top;
	
	public void push(T data) {
		StackNode<T> node = new StackNode<T>(data);
		node.next = top;
		top = node;
	}
	
	public T pop() {
		if (isEmpty()) throw new EmptyStackException();
		StackNode<T> t = top;
		top = top.next;
		return t.data;
	}
	
	public T peek() {
		if (isEmpty()) throw new EmptyStackException();
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
