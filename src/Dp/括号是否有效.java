package Dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class 括号是否有效 {

	public static void main(String[] args) {
		isValid("()(()){}");
		List<String> ress = removeInvalidParentheses("()())()");
		System.out.println(ress);
		List<String> ress2 = removeInvalidParentheses1("()())()");
		System.out.println(ress2);
		System.out.println(removeInvalidParentheses2("()()))()"));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		char[] chs = s.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '(' || chs[i] == '[' || chs[i] == '{')
				stack.push(chs[i]);
			else {
				if (stack.empty())
					return false;
				if (chs[i] == ')' && stack.peek() != '(')
					return false;
				if (chs[i] == ']' && stack.peek() != '[')
					return false;
				if (chs[i] == '}' && stack.peek() != '{')
					return false;
				stack.pop();
			}
		}
		return true;

	}

	// 移除最少的括号使得给定字符串为一个合法的含有括号的字符串
	/*
	 * 需要找出所有合法的取法。参考了网上大神的解法，这道题首先可以用BFS来解，我们先把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，
	 * 不合法的话，我们对其进行遍历，对于遇到的左右括号的字符，我们去掉括号字符生成一个新的字符串， 如果这个字符串之前没有遇到过，将其排入队中，
	 * 我们用哈希集合记录一个字符串是否出现过。我们对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集
	 */

	private static List<String> res = new ArrayList<String>();
	private static int max = 0;

	public static List<String> removeInvalidParentheses(String s) {
		dfs(s, "", 0, 0);
		if (res.size() == 0) {
			res.add("");
		}

		return res;
	}

	public static void dfs(String str, String subRes, int countLeft, int maxLeft) {
		if (str.length() == 0) {
			if (countLeft == 0 && subRes.length() != 0) {
				if (maxLeft > max) {
					max = maxLeft;
				}
				if (max == maxLeft && !res.contains(subRes)) {
					res.add(subRes.toString());
				}
			}
			return;
		}

		if (str.charAt(0) == '(') {
			dfs(str.substring(1), subRes.concat("("), countLeft + 1, maxLeft + 1);
			dfs(str.substring(1), subRes, countLeft, maxLeft);
		} else if (str.charAt(0) == ')') {
			if (countLeft > 0) {
				dfs(str.substring(1), subRes.concat(")"), countLeft - 1, maxLeft);
			}
			dfs(str.substring(1), subRes, countLeft, maxLeft);
		} else {
			dfs(str.substring(1), subRes.concat(String.valueOf(str.charAt(0))), countLeft, maxLeft);
		}
	}

	public static List<String> removeInvalidParentheses1(String s) { // 这个就相当于先判断 多了哪种括号 然后依次去一个 去两个一直到最后 类似于穷举法
		List<String> res = new ArrayList<String>();
		int cnt1 = 0, cnt2 = 0;
		for (char c : s.toCharArray()) {
			if (c == '(')
				cnt1++;
			else if (c == ')') {
				if (cnt1 == 0)
					cnt2++;
				else
					cnt1--;
			}
		}

		helper(s, 0, cnt1, cnt2, res);
		return res;
	}

	public static void helper(String s, int start, int cnt1, int cnt2, List<String> res) {

		if (cnt1 == 0 && cnt2 == 0) {

			if (isValid1(s))
				res.add(s);
			return;
		}
		for (int i = start; i < s.length(); ++i) {
			if (i != start && s.charAt(i) == s.charAt(i - 1)) // 相同的去掉第一个
				continue;
			if (cnt1 > 0 && s.charAt(i) == '(') {
				helper(s.substring(0, i) + s.substring(i + 1), i, cnt1 - 1, cnt2, res);
			}
			if (cnt2 > 0 && s.charAt(i) == ')') {
				helper(s.substring(0, i) + s.substring(i + 1), i, cnt1, cnt2 - 1, res); // 去掉地 i 个
			}
		}
	}

	static boolean isValid1(String t) {
		int cnt = 0;
		for (int i = 0; i < t.length(); ++i) {
			if (t.charAt(i) == '(')
				++cnt;
			else if (t.charAt(i) == ')' && --cnt < 0)
				return false;
		}
		return cnt == 0;
	}

	public static List<String> removeInvalidParentheses2(String s) {
		Set<String> visited = new HashSet<String>();
		List<String> result = new ArrayList<String>();
		List<String> current = new ArrayList<String>();
		List<String> next;
		current.add(s);
		System.out.println(current);
		boolean reached = false;
		// BFS
		/*
		 * 看到parenthese的问题，第一反应是用栈。这题要求minimum number，所以想到用BFS遍历解空间树。
		 * 
		 * 思路为：
		 * 
		 * 层次依次为删除0个元素，1个元素，2个元素。。。
		 * 
		 * 层次遍历所有的可能。如果有一种可能是valid，那么不再遍历下面的层。
		 */
		while (!current.isEmpty()) {
			next = new ArrayList<String>();
			for (String prev : current) {
              // 依次删除一个 两个
				visited.add(prev);
				System.out.println("visited " + visited);
				// If valid
				if (isValid1(prev)) {
					reached = true;
					result.add(prev);
				}

				// If not reached, then delete
				if (!reached) {
					for (int i = 0; i < prev.length(); i++) {
						char tmp = prev.charAt(i);
						if (tmp != '(' && tmp != ')') {
							continue;
						}
						String newStr = prev.substring(0, i) + prev.substring(i + 1);
						if (!visited.contains(newStr)) {
							next.add(newStr);
							visited.add(newStr);
						}
					}
				}
			}
			if (reached) {
				break;
			}
			current = next;
		}
		return result;
	}

}
