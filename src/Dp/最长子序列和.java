package Dp;

public class 最长子序列和 {

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { 1,-1,-3}));

	}

	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] >max) {
				max = nums[i];
			}
		}

		if(max<0) {
			return max;
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0] > 0 ? nums[0] : 0;
		int sum = dp[0];
		for (int i = 1; i < dp.length; i++) {
			if (dp[i - 1] + nums[i] < 0) {
				sum = 0;
				dp[i] = 0;
			} else {
				dp[i] = dp[i - 1] + nums[i];
			}
			sum = Math.max(sum, dp[i]);
		}
		return sum;

	}

}
