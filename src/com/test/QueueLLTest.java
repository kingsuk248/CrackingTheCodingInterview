package com.test;

import com.structure.data.QueueLL;

public class QueueLLTest {
	public static void main(String[] args) {
		QueueLL<Character> queue = new QueueLL<>();
		queue.add('A');
		System.out.println(queue.remove());
		System.out.println();
		queue.add('B');
		queue.add('C');
		queue.add('D');
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
	}
}
