package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class StoreGraph {
	private int vertices;
	private int edges;
	private int adjMatrix[][];
	private ArrayList<ArrayList<Integer>> adjList;
	private boolean isMatrix;

	/**
	 * construct takes vertices and edges and construct adjacency matrix and
	 * adjacency list
	 * 
	 * @param vertices
	 * @param edges
	 */
	// by default store 1 based graph
	StoreGraph(int vertices, int edges) {
		this.vertices = vertices;
		this.edges = edges;
		this.isMatrix = true;
		adjMatrix = new int[vertices + 1][vertices + 1];
		adjList = new ArrayList<>();
		for (int i = 0; i < vertices + 1; ++i) {
			adjList.add(new ArrayList<>());
		}
	}

	/**
	 * construct creates list or matrix on the preference of arguments
	 * 
	 * @param vertices
	 * @param edges
	 * @param isMatrix
	 * @param isZeroBased
	 */
	StoreGraph(int vertices, int edges, boolean isMatrix, boolean isZeroBased) {
		this.vertices = vertices;
		this.edges = edges;
		this.isMatrix = isMatrix;
		int size = isZeroBased ? vertices : (vertices + 1);
		if (!isMatrix) {
			adjList = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				adjList.add(new ArrayList<>());
			}
		} else {
			adjMatrix = new int[size][size];
			for (int i = 0; i < size; ++i) {
				Arrays.fill(adjMatrix[i], 0);
			}
		}
	}

	/**
	 * getter for vertices
	 * 
	 * @return
	 */
	public int getVertices() {
		return vertices;
	}

	/**
	 * getter for edges
	 * 
	 * @return
	 */
	public int getEdges() {
		return edges;
	}

	/**
	 * getter for adjacency matrix
	 * 
	 * @return
	 */
	public int[][] getMatrix() {
		return adjMatrix;
	}

	/**
	 * getter for adjacency list
	 * 
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> getList() {
		return adjList;
	}

	/**
	 * this method adds node to list or matrix
	 * 
	 * @param u
	 * @param v
	 */
	public void addNode(int u, int v) {
		if (!isMatrix) {
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		} else {
			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}
	}
}
