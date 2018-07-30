package Dp;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(FibonacciDp(1));
		
	}

	public static int Fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return Fibonacci(n - 2) + Fibonacci(n - 1);
	}

	public static int FibonacciDp(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n - 1];
	}
	


}
