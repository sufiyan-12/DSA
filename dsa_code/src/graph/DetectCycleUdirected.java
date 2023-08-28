package graph;

import java.util.*;

public class DetectCycleUdirected {
	class Pair {
		int src, des;

		Pair(int src, int des) {
			this.src = src;
			this.des = des;
		}
	}

	// Function to detect cycle in an undirected graph.
	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here

		boolean[] vis = new boolean[V];
		Arrays.fill(vis, false);

		for (int i = 0; i < V; ++i) {
			if (!vis[i]) {

				if (bfs(i, adj, vis) || dfs(new Pair(i, -1), adj, vis)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean bfs(int sv, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(sv, -1));
		vis[sv] = true;

		while (!q.isEmpty()) {
			Pair node = q.peek();
			q.poll();

			int src = node.src;
			int des = node.des;

			for (int v : adj.get(src)) {
				if (!vis[v]) {
					q.add(new Pair(v, src));
					vis[v] = true;
				} else if (v != des) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(Pair pair, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {

		int node = pair.src;
		int parent = pair.des;

		vis[node] = true;

		for (int v : adj.get(node)) {
			if (!vis[v]) {
				if (dfs(new Pair(v, node), adj, vis)) {
					return true;
				}
			} else if (v != parent) {
				return true;
			}
		}
		return false;
	}
}
