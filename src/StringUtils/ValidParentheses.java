package StringUtils;

import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println(isValid("(){]}([])"));
	}
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(char i:s.toCharArray()) {
			if(i == '(' || i=='{' || i=='[') stack.push(i);
			if(i==')' && stack.pop() !='(') return false;
			if(i=='}' && stack.pop() !='{' ) return false;
			if(i==']' && stack.pop() !='[' ) return false;
	}
		return true;
	}

}
