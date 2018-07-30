package StringUtils;

import java.util.ArrayList;
import java.util.Stack;

public class Combinations {
	public static void main(String[] args) {
		// System.out.println(combinations(5, 3));
		System.out.println(combine("1234".toCharArray()));
	}

	// 求1到n共n个数字里k个数的组合数的所有情况
	// 要求出所有结果的集合，一般都是用DFS调用递归来解。
	public static ArrayList<ArrayList<Integer>> combinations(int n, int k) {
		ArrayList<ArrayList<Integer>> Result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		helper(n, k, 1, out, Result);
		return Result;

	}

	private static void helper(int n, int k, int level, ArrayList<Integer> out, ArrayList<ArrayList<Integer>> result) {
		// 相当于就是深度遍历只取前三位数的数据
		/*
		 * 总的概念就是循环递归 { 1 || for(2-5) helper out[1,] ||| for(2-5) help out[1,2,] |||| {
		 * 2 for(3-5) { out [1,2,3] return out [1,2,4] return out[1,2,5] return } 3
		 * for(4-5) { out [1,3,4] return out [1,3,5] return } 4 for(5) { out [1,4,5]
		 * return} 5 for() }
		 * 
		 * 2 || for(3-5) helper out[2,] ||| for(3-5) help out[2,3,] |||| { 3 for(4-5) {
		 * out [2,3,4] return out [2,3,5] return } 4 for(5) { out [2,4,5] return} 5
		 * for() } }
		 */
		if (out.size() == k) { // 满足情况 返回 其实不返回也是可以的效率低一点 比如 做了 1 2 3 ， 1 2 3 4 就不用考虑了
			ArrayList<Integer> out1 = new ArrayList<Integer>(); // 涉及到 java 的浅拷贝
			out1.addAll(out);
			result.add(out1);
			return;
		} else {
			for (int i = level; i <= n; ++i) { // 总共从第一位开始 一次递归后面所有的
				out.add(i);
				helper(n, k, i + 1, out, result);
				out.remove(out.size() - 1);
			}
		}
	}

	private static ArrayList<ArrayList<Character>> Allcombinations(String str) {
		ArrayList<ArrayList<Character>> Result = new ArrayList<ArrayList<Character>>();
		if (str == null || str.length() == 0) {
			return Result;
		}
		ArrayList<Character> out = new ArrayList<Character>();
		for (int i = 1; i <= str.length(); ++i) {
			helper1(str.toCharArray(), 0, i, Result, out);
		}
		return Result;
	}

	private static void helper1(char[] chArr, int begin, int size, ArrayList<ArrayList<Character>> list,
			ArrayList<Character> charList) {

		if (begin > chArr.length - size)
			return;
		if (size == 0) {
			ArrayList<Character> tempList = new ArrayList<Character>();
			for (Character ch : chArr) {
				tempList.add(ch);
			}
			list.add(tempList);
			return;
		}
		charList.add(chArr[begin]);
		helper1(chArr, begin + 1, size - 1, list, charList);
		charList.remove((Character) chArr[begin]);
		helper1(chArr, begin + 1, size, list, charList);
	}

	public static ArrayList<String> combine(char chs[]) {
		if (chs.length == 0)
			return null;
		ArrayList<String> result = new ArrayList<String>();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 1; i <= chs.length; i++) {
			combine(chs, 0, i, stack, result);// 传入  1234 0 1   1 代表有几个元素  第一次全部是 1
		}
		return result;
	}

	// 从字符数组中第begin个字符开始挑选number个字符加入stack中
	public static void combine(char[] chs, int begin, int number, Stack<Character> stack, ArrayList<String> result) {
		if (number == 0) {  // 没有元素了
			// System.out.println(stack.toString());
			result.add(stack.toString());  // 入结果集
			return;
		}
		if (begin == chs.length) {
			return;
		}
		stack.push(chs[begin]);
		combine(chs, begin + 1, number - 1, stack, result);
		stack.pop();
		combine(chs, begin + 1, number, stack, result);
	}
}
