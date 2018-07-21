package Structs;

public class BinaryTree {
	
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = init();
		binaryTreeNode.PreOrder(binaryTreeNode);
		System.out.println();
		binaryTreeNode.PreOrderNoRecur(binaryTreeNode);
		System.out.println();
		binaryTreeNode.InOrder(binaryTreeNode);
		System.out.println();
		binaryTreeNode.InOrderNoRecur(binaryTreeNode);
		System.out.println();
		binaryTreeNode.PostOrder(binaryTreeNode);
		System.out.println();
		binaryTreeNode.PostOrderNoRecur(binaryTreeNode);
		System.out.println();
		binaryTreeNode.LevelOrder(binaryTreeNode);
		System.out.println();
		System.out.println(binaryTreeNode.FindMax(binaryTreeNode));
		
	}
	public static BinaryTreeNode init() {
		BinaryTreeNode i = new BinaryTreeNode(10,null , null);
		BinaryTreeNode j = new BinaryTreeNode(9,null , null);
		BinaryTreeNode h = new BinaryTreeNode(8,null , null);
		BinaryTreeNode g = new BinaryTreeNode(7, null, null);
		BinaryTreeNode f = new BinaryTreeNode(6, null, null);
		BinaryTreeNode e = new BinaryTreeNode(5, null, g);
		BinaryTreeNode d = new BinaryTreeNode(4, h, null);
		BinaryTreeNode c = new BinaryTreeNode(3, e, f);
		BinaryTreeNode b = new BinaryTreeNode(2, d, null);
		BinaryTreeNode a = new BinaryTreeNode(1, b, c);
		return a;
	}
	

}
