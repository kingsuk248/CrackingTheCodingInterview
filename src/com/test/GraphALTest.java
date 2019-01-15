package com.test;

import com.structure.data.GraphAL;
import com.structure.data.VertexAL;

public class GraphALTest {
	public static void main(String[] args) {
		GraphAL graph = new GraphAL();
		char[] inputArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
		for (char ch : inputArray) {
			graph.addVertex(ch);
		}
		VertexAL[] vertices = graph.vertices;
		
		graph.addEdge(vertices[0], vertices[1]);
		graph.addEdge(vertices[1], vertices[5]);
		graph.addEdge(vertices[5], vertices[7]);
		graph.addEdge(vertices[0], vertices[2]);
		graph.addEdge(vertices[0], vertices[3]);
		graph.addEdge(vertices[6], vertices[3]);
		graph.addEdge(vertices[6], vertices[8]);
		graph.addEdge(vertices[0], vertices[4]);
		graph.addEdge(vertices[1], vertices[6]);
		
		System.out.println("==== Depth-First Search");
		graph.dfs();
		
		System.out.println();
		
		System.out.println("==== Breadth-First Search");
		graph.bfs();
	}
}
