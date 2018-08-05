package ArrayUtils;

public class 保持二维数组天际线不变的最大增高 {

	public static void main(String[] args) {
		int[][] grid = new int[][] { { 8, 4, 8, 7 }, { 7, 4, 7, 7 }, { 9, 4, 8, 7 }, { 3, 3, 3, 3 } };
		maxIncreaseKeepingSkyline(grid);
	}

	static int maxIncreaseKeepingSkyline(int[][] grid) {
		int m = grid.length, n = grid[0].length, res = 0;
		int[] row = new int[m];
		int[] col = new int[n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				row[i] = Math.max(row[i], grid[i][j]);
				col[j] = Math.max(col[j], grid[i][j]);
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				res += Math.min(row[i] - grid[i][j], col[j] - grid[i][j]);
			}
		}
		System.out.println(res);
		return res;
	}
}
