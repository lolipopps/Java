package Structs;

import java.awt.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinTree {
	static int preIndex = 0;
	public int val;
	public BinTree left;
	public BinTree right;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public BinTree getLeft() {
		return left;
	}

	public void setLeft(BinTree left) {
		this.left = left;
	}

	public BinTree getRight() {
		return right;
	}

	public void setRight(BinTree right) {
		this.right = right;
	}

	public BinTree(int num) {
		val = num;
		left = null;
		right = null;
	}

	public BinTree() {
	}

	public static BinTree buildTree(int[] preorder, int[] inorder, int start, int end) { // 按照先序中序列建树
		// 1 2 3 5 6 4 7 8 9 preorder 2 5 3 6 1 7 8 4 9 inorder

		BinTree newNode = new BinTree();
		if (start > end) {
			return null;
		}
		; // 当出现没有孩子节点的时候
		newNode.setVal(preorder[preIndex]);
		preIndex++;
		if (start == end) {
			return newNode;
		}
		int inIndex = Search(inorder, start, end, newNode.getVal());
		System.out.println(newNode.getVal() + " " + start + " " + inIndex + " " + end);

		newNode.setLeft(buildTree(preorder, inorder, start, inIndex - 1));

		newNode.setRight(buildTree(preorder, inorder, inIndex + 1, end));
		return newNode;
	}

	private static int Search(int[] pre, int start, int end, int val2) {
		for (int i = start; i <= end; i++) {
			if (pre[i] == val2)
				return i;
		}
		return 0;
	}

	public static BinTree buildPreTree(Integer[] list) {
		LinkedList<BinTree> nodeList = new LinkedList<BinTree>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < list.length; nodeIndex++) {
			if (list[nodeIndex] == null) {
				nodeList.add(null);
			} else {
				nodeList.add(new BinTree(list[nodeIndex]));
			}

		}

		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < list.length / 2 - 1; parentIndex++) {
			if (nodeList.get(parentIndex) != null) { // 自身节点不为空
				// 左孩子
				nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
				// 右孩子
				nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
			}
		}

		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = list.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (list.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
		}
		return nodeList.get(0);
	}

	public static void DFSPre(BinTree root) { // 先入栈再说
		if (root == null) {
			return;
		}
		Stack<BinTree> stack = new Stack<BinTree>();
		while (true) {
			while (root != null) {
				System.out.print(root.val + " "); // 输出根节点
				stack.push(root); // 左孩子入栈
				root = root.left;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop(); // 输出没有左孩子的 判断是否有右孩子
			root = root.right;
		}
	}

	public static void DFSIn(BinTree root) {
		if (root == null) {
			return;
		}
		Stack<BinTree> stack = new Stack<BinTree>();
		while (true) {
			while (root != null) {
				stack.push(root); // 左孩子入栈
				root = root.left;
			}
			if (stack.isEmpty())
				break;
			root = stack.pop(); // 输出没有左孩子的 判断是否有右孩子
			System.out.println(root.val); // 从最左边的孩子输出
			root = root.right;
		}
	}

	public static void DFSPost(BinTree root) {
		if (root == null) {
			return;
		}
		Stack<BinTree> stack = new Stack<BinTree>();
		while (true) {
			if (root != null) { // 这里都不会变 都是找到最下左边的节点
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				else {
					if (stack.peek().getRight() == null) { // 当找到第一个没有左孩子的节点 判断有没有右孩子
						root = stack.pop();
						System.out.print(root.val + " "); // 没有直接这个节点出来 之后再判断他的父节点有没有右孩子节点
						while (!stack.isEmpty() && root == stack.peek().getRight()) {
							System.out.print(stack.peek().val + " "); // 目前 stack peek 是3
							root = stack.pop(); // 出来变成了2
						}
					}
					if (stack.isEmpty())
						break;
					else
						root = stack.peek().getRight(); // 不管有没有进入右孩子 自己先不出来

				}
			}
		}
	}

	public static void BFS(BinTree root) {
		if (root == null) {
			return;
		}
		Queue<BinTree> queue = new LinkedList<BinTree>();

		queue.add(root);

		while (!queue.isEmpty()) {
			BinTree temp = queue.poll();
			System.out.print(temp.val + " ");
			if (temp.left != null) {
				queue.add(temp.left);
			}
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
	}

	public static void Inorder(BinTree root) {
		if (root != null) {
			Inorder(root.left);
			System.out.print(root.val + " ");
			Inorder(root.right);
		}
	}

	public static void Preorder(BinTree root) {
		if (root != null) {
			System.out.print(root.val + " ");
			Preorder(root.left);
			Preorder(root.right);
		}
	}

	public static void Postorder(BinTree root) {
		if (root != null) {
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root.val + " ");
		}
	}

	public static void main(String[] args) {
		// Integer[] num = new Integer[] { 1, null, 3, null, null, 4, 5, null, null,
		// null, null, 7, 8, 9, 10 };
		// BinTree root = buildPreTree(num);
		// Inorder(root);
		// System.out.println();
		// Preorder(root);
		// System.out.println();
		// Postorder(root);
		// System.out.println();
		int[] preorder = new int[] { 1, 2, 4, 8, 5, 9, 3, 6, 7, 10 };
		int[] inorder = new int[] { 4, 8, 2, 5, 9, 1, 6, 3, 10, 7 };
		BinTree root = buildTree(preorder, inorder, 0, preorder.length - 1);
		// 1 2 3 5 6 4 7 8 9 中序 2 5 3 6 1 7 8 4 9
		Inorder(root);
		System.out.println();
		BFS(root);
		System.out.println();
		DFSPre(root);
		System.out.println();
		DFSPost(root);
		System.out.println();
		Postorder(root);

	}

}
