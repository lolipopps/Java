package StringUtils;
import java.util.ArrayList;
import java.util.LinkedList;

public class DiffWaysToCompute {
/*
Example 1
Input: "2-1-1".
((2-1)-1) = 0
(2-(1-1)) = 2

Output: [0, 2]
Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Output: [-34, -14, -10, -10, 10]

这道题让给我们一个可能含有加减乘的表达式，让我们在任意位置添加括号，求出所有可能表达式的不同值。
这道题跟之前的那道Unique Binary Search Trees II 独一无二的二叉搜索树之二用的方法一样，用递归来解，划分左右子树，递归构造。
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static LinkedList<Integer> diffWaysToCompute(String input) {
		 	LinkedList<Integer> res = new LinkedList<Integer>();;
	        for (int i = 0; i < input.length(); ++i) {
	            if (input.toCharArray()[i] == '+' || input.toCharArray()[i] == '-' || input.toCharArray()[i] == '*') {
	            	LinkedList<Integer> left = diffWaysToCompute(input.substring(0, i));
	            	LinkedList<Integer> right = diffWaysToCompute(input.substring(i + 1));
	                for (int j = 0; j < left.size(); ++j) {
	                    for (int k = 0; k < right.size(); ++k) {
	                        if (input.toCharArray()[i] == '+') res.add(left.get(j) + right.get(k));
	                        else if (input.toCharArray()[i] == '-') res.addLast(left.get(j) - right.get(k));
	                        else res.addLast(left.get(j) * right.get(k));
	                    }
	                }
	            }
	        }
	        if (res.isEmpty()) res.addLast(Integer.parseInt(input));
	        return res;
	    }

}
