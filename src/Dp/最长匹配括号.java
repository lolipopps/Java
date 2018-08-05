package Dp;

/*
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

   For "(()", the longest valid parentheses substring is "()", which has length = 2.

   Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 */
public class 最长匹配括号 {
	public static void main(String[] args) {
		String string = "()()(())())";
		int a = longestValidParentheses1(string);
		System.out.println(a);
	}

	public static int longestValidParentheses1(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}
}
