package Tree;

public class 二叉树是否是平衡二叉树 {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(10);
		root1.left.left = new TreeNode(5);
		root1.left.right = new TreeNode(7);
		root1.right.left = new TreeNode(9);
		root1.right.right = new TreeNode(11);
		root1.right.right.left = new TreeNode(13);
		root1.right.right.left.right = new TreeNode(19);
		System.out.println(isBalanced(root1));
	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int depthOfLeft = getDepth(root.left, 1);
		int depthOfRight = getDepth(root.right, 1);

		if (Math.abs(depthOfRight - depthOfLeft) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	private static int getDepth(TreeNode tree, int currentDepth) {
		if (tree == null) {
			return currentDepth;
		}
		return Math.max(getDepth(tree.left, currentDepth + 1), getDepth(tree.right, currentDepth + 1));
	}
}
