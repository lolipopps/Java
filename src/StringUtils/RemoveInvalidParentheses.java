package StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	/*
	 * 移除最少的括号使得给定字符串为一个合法的含有括号的字符串 "()())()" -> ["()()()", "(())()"] "(a)())()" ->
	 * ["(a)()()", "(a())()"] ")(" -> [""]
	 * 
	 * 队列先进先出 用BFS来解，我们先把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，不合法的话，我们对其进行遍历，对于遇到的左右括号的字符，
	 * 我们去掉括号字符生成一个新的字符串，如果这个字符串之前没有遇到过，将其排入队中，我们用哈希集合记录一个字符串是否出现过。
	 * 我们对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集 思路是 因为 (()()) 中间两个括号属于同一层
	 * 
	 * 最好的解法
	 * 
	 * 先从题目中给的例子入手：()())() 当遍历到第五个括号时，我们发现这个括号的存在非法。因此我们会从当前的三个右括号（下标分别为1, 3,
	 * 4）中选择一个删去。那么选择哪个呢？、 其实选择任意一个右括号都可以使当前的的子字符串合法，并依次生成如下三个结果(())，()()，()()。
	 * 最后两个结果重复，因此只保留(())，()()两个结果。最终生成的合法字符串为[()()(),
	 * (())()]。这里说明了一种情况，即右括号的数量多于左括号的数量。
	 * 那么如何处理左括号的数量多于右括号数量的场景呢？如()(()其实，我们只需要将其倒置为)(()(，
	 * 并且将)(视为一组合法的括号即可。这时我们会看见下标2上的左括号不合法，对之进行处理即可。方法相同于上一种情况。
	 * 
	 * 
	 * 但是还有一种情况是包含了多余的左括号，一种直观的方法是从右向左再按照上面的方法处理一遍左括号． 但是将数组逆置之后就可以重用上面的算法了．
	 */
	public static void main(String[] args) {
		LinkedList<String> Results = RemoveInvalidParentheses("())())()");
		for (String S : Results) {
			System.out.println(S);
		}
	}

	// BFS 的方法
	public static LinkedList<String> RemoveInvalidParentheses(String s) {
		LinkedList<String> res = new LinkedList<>();
		if (s == null) {
			return res;
		}
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		queue.offer(s); //全部进队列
		boolean foundResult = false;

		while (!queue.isEmpty()) {
			s = queue.poll(); // 全部出队列
			if (isValid(s)) {  // 判断 (和)的个数是否相等
				res.add(s);
				foundResult = true;
			}
			if (foundResult) {
				continue;
			}
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(' || c == ')') {
					String t = s.substring(0, i) + s.substring(i + 1); // 去掉一个 符号  ()())()  存在去掉一个符号后满足   foundResult 就在这一层满足了
					if (!visited.contains(t)) {
						queue.offer(t);
						visited.add(t);
					}
				}
			}
		}

		return (LinkedList<String>) res;
	}

	private static boolean isValid(String s) {  // 最简单的判断有没有效是通过左括号的个数不能比右括号少
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				leftCount++;
			} else if (c == ')') {
				leftCount--;
			}
			if (leftCount < 0) {
				return false;
			}
		}

		return leftCount == 0;
	}

	// DFS 的方法
	public List<String> removeInvalidParentheses3(String s) {
		List<String> result = new ArrayList<String>();
		removeInvalidParentheses3(s, result, 0, 0, new char[] { '(', ')' });
		return result;
	}

	public void removeInvalidParentheses3(String s, List<String> result, int lastRemoveIndex, int lastCheckedIndex,
			char[] pattern) {
		for (int stack = 0, i = lastCheckedIndex; i < s.length(); i++) {
			int cur = s.charAt(i);
			if (cur == pattern[0])
				stack++;
			if (cur == pattern[1])
				stack--;
			if (stack >= 0)
				continue;
			for (int j = lastRemoveIndex; j <= i; j++) { // 最后一次删除的下标为3 找到了 第一次右括号比左括号多的地方 ()()())() i=4
				// 找到出现两次 ))的地方或者上次删掉的地方 或者这次要删的最远的地方 removeInvalidParentheses3 变成了 (())()
				// ()()()
				if (s.charAt(j) == pattern[1] && (j == lastRemoveIndex || s.charAt(j - 1) != pattern[1])) {
					removeInvalidParentheses3(s.substring(0, j) + s.substring(j + 1), result, j, i, pattern);
				}
			}
			return;
		}
		String reversed = new StringBuilder(s).reverse().toString();
		if (pattern[0] == '(') {
			removeInvalidParentheses3(reversed, result, 0, 0, new char[] { ')', '(' });
		} else {
			result.add(reversed);
		}
	}
}