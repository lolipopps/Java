package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

public class One_Five {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}



	public static void main(String[] args) {
		System.out.println(
				Find(11, new int[][] { { 1, 2, 3, 4, 5, 7, 9 }, { 3, 4, 5, 6, 7, 8, 9 }, { 5, 6, 7, 8, 9, 10, 13 } }));
		System.out.println(rePlace(new StringBuffer("\"\"")));
		
	}

	public static boolean Find(int target, int[][] array) { // Ѱ�� ���ֵ ���Դ����½� ��ʼ С�����������ұ�
		if (array.length < 1) {
			return false;
		}
		int i = array.length - 1;
		int j = 0;
		while (i >= 0 && j <= array[0].length - 1) {
			if (array[i][j] == target) {
				return true;
			} else if (array[i][j] > target) {
				i--;
			} else {
				j++;
			}
		}

		return false;

	}

	public static String rePlace(StringBuffer str) {
		int[] post = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			post[i] = -1;
		}
		int number = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				post[number] = i;
				number++;
			}
		}
		number = 0;
		while (post[number] != -1) {
			System.out.println(post[number] + number * 2);
			str.replace(post[number] + number * 2, post[number] + number * 2 + 1, "%20");
			number++;
		}
		return str.toString();

	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();
		ListNode temp = listNode;
		while (temp != null) {
			stack.push(temp.val);
			listNode = listNode.next;
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (!stack.empty()) {
			arrayList.add(stack.pop());

		}
		return arrayList;
	}



}