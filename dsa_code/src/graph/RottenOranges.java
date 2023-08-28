package graph;

import java.util.*;

public class RottenOranges {

	class Tri {

		int row, col, time;

		Tri(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	// Function to find minimum time required to rot all oranges.
	public int orangesRotting(int[][] grid) {
		// Code here
		int n = grid.length;
		int m = grid[0].length;

		int vis[][] = new int[n][m];

		Queue<Tri> q = new LinkedList<>();

	
		int cntFresh = 0;

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (grid[i][j] == 2) {
					q.add(new Tri(i, j, 0));
					vis[i][j] = 2;
				} else {
					vis[i][j] = 0;
				}

				if (grid[i][j] == 1) {
					cntFresh++;
				}
			}
		}

		int tm = 0;

		int[] dirX = { 0, 1, -1, 0 };
		int[] dirY = { 1, 0, 0, -1 };

		int cnt = 0;

		while (!q.isEmpty()) {

			Tri t = q.peek();

			int row = t.row;
			int col = t.col;
			int time = t.time;

			tm = Math.max(tm, time);

			q.poll();

			for (int i = 0; i < 4; ++i) {
				int x = row + dirX[i];
				int y = col + dirY[i];

				if (x >= 0 && x < n && y >= 0 && y < m && vis[x][y] == 0 && grid[x][y] == 1) {
					q.add(new Tri(x, y, time + 1));
					vis[x][y] = 2;
					cnt++;
				}
			}
		}

		if (cnt != cntFresh)
			return -1;

		return tm;
	}
}
