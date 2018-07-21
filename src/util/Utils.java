package util;

public class Utils {
	public class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	 public class TreeNode { 
	     int val;
	     public TreeNode left;
	     public TreeNode right;
	     public TreeNode(int x) { val = x; }
	     public void predfs(TreeNode root) {
	    	 if(root==null) {
	    		 return;
	    	 }
	    	 System.out.println(root.val);
	    	 root.predfs(root.left);
	    	 root.predfs(root.right);
	     }
	     public void indfs(TreeNode root) {
	    	 if(root==null) {
	    		 return;
	    	 }
	    	 
	    	 root.indfs(root.left);
	    	 System.out.println(root.val);
	    	 root.indfs(root.right);
	     }
	 }
	 public TreeNode getTreeNode(int val) {
		 TreeNode node = new TreeNode(val);
		return node;
	 }
	
	public ListNode getList(int[] a) {
		ListNode temp;
		ListNode A = null;
		Utils utils = new Utils();
		if (a.length == 0) {
			return A;
		} else {
			A = utils.new ListNode(a[0]);
			if(a.length ==1) {
			return A;
			}
		}
        temp = A;
		for (int i = 1; i < a.length; i++) {
			ListNode now = utils.new ListNode(a[i]);
			temp.next = now;
			temp = temp.next;
		}
		return A;

	}

	public void show(ListNode node,int i) {
		ListNode temp;
		temp = node;
		if(i==1)
			temp = temp.next;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int[][] getSortedArray(int n,int m){
		int[][] number = new int[n][m];
		return number;
	}
}
