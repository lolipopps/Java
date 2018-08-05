package GreedyAndBack;

import java.util.ArrayList;
import java.util.List;

public class IP切割 {

	public static void main(String[] args) {
		restoreIpAddresses("25525511135");

	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		helper(s, 0, "", res);
		return res;
	}

	public static void helper(String s, int n, String out, List<String> res) { // s 当前剩余的字符串    n 代表第几个切割.  out 前一个ip段
		System.out.println(s+" "+n+" "+out);
		if (n == 4) {
			if (s.isEmpty())
				res.add(out);
			return;
		}
		for (int k = 1; k < 4; ++k) {  // 一个长度最多为3 循环嵌套 递归 一般的回溯
			if (s.length() < k)
				break;
			int val = Integer.parseInt(s.substring(0, k));
			if (val > 255 || k != String.valueOf(val).length())
				continue;
			helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
		}
	}
}
