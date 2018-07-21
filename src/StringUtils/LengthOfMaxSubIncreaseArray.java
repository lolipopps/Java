package StringUtils;

public class LengthOfMaxSubIncreaseArray {
/*
给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）
例如：给定一个长度为8的数组A{1,3,5,2,4,6,7,8}，则其最长的单调递增子序列为{1,2,4,6,7,8}，长度为6.
 */
	public static void main(String[] args) {
		int[] A = new int[]{1,3,5,2,4,6,7,8,11};
		int[] B = new int[]{1,2,4,6,7,8,10,12};
		int[] C = new int[] {1,7,3,5,9,10,8};
		System.out.println(longest(C, C.length));
	}
		public static int longest(int[] height, int n){
		        if(height == null || n <= 0 || height.length != n)
		            return 0;
		        // dp[i]代表以i为结尾的最长递增子序列的长度
		        int[] dp = new int[n];
		        dp[0] = 1;
		        int max = 1;
		        for(int i = 1; i < n; i++){
		            dp[i] = 1;
		            for(int j = i - 1; j >= 0; j--){
		                if(height[i] > height[j])
		                    dp[i] = Math.max(dp[i], dp[j] + 1);
		            }
		            if(max < dp[i])
		                max = dp[i];
		        }
		 
		        return max;
		    }

}
