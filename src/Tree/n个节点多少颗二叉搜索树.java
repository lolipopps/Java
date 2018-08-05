package Tree;

public class n个节点多少颗二叉搜索树 {

	public static void main(String[] args) {
		numTrees(3);

	}

	/*
	 * 选取一个结点为根。可把结点分成左右子树，以这个结点为根的可行 二叉树数量就是左右子树可行二叉树数量的乘积所以总数量是将以全部结点为根的可行结果累加起来。
	 * 卡特兰数，这正是卡特兰数的一种定义方式。是一个典型的动态规划的定义方式。
	 * 
	 * 左子树只能由1,2,3...x-1构成，同理右子树由x+1,x+2...n构成，递归可求解
	 * 
	 * 卡特兰数的一半公式为Cn= 1/(n+1)*(2n,n) = (2n)!/{(n+1)!*n!}
	 */
	public static int numTrees(int n) {
		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 1;
		for (int k = 2; k <= n; ++k)
			for (int i = 1; i <= k; ++i)
				f[k] += f[i - 1] * f[k - i];
		System.out.println(f[n]);
		return f[n];
	}
	/*
	 *  def numTrees(self, n):
        if n == 0 or n == 1:
            return 1
        elif n ==2:
            return 2
        else:
            ans = 0
            for i in range(0,n):
                ans += self.numTrees(i)*self.numTrees(n-i-1)
            return ans
	 */
}
