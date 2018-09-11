package com.structure.data;

import java.util.NoSuchElementException;

public class QueueLL<T> {

	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		private QueueNode(T data) {
			this.data = data;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T data) {
		QueueNode<T> node = new QueueNode<T>(data);
		if (last != null) {
			last.next = node;
		}
		last = node;
		if (first == null) {
			first = last;
		}
	}

	public T remove() {
		if (first == null) throw new NoSuchElementException();
		QueueNode<T> t = first;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return t.data;
	}

	public T peek() {
		if (first == null) throw new NoSuchElementException();
		QueueNode<T> t = first;
		return t.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}
