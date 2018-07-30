package Tree;

public class Mirror {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(10);
		root1.left.left = new TreeNode(5);
		root1.left.right = new TreeNode(7);
		root1.right.left = new TreeNode(9);
		root1.right.right= new TreeNode(11);
		root1.pdfs(root1);
		mirror(root1);
		System.out.println("---------------");
		root1.pdfs(root1);

	}

	public static void mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);

	}

}
