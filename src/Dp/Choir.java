package Dp;

import java.util.Scanner;
/*
 * 
有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生
，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

采用动态规划。设Maxval[i][j]表示以第i个人为最后一个人，一共选取了j+1个人时的最大乘积。
Minval[i][j]表示同样状态下的最小乘积（由于数据中存在负数，负数乘上某个极大的负数反而会变成正的极大值，因而需要同时记录最小值）。
          Maxval[i][j]很显然与Maxval[i][j-1]相关，可以理解为Maxval[i][j]由两部分组成，一部分是自身作为待选值，
另一部分是Maxval[i][j-1]乘上一个人后得到的值，然后取它们的极大值，由此可以得到状态转移方程如下







 */

public class Choir {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		while (s.hasNextInt()) {
			int n = s.nextInt(); // 学生人数
			int[] ability = new int[n];
			for (int i = 0; i < n; i++) {
				ability[i] = s.nextInt();
			}
			int k = s.nextInt(); // k 个学生
			int d = s.nextInt(); // d 距离

			// maxProduct[i][j]表示以第i个人为结尾，合唱团的人数为j+1时，合唱团最大的能力乘积
			long[][] maxProduct = new long[n][k];
			// minProduct[i][j]表示以第i个人为结尾，合唱团的人数为j+1时，合唱团最小的能力乘积
			long[][] minProduct = new long[n][k];

			// 合唱团中只有一个人
			for (int i = 0; i < n; i++) {
				maxProduct[i][0] = ability[i];
				minProduct[i][0] = ability[i];
			}

			long max = Long.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < k; j++) {
					for (int p = i - 1; p >= Math.max(i - d, 0); p--) {
						maxProduct[i][j] = Math.max(maxProduct[i][j], maxProduct[p][j - 1] * ability[i]);
						maxProduct[i][j] = Math.max(maxProduct[i][j], minProduct[p][j - 1] * ability[i]);
						minProduct[i][j] = Math.min(minProduct[i][j], minProduct[p][j - 1] * ability[i]);
						minProduct[i][j] = Math.min(minProduct[i][j], maxProduct[p][j - 1] * ability[i]);
					}
				}
				max = Math.max(max, maxProduct[i][k - 1]);
			}

			System.out.println(max);

		}

	}

}// end of class