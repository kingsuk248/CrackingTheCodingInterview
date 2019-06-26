package com.util;

public class NodeT<T> {
	public T data;
	public NodeT<T> left;
	public NodeT<T> right;
	
	public NodeT(T data) {
		this.data = data;
	}
}
