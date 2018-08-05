package ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 三角形最短路径 {
	public static void main(String[] args) {
		List<List<Integer>> num = new ArrayList<List<Integer>>();
		System.out.println("11111");
		List<Integer> num0 = new ArrayList<Integer>();
		num0.add(2);
		num.add(num0);
	
	
		List<Integer> num1 = new ArrayList<Integer>();
		num1.add(3);
		num1.add(4);
		num.add(num1);
		List<Integer> num2 = new ArrayList<Integer>();
		num2.add(6);
		num2.add(5);
		num2.add(7);
		num.add(num2);
		List<Integer> num3 = new ArrayList<Integer>();
		num3.add(4);
		num3.add(1);
		num3.add(8);
		num3.add(3);
		num.add(num3);
		minimumTotal(num);

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		System.out.println(triangle.size());
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0]  = triangle.get(0).get(0);
		for(int i=1;i<triangle.size();i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][0] + triangle.get(i).get(0);
				}else {
					dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + triangle.get(i).get(j);
				}

			}
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<dp[dp.length-1].length;i++) {
			System.out.println(dp[dp.length-1][i]);
			if(min > dp[dp.length-1][i]) {
				min = dp[dp.length-1][i];
			}
		}
		System.out.println(min);
		return min;
	}

}
