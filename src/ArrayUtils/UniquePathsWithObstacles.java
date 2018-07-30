package ArrayUtils;

public class UniquePathsWithObstacles {

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][] { { 0, 0, 0 },
			                                                      { 0, 0, 1 },
			                                                      { 0, 0, 1 }  }));

	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {  // 理解错题了 1 不是 目的地 而是 障碍物
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		dp[0][0] = 1;
		if(obstacleGrid[0][0] == 1) {
			return 0;
		}
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
			if (obstacleGrid[0][i] == 1) {
				return 0;
			}

		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
			if (obstacleGrid[i][0] == 1) {
				return 0;
			}

		}
		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[i].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				if (obstacleGrid[i][j] == 1) {
					return dp[i][j];
				}
			}
		}
		return 1;

	}
	public static int uniquePathsWithObstacles1(int[][] obstacleGrid) {
	 int width = obstacleGrid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : obstacleGrid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
}

}
