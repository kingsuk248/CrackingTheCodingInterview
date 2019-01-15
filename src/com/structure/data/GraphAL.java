package com.structure.data;

import java.util.List;

/**
 * Graph implementation using adjacency lists
 * 
 * @author kisarkar
 *
 */
public class GraphAL {
	public VertexAL[] vertices;
	private int MAX_SIZE = 20;
	private int numVertices;
	private Stack stack;
	private Queue queue;

	public GraphAL() {
		vertices = new VertexAL[MAX_SIZE];
		stack = new Stack(MAX_SIZE);
		queue = new Queue(MAX_SIZE);
	}

	/**
	 * Add a new vertex to the graph
	 * 
	 * @param cData
	 */
	public void addVertex(char cData) {
		vertices[numVertices++] = new VertexAL(cData);
	}

	/**
	 * Add a new edge to the graph
	 * 
	 */
	public void addEdge(VertexAL from, VertexAL to) {
		from.vertices.add(to);
		to.vertices.add(from);
	}

	/**
	 * Display the vertex data
	 */
	public void displayVertex(StringBuilder builder, VertexAL vertex) {
		if (builder.length() > 0) {
			System.out.println(builder.append("-->").append(vertex.cData).toString());
		} else {
			System.out.println(builder.append(vertex.cData).toString());
		}
	}

	/**
	 * Depth-First search
	 */
	public void dfs() {
		StringBuilder builder = new StringBuilder();
		vertices[0].isVisited = true;
		stack.push(0);
		displayVertex(builder, vertices[0]);
		while (!stack.isEmpty()) {
			VertexAL vertex = getUnvisitedVertex(stack.peek());
			if (vertex == null) {
				stack.pop();
			} else {
				vertex.isVisited = true;
				int vertexIndex = getVertexIndex(vertex);
				stack.push(vertexIndex);
				displayVertex(builder, vertex);
			}
		}
		resetVisitedStatus();
	}

	/**
	 * Breadth-First search
	 */
	public void bfs() {
		StringBuilder builder = new StringBuilder();
		vertices[0].isVisited = true;
		queue.insert(0);
		displayVertex(builder, vertices[0]);
		while (!queue.isEmpty()) {
			VertexAL vertex = getUnvisitedVertex(queue.peekFront());
			if (vertex == null) {
				queue.remove();
			} else {
				vertex.isVisited = true;
				int vertexIndex = getVertexIndex(vertex);
				queue.insert(vertexIndex);
				displayVertex(builder, vertex);
			}
		}
	}

	private VertexAL getUnvisitedVertex(int v) {
		VertexAL currVertex = vertices[v];
		List<VertexAL> currVertices = currVertex.getVertices();
		for (VertexAL vertex : currVertices) {
			if (vertex.isVisited == false) {
				return vertex;
			}
		}
		return null;
	}

	private int getVertexIndex(VertexAL vertex) {
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].equals(vertex)) {
				return i;
			}
		}
		return -1;
	}
	
	private void resetVisitedStatus() {
		for (int i = 0; i < numVertices; i++) {
			vertices[i].isVisited = false;
		}
	}
}
