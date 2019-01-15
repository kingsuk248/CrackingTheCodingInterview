package com.graphs.trees;

import com.structure.data.GraphAM;
import com.structure.data.Stack;
import com.structure.data.Vertex;

public class RouteBetweenNodes {
	private static Stack stack;
	private static GraphAM graph;
	private static final int MAX_ELEMENTS = 10;

	static {
		stack = new Stack(MAX_ELEMENTS);
		graph = new GraphAM();
	}

	private static boolean isRoutePresent(int fromNode, int toNode) {
		stack.push(fromNode);

		while (!stack.isEmpty()) {
			int v = getUnvisitedVertex(stack.peek());
			if (v == -1) {
				int poppedV = stack.pop();
				if (poppedV == fromNode) {
					return false;
				}
			} else {
				if (v == toNode) {
					return true;
				}
				stack.push(v);
				graph.getVertices()[v].setVisited(true);
			}
		}

		return false;
	}

	private static int getUnvisitedVertex(int v) {
		int n = graph.getNumberOfVertices();
		int[][] adjMatrix = graph.getAdjacencyMatrix();
		Vertex[] vertices = graph.getVertices();
		for (int i = 0; i < n; i++) {
			if (adjMatrix[v][i] == 1 && !vertices[i].isVisited()) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		char[] inputArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I' };
		for (char ch : inputArray) {
			graph.addVertex(ch);
		}
		graph.addDirectedEdge(0, 1);
		graph.addDirectedEdge(0, 2);
		graph.addDirectedEdge(0, 3);
		graph.addDirectedEdge(0, 4);
		graph.addDirectedEdge(1, 5);
		graph.addDirectedEdge(1, 6);
		graph.addDirectedEdge(7, 5);
		graph.addDirectedEdge(8, 7);
		graph.addDirectedEdge(3, 6);
		graph.addDirectedEdge(8, 6);

		int fromNode = 0;
		int toNode = 6;
		System.out.println("Route present from " + 
				getNodeValue(fromNode) + " to " + getNodeValue(toNode) + " ? " + 
				isRoutePresent(fromNode, toNode));
		
		fromNode = 1;
		toNode = 7;
		System.out.println("Route present from " + 
				getNodeValue(fromNode) + " to " + 
				getNodeValue(toNode) + " ? " + isRoutePresent(fromNode, toNode));
	}

	private static char getNodeValue(int n) {
		return graph.getVertices()[n].getNodeValue();
	}
}
