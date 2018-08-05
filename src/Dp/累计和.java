package Dp;

public class 累计和 {

	public static void main(String[] args) {
		System.out.println(Sum_Solution(10));

	}
	public static int Sum_Solution(int n) {
		int res = 0;
		if(n<=0) {
			return 0;
		} 
		if(n==1) {
			return 1;
		}
		res = n + Sum_Solution(n-1);
		return res;
    }

}
