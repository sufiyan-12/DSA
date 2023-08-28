package graph;

import java.util.*;

public class NumberOfEnclaves {

	class Pair {
		int row, col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	int[] dirX = { 0, 1, 0, -1 };
	int[] dirY = { 1, 0, -1, 0 };

	int numberOfEnclaves(int[][] grid) {

		// Your code here
		int n = grid.length;
		int m = grid[0].length;
		int count = 0;

		boolean vis[][] = new boolean[n][m];

		for (int i = 0; i < n; ++i) {
			Arrays.fill(vis[i], false);
		}

		for (int i = 0; i < n; ++i) {

			if (grid[i][0] == 1 && !vis[i][0]) {
				bfs(i, 0, grid, vis);
			}

			if (grid[i][m - 1] == 1 && !vis[i][m - 1]) {
				bfs(i, m - 1, grid, vis);
			}
		}

		for (int j = 0; j < m; ++j) {

			if (grid[0][j] == 1 && !vis[0][j]) {
				bfs(0, j, grid, vis);
			}

			if (grid[n - 1][j] == 1 && !vis[n - 1][j]) {
				bfs(n - 1, j, grid, vis);
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (grid[i][j] == 1 && !vis[i][j]) {
					count++;
				}
			}
		}
		return count;
	}

	private void bfs(int i, int j, int[][] grid, boolean[][] vis) {

		int n = grid.length;
		int m = grid[0].length;

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i, j));

		vis[i][j] = true;

		while (!q.isEmpty()) {

			Pair pair = q.peek();
			q.poll();

			int row = pair.row;
			int col = pair.col;

			for (int k = 0; k < 4; ++k) {
				int x = row + dirX[k];
				int y = col + dirY[k];

				if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && grid[x][y] == 1) {
					q.add(new Pair(x, y));
					vis[x][y] = true;
				}
			}

		}

	}
}
