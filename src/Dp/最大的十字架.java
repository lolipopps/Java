package Dp;

import java.util.Arrays;

public class 最大的十字架 {

	public static void main(String[] args) {
		orderOfLargestPlusSign1(7, new int[][] { { 1, 1} });

	}

	public static int orderOfLargestPlusSign(int N, int[][] mines) {
		int res = 1;
		int[][] grid = new int[N][N];
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isIn(mines, i, j)) {
					System.out.println(i+" "+j);
					grid[i][j] = 0;
				} else {
					grid[i][j] = 1;
				}
				dp[i][j] = grid[i][j];
			}
		}
	


		if (N <= 2) {
			res = FindMax(dp);
			return res;
		}
		
		for(int i=1;i<N-2;i++) {
			for(int j=1;j<N-2;j++) {
				if(grid[i][j] == 0) {
					dp[i][j] = 0;
				}else {
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i+1][j]),Math.min(dp[i][j-1], dp[i][j+1])) + 1;	
				}
				
			}
		}
		res = FindMax(dp);
		System.out.println(res);
		return res;

	}

	public static boolean isIn(int[][] mines, int m, int n) {
		for (int i = 0; i < mines.length; i++) {
			if (mines[i][0] == m && mines[i][1] == n) {
				return true;
			}
		}
		return false;

	}

	public static int FindMax(int[][] mines) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < mines.length; i++) {
			for (int j = 0; j < mines.length; j++) {
				if (mines[i][j] > max) {
					max = mines[i][j];
				}
			}
		}
		return max;


	}
	
	 public static int orderOfLargestPlusSign1(int N, int[][] mines) {
	        int[][] grid = new int[N][N];
	        for(int[] m:grid) {
	            Arrays.fill(m, N);//初始化为较大值
	        }
	        for(int[] m:mines) {
	            grid[m[0]][m[1]] = 0;
	        }
	        for(int i = 0; i < N; i++) {
	            for(int j = 0, k = N - 1, l = 0, r = 0, u = 0, d = 0; j < N; j++, k--) {
	                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l + 1));//由左至右
	                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r + 1));//由右至左
	                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u + 1));//由上至下
	                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d + 1));//由下至上
	            }
	        }
	        int res = 0;
	        for(int i = 0; i < N; i++) {
	            for(int j = 0; j < N; j++) {
	                res = Math.max(res, grid[i][j]);
	            }
	        }
	        System.out.println(res);
	        return res;
	    }

	 

}
