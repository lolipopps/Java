package ArrayUtils;

import java.util.Scanner;

public class 插入位置使得距离最短 {
	//邮局问题
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		String[] strings = string.split(" ");
		int[] numbers = new int[strings.length - 1];
		int count = Integer.parseInt(strings[strings.length - 1]);
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(strings[i]);
		}

		if (numbers == null || numbers.length == 0 || count < 1 || numbers.length < count) {
			System.out.println(0);
			return;
		}
		int[][] w = new int[numbers.length][numbers.length];
		for (int i = 0; i < w.length; i++) {
			for (int j = i + 1; j < w.length; j++) {
				w[i][j] = w[i][j - 1] + numbers[j] - numbers[(i + j) / 2];
			}
		}
		int[] dp = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			dp[i] = w[0][i];
		}

		for(int i=1;i<count;i++) {
			for(int j=numbers.length-1;j>=i;j--) {
				int max = Integer.MAX_VALUE;
				for(int k=i;k<j;k++) {

					max = Math.min(max, Math.max(dp[k], w[k+1][j]));
				}
				dp[j] = max;
			}
		}
		System.out.println(dp[dp.length-1]);
	}
}
