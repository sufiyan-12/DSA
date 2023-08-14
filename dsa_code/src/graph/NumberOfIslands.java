package graph;

import java.util.*;

public class NumberOfIslands {
	 
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean vis[][] = new boolean[n][m];
        
        for(int i=0; i<n; ++i){
            Arrays.fill(vis[i], false);
        }
        
        int ans = 0;
        
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                if(!vis[i][j] && grid[i][j] == '1'){
                    bfs(i, j, grid, vis);
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    void bfs(int u, int v, char[][] grid, boolean vis[][]){
        int n = grid.length;
        int m = grid[0].length;
        int dirX[] = {-1, -1, -1, 0, 1, 1, 1, 0};
        int dirY[] = {-1, 0, 1, 1, 1, 0, -1, -1};
        Queue<Pair> q = new LinkedList<>();
        
        q.offer(new Pair(u, v));
        vis[u][v] = true;
        
        while(!q.isEmpty()){
            
            Pair pair = q.peek();
            q.poll();
            
            
            for(int i=0; i<dirX.length; ++i){
                
                int x = pair.row + dirX[i];
                int y = pair.col + dirY[i];
                
                if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1' && !vis[x][y]){
                    q.offer(new Pair(x, y));
                    vis[x][y] = true;
                }
                
            }
        }
    }
}
