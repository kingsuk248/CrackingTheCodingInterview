package com.structure.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Vertex for adjacency list
 * 
 * @author kisarkar
 *
 */
public class VertexAL {
	char cData;
	boolean isVisited;
	List<VertexAL> vertices;
	
	public VertexAL(char cData) {
		this.cData = cData;
		vertices = new ArrayList<>();
	}
	
	public List<VertexAL> getVertices() {
		return vertices;
	}
	
	@Override
	public boolean equals(Object v) {
		return this.cData == ((VertexAL)v).cData;
	}
}
