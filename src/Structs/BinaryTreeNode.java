package Structs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeNode {
	private int data;
	private BinaryTreeNode left;
	private BinaryTreeNode right;

	public int getData() {
		return this.data;
	}

	public BinaryTreeNode getLeft() {
		return this.left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public BinaryTreeNode getRight() {
		return this.right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	void PreOrder(BinaryTreeNode root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
		}

	}

	void PreOrderNoRecur(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			while (root != null) {
				stack.push(root);
				System.out.print(root.getData() + " ");
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			root = root.getRight();
		}
	}

	void InOrder(BinaryTreeNode root) {
		if (root != null) {
			InOrder(root.getLeft());
			System.out.print(root.getData() + " ");
			InOrder(root.getRight());
		}

	}

	void InOrderNoRecur(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty()) {
				break;
			}
			root = stack.pop();
			System.out.print(root.getData() + " ");
			root = root.getRight();
		}
	}

	void PostOrder(BinaryTreeNode root) {
		if (root != null) {
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.print(root.getData() + " ");
		}

	}

	void PostOrderNoRecur(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = root;
		BinaryTreeNode lastVisit = root;
		while (true) {
			while (node != null) { // 这里左孩子入栈 入到左子节点的最后一个为止
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.isEmpty()) {
				return;
			}
			node = stack.peek();
			if (node.right == null || node.right == lastVisit) { // 当前的节点没有右节点或者右节点刚刚被访问了
				System.out.print(node.getData() + " ");
				stack.pop();
				lastVisit = node;
				node = null;
			} else {
				node = node.right;
			}
		}
	}

	public void LevelOrder(BinaryTreeNode root) {
		if (root == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp;
		queue.add(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp.getData() + " ");
			if (temp.getLeft() != null)
				queue.add(temp.getLeft());
			if (temp.getRight() != null)
				queue.add(temp.getRight());
		}

	}

	public int FindMax(BinaryTreeNode root) {
		int root_val, left, right, max = -1;
		if (root != null) {
			root_val = root.getData();
			left = FindMax(root.left);
			right = FindMax(root.right);
			if (left > right) {
				max = left;
			} else {
				max = right;
			}
			if (root_val > max) {
				max = root_val;
			}
		}
		return max;
	}

}
