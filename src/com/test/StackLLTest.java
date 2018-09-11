package com.test;

import com.structure.data.StackLL;

public class StackLLTest {
	public static void main(String[] args) {
		StackLL<Integer> stack = new StackLL<>();
		stack.push(1);
		System.out.println(stack.pop());
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
