package com.exceptions;

public class EmptyStackException extends Exception {

	private static final long serialVersionUID = 1209867824270658406L;
	
	public EmptyStackException(String message) {
		System.out.println("Stack is Empty!!!");
	}

}
