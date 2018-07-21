package NiuKe.Dp;

public class Jump {

	public static void main(String[] args) {
		System.out.println(JumpFloor(5));
		System.out.println(JumpFloorII(3));

	}
	public static int JumpFloor(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		int[] dp = new int[target+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=target;i++) {
			dp[i] = dp[i-2]  + dp[i-1];
		}
		return dp[target]; 
		
	}
	
	public static int JumpFloorII(int target) {
		if (target == 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		int[] dp = new int[target+1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3;i<=target;i++) {
			for(int j=1;j<i;j++) {
				dp[i] += dp[j];
			}
			dp[i] = dp[i] +1;
			
		}
		return dp[target]; 
		
	}
}
