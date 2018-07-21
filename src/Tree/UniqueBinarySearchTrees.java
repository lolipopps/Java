package Tree;
import java.util.ArrayList;
import java.util.List;


public class UniqueBinarySearchTrees {

	/*
	 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
二叉树的种数为卡特兰数，其通项公式如下：卡特兰数通项公式
从求解子问题的角度来看本题：
1. 选取一个结点为根，就把结点切成左右子树
2. 以这个结点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积
3. 所以总的数量是将以所有结点为根的可行结果累加起来。也就是上述公式。
	 */
	public static void main(String[] args) {
		System.out.println(numTrees(3));

	}
	// 递归版
	public static int numTrees(int n) {
		if(n<=1) return 1;
		int sum = 0;
		for(int i=1;i<=n;i++) {
			sum += numTrees(i-1) + numTrees(n-i-1);
		}
		return sum;
	}
	// 动态规划版
	
	public static int DpNumTree(int n) {
		int[] sum = new int[n+1];
		sum[0] = 1;
		sum[1] = 1;
		for(int i=2;i<=n;i++) {
			for(int j=0;i<i;j++) {
				sum[i] += sum[j] * sum[i-j-1];
			}
		}
		return sum[n];
	}

	
	
	
}
