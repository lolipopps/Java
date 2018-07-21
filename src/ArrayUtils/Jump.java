package ArrayUtils;

public class Jump {

	public static void main(String[] args) {
		int[] num = { 1, 2, 1, 1, 1 };
		System.out.println(canJump(num));
		System.out.println(jump1(num));

	}
	/*
	 * 给定一个数组 里面存的是你最大能跳的位置 看能不能跳出去。 d
	 */

	public static boolean canJump(int[] nums) { // 用一个标记为 判断能不能到这里来 最后只要返回最后一个能不能到达就可以
	// 思路是先把所有的置为 false

		boolean[] dp = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = false;
		}
		dp[0] = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (dp[i] == false) {
				return false;
			}
			for (int j = 0; j <= nums[i]; j++) {  // 把能到达的地方都置为 true
				if (dp[i + j] == false) {
					dp[i + j] = true;
					if (dp[nums.length - 1] == true) {
						return true;
					}
				}
			}
		}
		return dp[nums.length - 1];

	}

	public boolean canJump1(int[] A) {
		/*
		 * [2,3,1,1,4]
		 */
		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > max) {
				return false;
			}
			max = Math.max(A[i] + i, max); // 每次记录能到达最远的地方  更新该值就好。
		}
		return true;
	}

	public static int jump(int[] nums) { // 返回最早到达的位置 会超时
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = 0;
		}
		for (int i = 0; i < nums.length - 1; i++) {
			/*
			 * [2,3,1,1,4]
			 */
			for (int j = 1; j <= nums[i]; j++) {
				if (i + j > nums.length - 1) {
					break;
				}
				if (dp[i + j] == 0 || dp[i + j] > dp[i] + 1) {
					dp[i + j] = dp[i] + 1;
				}
			}
			if (dp[i] == 0 && i != 0) {   // 到不了最后
				return 0;
			}
		}
		return dp[nums.length - 1];
	}

	public static int jump1(int[] nums) { // 返回最早到达的位置
		int sc = 0;
		int e = 0;
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, i + nums[i]); // 记录能到达的最远值 每次都尽力跳 然后再调最好的
			if (i == e) {  // 到达了最远的地方要更新了
				sc++;
				e = max;  // e 记录的是上一次的最远距离
			}
		}
		return sc;
	}

}
