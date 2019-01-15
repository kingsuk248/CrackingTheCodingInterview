package com.test;

import com.structure.data.GraphAM;

public class GraphAMTest {
	public static void main(String[] args) {
		GraphAM graph = new GraphAM();
		char[] inputArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
		for (char ch : inputArray) {
			graph.addVertex(ch);
		}
		graph.addEdge(0, 1);
		graph.addEdge(1, 5);
		graph.addEdge(5, 7);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(3, 6);
		graph.addEdge(6, 8);
		graph.addEdge(0, 4);
		graph.addEdge(1, 6);
		
		System.out.println("==== Depth-First Search");
		graph.dfs();
		
		System.out.println();
		
		System.out.println("==== Breadth-First Search");
		graph.bfs();
	}
}
