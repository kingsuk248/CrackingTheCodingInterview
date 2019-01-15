package com.structure.data;

public class Vertex {
	char cData;
	boolean isVisited;
	
	public Vertex(char cData) {
		this.cData = cData;
	}
	
	public boolean isVisited() {
		return isVisited;
	}
	
	public void setVisited(boolean visited) {
		this.isVisited = visited;
	}
	
	public char getNodeValue() {
		return cData;
	}
}
