package Dp;

import java.util.Scanner;

public class 邮局选址问题 {
	/*
	 * 一条直线上有居民点，邮局只能建在居民点上。给定一个有序整型数组arr，每个值表示居民点的一维坐标
	 * ，再给定一个正数num，表示邮局数量。选择num个居民点建立num个邮局，使得所有的居民点到邮局的总距离最短，返回最短的总距离。
	 * 方法一。动态规划。首先解决一个问题，如果在arr[0…j]上只能建立一个邮局，最短总距离是多少？如果居民点有奇数个，
	 * 邮局建在最中间的那个居民点可以使总距离最短，如果居民点有偶数个，中点有两个，邮局建在哪个都可以让总距离最短。可以根据这个思路计算上面的问题。
	 * 生成规模为N×M的矩阵w，w[i][j]表示如果在arr[i…j]上只能建立一个邮局，最短的总距离。w[i][j]的值可以通过如下计算得到：
	 * 
	 * w[i][j] = w[i][j-1] + arr[j] - arr[(i + j) / 2]
	 * 
	 * 有了w矩阵后，接下来进行动态规划过程。假设dp[i][j]表示如果在arr[0…j]上建立i+1个邮局的最短总距离。
	 * 所以dp[0][j]的值表示如果在arr[0…j]上建立一个邮局最短的总距离。很明显，就是w[0][j]。那么dp[0][0…N-1]
	 * 上的所有值都可以直接用w[0][0…N-1]赋值。
	 * 
	 * 当可以建立不止一个邮局时，情况如下：
	 * 
	 * 1、前i-1个邮局负责arr[0]，第i个邮局负责arr[1…j]，总距离为dp[i-1][0] + w[1][j]
	 * 2、前i-1个邮局负责arr[0…1]，第i个邮局负责arr[2…j]，总距离为dp[i-1][1] + w[2][j]
	 * 3、前i-1个邮局负责arr[0…k]，第i个邮局负责arr[k+1…j]，总距离为dp[i-1][k] + w[k+1][j]
	 * 
	 * 实际上k的取值到j-1就可以了，因为在还有最后一个居民的时候仍然可以建立一个邮局，那么在该居民点建立一个邮局一定没坏处，这样就可以不用考虑：前i-
	 * 1个邮局负责arr[0…j]，第i个邮局负责arr[j+1…j]的情况，避免w矩阵溢出。
	 */

	public static int minDistances(int[] arr, int num) {
		if (arr == null || num < 1 || arr.length < num) {
			return 0;
		}
		int[][] w = new int[arr.length + 1][arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2];  // 得到的是任意两点之间建一个邮局的距离
			}
		}
		int[][] dp = new int[num][arr.length];// 动态规划数组
		int[][] s = new int[num][arr.length];
		for (int j = 0; j != arr.length; j++) {
			dp[0][j] = w[0][j];
			s[0][j] = 0;
		}
		int minK = 0;
		int maxK = 0;
		int cur = 0;
		for (int i = 1; i < num; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				minK = s[i - 1][j];
				maxK = j == arr.length - 1 ? arr.length - 1 : s[i][j + 1];
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = minK; k <= maxK; k++) { 
					cur = dp[i - 1][k] + w[k + 1][j];
					if (cur <= dp[i][j]) {
						dp[i][j] = cur;
						s[i][j] = k;
					}
				}
			}
		}
		return dp[num - 1][arr.length - 1];
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String string = in.nextLine();

		String[] strings = string.split(" ");
		int[] arr = new int[strings.length - 1];
		for (int i = 0; i < strings.length - 1; i++) {
			arr[i] = Integer.valueOf(strings[i]);
		}
		int num = Integer.valueOf(strings[strings.length - 1]);

		System.out.println(minDistances(arr, num));

	}

}
