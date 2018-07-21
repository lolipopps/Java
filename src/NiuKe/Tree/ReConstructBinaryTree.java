package NiuKe.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReConstructBinaryTree {
	public static void main(String[] args) {
		TreeNode tree = reConstructBinaryTree(new int[] { 1, 2, 4, 7, 3, 5, 6, 8 },
				new int[] { 4, 7, 2, 1, 5, 3, 8, 6 });
		dfs(tree);
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(pre[0]);
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, findPost(in, pre[0])),
				Arrays.copyOfRange(in, 0, findPost(in, pre[0]) - 1));
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, findPost(in, pre[0]), pre.length),
				Arrays.copyOfRange(in, findPost(in, pre[0]), in.length));
		return root;

	}

	public static int findPost(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		dfs(root.left);
		dfs(root.right);
	}
}
