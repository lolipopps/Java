package Dp;

public class 拼格子 {

	public static void main(String[] args) {
		numTilings(5);

	}

	static int numTilings(int N) {
		int M = Integer.MAX_VALUE;
		int[] dp = new int[N + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= N; ++i) {
			dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % M;
		}
		System.out.println(dp[N]);
		return dp[N];
	}

}
