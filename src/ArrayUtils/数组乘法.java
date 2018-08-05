package ArrayUtils;

public class 数组乘法 {

	public static void main(String[] args) {
		multiply( new int[]{1,3});

	}

	public static int[] multiply(int[] A) {
		if(A.length == 1 || A.length==0) {
			return null;
		}
		int[][] dp = new int[A.length][A.length];
		for (int i = 0; i < A.length; i++) {
			dp[i][i] = A[i];
		}
		for(int i=0;i<A.length;i++) {
			for(int j=i+1;j<A.length;j++) {
				dp[i][j] = dp[i][j-1] * A[j];
			}
		}
		int bx,ex;
		A[0] = dp[1][A.length-1];
		A[A.length-1] = dp[0][A.length-2];
		for(int i=1;i<A.length-1;i++) {
				bx = i-1; ex=i+1;
				A[i] = dp[0][bx] * dp[ex][A.length-1];
		}
		return A;
	}

}
