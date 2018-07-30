package Dp;

public class RectCover {

	public static void main(String[] args) {
		System.out.println(rectCover(3));

	}

	public static int rectCover(int target) {
		if(target == 0 || target == 1) {
			return target;
		}
		
		int[] dp = new int[target+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=target;i++) {
			dp[i]  = dp[i-2] + dp[i-1];
		}
		return dp[target];

	}

}
