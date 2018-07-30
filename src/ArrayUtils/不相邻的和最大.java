package ArrayUtils;

public class 不相邻的和最大 {

	public static void main(String[] args) {
		rob(new int[] {6,3,10,8,2,10,3,5,10,5,3});

	}
	public static int rob(int[] nums) {
		if(nums == null) {
			return 0;
		}
        int[] dp = new int[nums.length];
        if(nums.length<=1){
            return nums[0];
             
        }
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1]; 
        for(int i=2;i<nums.length;i++){
            dp[i] = dp[i-1]  >= dp[i-2] + nums[i] ? dp[i-1] : dp[i-2]+nums[i] ;
        }
        for(int i=0;i<dp.length;i++) {
        	System.out.println(dp[i]);
        }
        return dp[nums.length-1]>dp[nums.length-2]?dp[nums.length-1]:dp[nums.length-2];
    }

}
