package Dp;

import java.util.Stack;

public class 二维数组最大正方形 {

	public static void main(String[] args) {
		maximalSquare(new int[][] { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 0, 1, 0 } });

	}

	/*
	 * 边界情况，也就是当i或j为0的情况，那么在首行或者首列中，必定有一个方向长度为1，
	 * 那么就无法组成长度超过1的正方形，最多能组成长度为1的正方形，条件是当前位置为1。
	 * 对于任意一点dp[i][j]，由于该点是正方形的右下角，所以该点的右边，下边，右下边都不用考虑，关心的就是左边，
	 * 上边，和左上边。这三个位置的dp值suppose都应该算好的，还有就是要知道一点，只有当前(i, j)位置为1，
	 * dp[i][j]才有可能大于0，否则dp[i][j]一定为0。当(i, j)位置为1，此时要看dp[i-1][j-1], dp[i][j-1]，
	 * 和dp[i-1][j]这三个位置，我们找其中最小的值，并加上1， 就是dp[i][j]的当前值了，这个并不难想，毕竟不能有0存在，
	 * 所以只能取交集，最后再用dp[i][j]的值来更新结果res的值即可
	 */
	public static int maximalSquare(int[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		int max = 0;
		for (int i = 0; i < matrix.length; i++) { // 初始化行
			dp[i][0] = matrix[i][0];
			max = Math.max(max, dp[i][0]);
		}
		for (int j = 0; j < matrix[0].length; j++) { // 初始化列
			dp[0][j] = matrix[0][j];
			max = Math.max(max, dp[0][j]);
		}
		for (int i = 1; i < matrix.length; i++)
			for (int j = 1; j < matrix[0].length; j++)
				if (matrix[i][j] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(dp[i][j], max);
				}
		System.out.println(max * max);
		return max * max;
	}

	// 和正方形不同，不能记录边长做，将问题转化成n个一维的最大子矩形，经典的单调栈算法搞一搞，复杂度O(mn)
	public int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}
		int m = matrix[0].length;
		int[] heights = new int[m + 1];
		Stack<Integer> stk = new Stack<>();
		int ans = 0, cur, w, pos;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '1') {
					heights[j] += 1;
				} else {
					heights[j] = 0;
				}
			}
			pos = 0;
			while (!stk.empty()) {
				stk.pop();
			}
			while (pos <= m) {
				if (stk.empty() || heights[stk.peek()] <= heights[pos]) {
					stk.push(pos++);
				} else {
					cur = stk.peek();
					stk.pop();
					w = stk.empty() ? pos : pos - stk.peek() - 1;
					ans = Math.max(ans, w * heights[cur]);
				}
			}
		}
		return ans;
	}

}
// dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1