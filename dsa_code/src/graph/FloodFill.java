package graph;

import java.util.Arrays;

public class FloodFill {

	/**
	 * this method returns the modified graph
	 * 
	 * TC: O(N x M)
	 * SC: O(N x M)
	 * 
	 * @param image
	 * @param sr
	 * @param sc
	 * @param newColor
	 * @return
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n = image.length; 
        int m = image[0].length;
        
        int[][] adj = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        
        for(int i=0; i<n; ++i){
            
            Arrays.fill(vis[i], false);
            
            for(int j=0; j<m; ++j){
                adj[i][j] = image[i][j];
            }
        }
        
        dfs(sr, sc, adj, vis, newColor, adj[sr][sc]);
        adj[sr][sc] = newColor;
        
        return adj;
    }
    
    private void dfs(int sr, int sc, int[][] adj, boolean[][] vis, int newColor, int oldColor){
        
        int n = adj.length; 
        int m = adj[0].length;
        
        vis[sr][sc] = true;
        
        int[] dirX = {0, 1, -1,  0};
        int[] dirY = {1, 0,  0, -1};
        
        for(int i=0; i<4; ++i){
            int x = sr+dirX[i];
            int y = sc+dirY[i];
            
            if(x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && adj[x][y] == oldColor){
                adj[x][y] = newColor;
                dfs(x, y, adj, vis, newColor, oldColor);
            }
        }
    }
}
