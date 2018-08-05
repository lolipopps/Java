package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import com.sun.xml.internal.ws.util.NoCloseInputStream;

public class 树的深度 {

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
		System.out.println(findDeep(root1));
		System.out.println(findDeep2(root1));

	}
	
	//递归实现1
	  public static int findDeep(TreeNode root)
	  {
		  int deep = 0; 
		  if(root != null)
		  {
			  int lchilddeep = findDeep(root.left);
			  int rchilddeep = findDeep(root.right);
			  deep = lchilddeep > rchilddeep ? lchilddeep + 1 : rchilddeep + 1;
		  }
		  return deep;
	  }

	//非递归实现
	  public static int findDeep2(TreeNode root)
	  {
		 if(root == null)
			 return 0;
		 TreeNode current = null;
		 LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		 queue.offer(root);
		 int cur,last;
		 int level = 0;
		 while(!queue.isEmpty())
		 {
			 cur = 0;//记录本层已经遍历的节点个数
			 last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数
			 while(cur < last)//当还没有遍历到本层最后一个节点时循环
			 {
				 current = queue.poll();//出队一个元素
				 cur++;
				 //把当前节点的左右节点入队（如果存在的话）
				 if(current.left != null)
				 {
					 queue.offer(current.left);
				 }
				 if(current.right != null)
				 {
					 queue.offer(current.right);
				 }
			 }
			 level++;//每遍历完一层level+1
		 }
		 return level;
	  }
	

}
