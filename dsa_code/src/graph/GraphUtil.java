package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUtil {
	/**
	 * this method print adjacency matrix which stores graph
	 * 
	 * @param adjMatrix
	 */
	public static void print(int[][] adjMatrix) {
		try {
			int index = 0;
			for (int[] row : adjMatrix) {
				System.out.print(index + ": ");
				for (int it : row) {
					System.out.print(it + " ");
				}
				index++;
				System.out.println(); // line escape after each row
			}
			System.out.println(); // line escape after printing graph
		} catch (Exception e) {
			System.out.println("Exception occurs! int print(matrix) e: " + e);
		}
	}

	/**
	 * this method print adjacency list which stores graph
	 * 
	 * @param adjList
	 */
	public static void print(ArrayList<ArrayList<Integer>> adjList) {
		try {
			int index = 0;
			for (ArrayList<Integer> row : adjList) {
				System.out.print(index + ": ");
				for (int it : row) {
					System.out.print(it + " ");
				}
				index++;
				System.out.println(); // line escape after each row
			}
			System.out.println(); // line escape after printing graph
		} catch (Exception e) {
			System.out.println("Exception occurs! int print(List) e: " + e);
		}
	}

	/**
	 * this method print list
	 * 
	 * @param list
	 */
	public static void printList(ArrayList<Integer> list) {
		try {
			for (int it : list) {
				System.out.print(it + " ");
			}
			System.out.println(); // line escape
		} catch (Exception e) {
			System.out.println("Exception occurs! int print(List) e: " + e);
		}
	}

	/**
	 * this method print array
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		try {
			for (int it : array) {
				System.out.print(it + " ");
			}
			System.out.println(); // line escape
		} catch (Exception e) {
			System.out.println("Exception occurs! int print(List) e: " + e);
		}
	}

	/**
	 * this method returns the breadth first search traversal
	 * 
	 * @param V
	 * @param adj
	 * @return
	 */
	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		try {
			ArrayList<Integer> bfs = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();
			boolean vis[] = new boolean[V];

			Arrays.fill(vis, false);

			q.offer(1);
			vis[1] = true;

			while (!q.isEmpty()) {

				int node = q.peek();
				q.poll();

				for (int i : adj.get(node)) {
					if (!vis[i]) {
						q.offer(i);
						vis[i] = true;
					}
				}

				bfs.add(node);
			}
			return bfs;
		} catch (Exception e) {
			System.out.println("Exception in bfsOfGraph()...e: " + e);
		}
		return null;
	}

	/**
	 * this method returns the depth first search traversal
	 * 
	 * @param V
	 * @param adj
	 * @return
	 */
	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		try {
			ArrayList<Integer> dfs = new ArrayList<>();
			boolean vis[] = new boolean[V];
			Arrays.fill(vis, false);
			int start = 1;
			dfs(start, adj, vis, dfs);
			return dfs;
		} catch (Exception e) {
			System.out.println("Exception in dfsOfGraph()...e: " + e);
		}
		return null;
	}

	/**
	 * this method is used by dfsOfGraph() to evaluate dfs
	 * 
	 * @param v
	 * @param adj
	 * @param vis
	 * @param dfs
	 */
	private static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean vis[], ArrayList<Integer> dfs) {
		try {
			vis[v] = true;
			dfs.add(v);

			for (int i : adj.get(v)) {
				if (!vis[i]) {
					dfs(i, adj, vis, dfs);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in dfs()...e: " + e);
		}

	}
}
