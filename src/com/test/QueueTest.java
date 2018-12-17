package com.test;

import com.structure.data.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.insert(2);
		queue.insert(3);
		queue.insert(5);
		queue.displayQueue();
		System.out.println("Removed: " + queue.remove());
		System.out.println("Removed: " + queue.remove());
		queue.displayQueue();
		queue.insert(1);
		queue.insert(4);
		queue.insert(6);
		queue.insert(8);
		queue.displayQueue();
		System.out.println("Removed: " + queue.remove());
		System.out.println("Removed: " + queue.remove());
		queue.displayQueue();
	}
}
