package Tree;

public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		public void Inorder(TreeNode root) {
			if(root != null) {
				System.out.print(root.val+"  ");
				Inorder(root.left);
				Inorder(root.right);
			}
		}
}
