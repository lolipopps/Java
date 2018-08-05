package ArrayUtils;

import java.util.ArrayList;

public class 所有连续数组组成100 {

	public static void main(String[] args) {
		System.out.println(FindContinuousSequence(5));
	}

	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		int number = sum/2+1;
		int[][] dp = new int[number+1][number+1];
		for (int i = 1; i <= number; i++) {
			dp[i][i] = i;
		}

		for (int i = 1; i <= number; i++) {
			for (int j = i + 1; j <= number; j++) {
				dp[i][j] = dp[i][j - 1] + j;

				if (dp[i][j] > sum) {
					break;
				}
			}
		}
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i < dp.length; i++) {
			int index = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int j = i; j < dp[i].length; j++) {
				index++;
				if(dp[i][j]==sum) {
					for(int k=0;k<index;k++) {
						temp.add(i+k);
					}
					if(temp.size() != 1)
						res.add(temp);
				}else  if(dp[i][j] == 0){
					break;
				}
			}
		}
		return res;

	}

}
