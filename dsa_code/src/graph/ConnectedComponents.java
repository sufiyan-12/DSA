package graph;

import java.util.ArrayList;

public class ConnectedComponents {
	
	// 1 based graph
	public static int find(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean vis[] = new boolean[V+1];
		int ans = 0;
		
		for(int i=1; i<V+1; ++i) {
			if(!vis[i]) {
				dfs(i, adj, vis);
				ans++;
			}
		}
		return ans;
	}
	
	public static void dfs(int startNode, ArrayList<ArrayList<Integer>> adj, boolean vis[]) {
		
		vis[startNode] = true;
		
		for(int it: adj.get(startNode)) {
			if(!vis[it]) {
				dfs(it, adj, vis);
			}
		}
	}
}
