package graph;

import java.util.*;

public class DistanceOfNearestCellHaving1 {
	class Tri {
		int x, y, des;

		Tri(int _x, int _y, int _des) {
			this.x = _x;
			this.y = _y;
			this.des = _des;
		}
	}

	private int[] dirX = { 0, 1, 0, -1 };
	private int[] dirY = { 1, 0, -1, 0 };

	// Function to find distance of nearest 1 in the grid for each cell.
	public int[][] nearest(int[][] grid) {
		// Code here
		Integer n = grid.length;
		Integer m = grid[0].length;

		int[][] dest;
		boolean vis[][];

		if (n == null || n <= 0 || m == null || m <= 0) {
			return new int[0][0];
		} else {
			dest = new int[n][m];
			vis = new boolean[n][m];
			for (int i = 0; i < n; ++i) {
				Arrays.fill(vis[i], false);
			}
		}

		solve(grid, vis, dest);

		return dest;
	}

	private void solve(int[][] grid, boolean vis[][], int[][] dest) {

		// Code here
		Integer n = grid.length;
		Integer m = grid[0].length;

		Queue<Tri> q = new LinkedList<>();

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (grid[i][j] == 1) {
					q.offer(new Tri(i, j, 0));
					vis[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Tri tri = q.peek();
			q.poll();
			int r = tri.x;
			int c = tri.y;
			int des = tri.des;
			dest[r][c] = des;

			for (int i = 0; i < 4; ++i) {
				int x = r + dirX[i];
				int y = c + dirY[i];

				if (x < n && x >= 0 && y < m && y >= 0 && !vis[x][y] && grid[x][y] == 0) {
					q.offer(new Tri(x, y, des + 1));
					vis[x][y] = true;
				}
			}
		}

	}
}
