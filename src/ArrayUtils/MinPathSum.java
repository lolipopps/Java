package ArrayUtils;

public class MinPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { {1,2,5},{3,2,1}}));

	}

	public static int minPathSum(int[][] grid) {
		int dp[][] = new int[grid.length][grid[0].length];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < dp[0].length; i++) {
			dp[0][i] = grid[0][i] + dp[0][i - 1];

		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];

		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (dp[i][j - 1] < dp[i - 1][j]) {
					dp[i][j] = grid[i][j] + dp[i][j - 1];
				} else {
					dp[i][j] = grid[i][j] + dp[i - 1][j];
				}
			}
		}
		return dp[grid.length - 1][grid[grid.length - 1].length - 1];
	}

}
