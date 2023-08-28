package graph;

public class ReplaceOwithX {
	static int[] dirX = { 0, 1, 0, -1 };
	static int[] dirY = { 1, 0, -1, 0 };

	static char[][] fill(int n, int m, char a[][]) {
		// code here
		if (n > 0 && m > 0) {
			boolean[][] vis = new boolean[n][m];
			char[][] mat = new char[n][m];

			for (int i = 0; i < n; ++i) {
				Arrays.fill(vis[i], false);
				for (int j = 0; j < m; ++j) {
					mat[i][j] = a[i][j];
				}
			}

			for (int i = 0; i < n; ++i) {
				if (a[i][0] == 'O') {
					dfs(i, 0, mat, vis);
				}
				if (a[i][m - 1] == 'O') {
					dfs(i, m - 1, mat, vis);
				}
			}

			for (int j = 0; j < m; ++j) {
				if (a[0][j] == 'O') {
					dfs(0, j, mat, vis);
				}

				if (a[n - 1][j] == 'O') {
					dfs(n - 1, j, mat, vis);
				}
			}

			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (a[i][j] == 'O' && !vis[i][j]) {
						mat[i][j] = 'X';
					}
				}
			}
			return mat;
		}

		return new char[0][0];
	}

	private static void dfs(int i, int j, char[][] mat, boolean[][] vis) {

		int n = mat.length;
		int m = mat[0].length;

		vis[i][j] = true;

		for (int k = 0; k < 4; ++k) {
			int x = i + dirX[k];
			int y = j + dirY[k];

			if (x >= 0 && x < n && y >= 0 && y < m && !vis[x][y] && mat[x][y] == 'O') {
				dfs(x, y, mat, vis);
			}
		}

	}
}
