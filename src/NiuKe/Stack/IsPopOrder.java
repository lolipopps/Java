package NiuKe.Stack;

import java.util.HashMap;
import java.util.Stack;

public class IsPopOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPopOrder1(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 }));

	}

	public static boolean isPopOrder(int[] pre, int[] fix) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < pre.length; i++) {
			map.put(pre[i], i);
		}
		for (int i = 0; i < fix.length; i++) {
			int temp = getPost(pre, fix[i]);
			if (temp == -1) {
				return false;
			}

		}
		return false;

	}

	public static int getPost(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isPopOrder1(int[] pre, int[] fix) {
		if (pre.length == 0) {
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(pre[0]);
		int i = 0;
		int now = 1;
		int length = 0;
		while (!stack.isEmpty()) {
			length = stack.size();
			if (stack.peek() == fix[i]) {
				i++;
				stack.pop();
			} else {
				if (now < pre.length) {
					stack.push(pre[now]);
					now++;
				}
				if(length == stack.size()) {
					return false;
				}
			}

		}
		return true;

	}

}
