package StringUtils;

import java.util.Stack;

public class LongestValidParentheses {
	/*
	 * For "(()", the longest valid parentheses substring is "()", which has length
	 * = 2.
	 * 
	 * Another example is ")()())", where the longest valid parentheses substring is
	 * "()()", which has length = 4.
	 */
	public static void main(String[] args) {
		System.out.println(longestValidParentheses(")((())(("));
		System.out.println(DplongestValidParentheses("()((()))(("));

	}

	public static int longestValidParentheses(String s) {
		int res = 0, start = 0;
		Stack<Integer> m = new Stack<Integer>();
		for (int i = 0; i < s.length(); ++i) {
			if (s.toCharArray()[i] == '(')
				m.push(i);
			else if (s.toCharArray()[i] == ')') {
				if (m.empty())
					start = i + 1;  // start 记录有效的开始位置
				else {
					m.pop();
					res = m.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - m.peek()); 
				// 空了的时候证明 ()括号匹配完了  不空的时候证明 (还有剩余还能满足 回溯到以前的位置
				}
			}
		}
		return res;
	}
	
	
	 static int DplongestValidParentheses(String str)   
	    {  
	        int result=0;  
	        str = ')' + str;
	        char[] s = str.toCharArray();  
	        int[] dp = new int[str.length()];
	        for(int i=1;i<s.length;i++)  
	        {  
	            if(s[i]==')')  //  只有当 出现 ) 的时候 才和前面的去配对 
	            {  
	                if(s[i-1-dp[i-1]]=='(') dp[i]=dp[i-1]+2;  // dp[i-1] 存的是之前最长的有效序列   要把已经配对好的最长序列拿掉  
	                //如果当前字符和除掉已经最长的位置，并不是 dp[i] 存的就是最终结果 相当于引入了一个变量
	                dp[i]+=dp[i-dp[i]];  
	            }  
	            result=Math.max(result,dp[i]);  // 而外多一个 result 存结果
	        }  
	        return result;  
	    }  
}
