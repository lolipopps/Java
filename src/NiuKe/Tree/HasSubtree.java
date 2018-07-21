package NiuKe.Tree;

public class HasSubtree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.right.left = new TreeNode(6);

		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(5);
		root2.left.left = new TreeNode(3);
		root2.right.right = new TreeNode(4);
		System.out.println(hasSubtree(root1, root2));

	}

	public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
		StringBuffer root1P = new StringBuffer("");
		StringBuffer root1M = new StringBuffer("");
		StringBuffer root2P = new StringBuffer("");
		StringBuffer root2M = new StringBuffer("");
		if (root1 == null || root2 == null) {
			return false;
		}
		dfsp(root1, root1P);
		dfsp(root2, root2P);
		System.out.println(root1P + "  " + root2P);
		int length = root1P.length() < root2P.length() ? root1P.length() : root2P.length();
		if(length != LCS(root1P.toString(),root2P.toString())){
			return false;
		}

		System.out.println("yes");
		dfsm(root1, root1M);
		dfsm(root2, root2M);
		System.out.println(root1M + "  " + root2M);
		if(length != LCS(root1M.toString(),root2M.toString())){
			return false;
		}else {
			return true;
		}

	}
	
	
    //求解str1 和 str2 的最长公共子序列
    public static int LCS(String str1, String str2){
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        for(int row = 0; row <= str1.length(); row++)
            c[row][0] = 0;
        for(int column = 0; column <= str2.length(); column++)
            c[0][column] = 0;
        
        for(int i = 1; i <= str1.length(); i++)
            for(int j = 1; j <= str2.length(); j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else if(c[i][j-1] > c[i-1][j])
                    c[i][j] = c[i][j-1];
                else
                    c[i][j] = c[i-1][j];
            }
        return c[str1.length()][str2.length()];
    }
    

	public static void dfsp(TreeNode root1, StringBuffer str) {
		if (root1 == null) {
			return;
		}
		str = str.append(String.valueOf(root1.val));
		dfsp(root1.left, str);
		dfsp(root1.right, str);
	}

	public static void dfsm(TreeNode root1, StringBuffer str) {
		if (root1 == null) {
			return;
		}
		dfsm(root1.left, str);
		str = str.append(String.valueOf(root1.val));
		dfsm(root1.right, str);
	}

}
