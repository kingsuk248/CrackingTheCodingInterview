package com.structure.data;

/**
 * Graph implementation using adjacency matrix
 * 
 * @author kisarkar
 *
 */
public class GraphAM {
	private Vertex[] vertices; // Array of graph vertices
	private int[][] adjMatrix; // Adjacency matrix for the edges
	private int MAX_SIZE = 20;
	private int numVertices;
	private Stack stack;
	private Queue queue;

	public GraphAM() {
		vertices = new Vertex[MAX_SIZE];
		adjMatrix = new int[MAX_SIZE][MAX_SIZE];
		stack = new Stack(MAX_SIZE);
		queue = new Queue(MAX_SIZE);
	}

	/**
	 * Add a new vertex to the graph
	 */
	public void addVertex(char cData) {
		Vertex newVertex = new Vertex(cData);
		vertices[numVertices++] = newVertex;
	}

	/**
	 * Add a new edge between start vertex and end vertex
	 */
	public void addEdge(int start, int end) {
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}

	/**
	 * Display the vertex data
	 * @param builder 
	 */
	public void displayVertex(StringBuilder builder, Vertex vertex) {
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
		vertices[0].isVisited = true; // Starting with the zeroth vertex
		stack.push(0);
		displayVertex(builder, vertices[0]);

		while (!stack.isEmpty()) {
			int v = getUnvisitedVertex(stack.peek());
			if (v == -1) {
				stack.pop(); // All neighboring vertices are visited, hence pop it out
			} else {
				stack.push(v); // Push to stack for traversal of unvisited neighbors
				vertices[v].isVisited = true; // Previously unvisited vertex
				displayVertex(builder, vertices[v]);
			}
		}

		// Resetting the visited flags of all the vertices
		for (int i = 0; i < numVertices; i++) {
			vertices[i].isVisited = false;
		}
	}

	/**
	 * Bread-First search
	 */
	public void bfs() {
		StringBuilder builder = new StringBuilder();
		vertices[0].isVisited = true; // Starting with the zeroth vertex
		displayVertex(builder, vertices[0]);
		queue.insert(0);
		int v = 0;
		
		while (!queue.isEmpty()) {
			while (( v = getUnvisitedVertex(queue.peekFront())) != -1) { // While there more unvisited neighbors
				vertices[v].isVisited = true;
				displayVertex(builder, vertices[v]);
				queue.insert(v);
			}
			queue.remove(); // All neighbors are visited now.
							// Remove element from queue and continue with the first element neighbors.
		}

		// Resetting the visited flags of all the vertices
		for (int i = 0; i < numVertices; i++) {
			vertices[i].isVisited = false;
		}
	}

	/**
	 * Get the next unvisited vertex from input vertex by traversing the row of the
	 * input vertex in the adjacency matrix
	 */
	private int getUnvisitedVertex(int v) {
		for (int i = 0; i < numVertices; i++) {
			if (adjMatrix[v][i] == 1 && !vertices[i].isVisited) {
				return i;
			}
		}
		return -1;
	}
}
