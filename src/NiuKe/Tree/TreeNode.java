package NiuKe.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
	public void pdfs(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.val);
		pdfs(root.left);
		pdfs(root.right);
		
	}
	public void bfs(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> stack =new  LinkedList<TreeNode>();
		stack.add(root);
		TreeNode temp = null;
		while(!stack.isEmpty()) {
			temp = stack.poll();
			result.add(temp.val);
			if(temp.left != null) { stack.add(temp.left);}
			if(temp.right != null) { stack.add(temp.right);}
		}
		for(Integer i:result) {
			System.out.println(i);
		}
		
	}
}