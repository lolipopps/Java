package StringUtils;

import java.util.ArrayList;

import java.util.HashSet;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Permutation {

	public static void main(String[] args) {
		System.out.println("下一个是: " + nextPermutation("127831")); // 下一个应该是 723468
		System.out.println("是否是下一个: " + isPermutation("127831", "128137"));
		System.out.println("组成元素是否相同: " + isSame("abcd", "aacd"));
		System.out.println("获取第n个全排序: " + getPermutation(5, 20));
		System.out.println(permutations("123"));
		System.out.println(permutations11("aab"));
		System.out.println(permuteUnique("abc"));
	}

	public static HashSet<ArrayList<Integer>> permuteUnique(String strs){
		char[] chars = strs.toCharArray();
		HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		int[] visited = new int[strs.length()];
		permuteUniqueDFS(chars, 0, visited, out, result);
		return result;
	}
	private static void permuteUniqueDFS(char[] chars, int level, int[] visited, ArrayList<Integer> out,
			HashSet<ArrayList<Integer>> result) {
		if (level == chars.length) {
			ArrayList<Integer> out1 = new ArrayList<Integer>();
			out1.addAll(out);
			result.add(out1);
		} else {
			for (int i = 0; i < chars.length; ++i) {
				if (visited[i] == 0) {
					 if (i > 0 && chars[i] == chars[i - 1] && visited[i - 1] == 0) continue;
					visited[i] = 1;
					out.add((int) chars[i] - '0');
					permuteUniqueDFS(chars, level + 1, visited, out, result);
					out.remove(out.size() - 1);
					visited[i] = 0;
				}
			}
		}

		
	}

	public static ArrayList<ArrayList<Integer>> permutations(String strs) {
		char[] chars = strs.toCharArray();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> out = new ArrayList<Integer>();
		int[] visited = new int[strs.length()];
		permuteDFS(chars, 0, visited, out, result);
		return result;
	}

	// 思路 和 Combinations 是一样的
	private static void permuteDFS(char[] chars, int level, int[] visited, ArrayList<Integer> out,
			ArrayList<ArrayList<Integer>> result) {
		if (level == chars.length) {
			ArrayList<Integer> out1 = new ArrayList<Integer>();
			out1.addAll(out);
			result.add(out1);
		} else {
			for (int i = 0; i < chars.length; ++i) {
				if (visited[i] == 0) {
					visited[i] = 1;
					out.add((int) chars[i] - '0');
					permuteDFS(chars, level + 1, visited, out, result);
					out.remove(out.size() - 1);
					visited[i] = 0;
				}
			}
		}

	}
	
	
	
	public static ArrayList<String> permutations11(String strs) {
		HashSet<String> result = new HashSet<String>();
		ArrayList<String> res = new ArrayList<String>();
		if(strs.length()==0 || strs.replaceAll("\"", "").length()==0) {
			return res;
		}
		char[] chars = strs.toCharArray();
		ArrayList<Character> out = new ArrayList<Character>();
		int[] visited = new int[strs.length()];
		permuteDFS1(chars, 0, visited, out, result);
		

		res.addAll(result);
		 
		return res;
	}

	// 思路 和 Combinations 是一样的
	private static void permuteDFS1(char[] chars, int level, int[] visited, ArrayList<Character> out,
			HashSet<String> result) {
		if (level == chars.length) {
			String temp  = "";
			for(Character ch:out) {
				temp=temp+ch;
			}
			result.add(temp);
		} else {
			for (int i = 0; i < chars.length; ++i) {
				if (visited[i] == 0) {
					visited[i] = 1;
					out.add(chars[i]);
					permuteDFS1(chars, level + 1, visited, out, result);
					out.remove(out.size() - 1);
					visited[i] = 0;
				}
			}
		}

	}
	

	public static ArrayList<ArrayList<Integer>> permutations1(String strs) {
		char[] chars = strs.toCharArray();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		permuteDFS1(chars, 0, res);
		return res;
	}

	private static void permuteDFS1(char[] chars, int start, ArrayList<ArrayList<Integer>> res) {
		if (start >= chars.length) {
			ArrayList<Integer> out1 = new ArrayList<Integer>();
			for (char ch : chars) {
				out1.add((int) ch-'0');
			}
			res.add(out1);
		}
		;
		for (int i = start; i < chars.length; ++i) {
			char temp = chars[start];
			chars[start] = chars[i];
			chars[i] = temp;
			permuteDFS1(chars, start + 1, res);
			temp = chars[start];
			chars[start] = chars[i];
			chars[i] = temp;
		}

	}

	// 找下一个排序 找到比当前大一点点的数 要找到比当前大一点点的数只需要找到当前 最右边的数 看有没有还有比他大的数 有的话找到第一个替换即可
	// 比如 124356 找到的应该是 5 因为 在最右边 6 比 5 大 反着算 从最后算找到第一个比他小的数据 替换即可
	public static String nextPermutation(String strs) {
		char[] chars = strs.toCharArray();
		int j = 0;
		for (int i = chars.length - 2; i >= 0; i--) {
			if (chars[i + 1] > chars[i]) {
				for (j = chars.length - 1; j > i; --j) {
					if (chars[j] > chars[i])
						break;
				}
				char temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
				StringUtils.swap(chars, i + 1, chars.length - 1);
				return charsToString(chars);
			}

		}
		return charsToString(StringUtils.swap(chars, 1, chars.length - 1));

	}

	public static String Permutation(char[] chars) {
		return null;
	}

	public static String charsToString(char[] chs) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < chs.length; i++) {
			stringBuffer.append(chs[i]);
		}
		return stringBuffer.toString();
	}

	// 判断两个字符串是不是全排列
	public static boolean isPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		String temp = "";
		if (s1.compareTo(s2) < 0) { // s1 是s2 的后一个
			temp = s1;
			s1 = s2;
			s2 = temp;
		}
		// 保证 s1 大于 s2
		if (s1.equals(nextPermutation(s2))) {
			return true;
		} else {
			return false;
		}
	}

	// 判断字符转的元素是否一致
	public static boolean isSame(String s1, String s2) {
		int[] map = new int[128];
		if (s1.length() != s2.length()) {
			return false;
		}
		for (char ch : s1.toCharArray()) {
			map[(int) ch]++;
		}
		for (char ch : s2.toCharArray()) {
			map[(int) ch]--;
			if (map[(int) ch] < 0) {
				return false;
			}
		}
		return true;

	}

	// 阶乘
	public static int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++)
			result *= i;
		return result;
	}

	// 获取全排列的第 n 个数
	public static String getPermutation(int n, int k) {
		boolean[] num = new boolean[n + 1];
		char[] result = new char[n];
		k = k - 1;
		for (int i = 0; i <= n; i++) {
			num[i] = false;
			// result[i] = (char) (i+'1');
		}

		int temp = 0; // 用来记录第几个有用
		int j = 0;
		for (int i = 0; i < n; i++) {
			temp = k / factorial(n - i - 1); // 求得的是当前位置应该是第几大的数 13245
			System.out.println("这个数应该是第 " + (temp + 1) + "大的数据 ");
			for (j = 1; j < n; j++) {
				if (!num[j]) {
					if (temp == 0) {
						break;
					}
					temp--;
				}
			}
			k = k % factorial(n - i - 1);/// 余数
			result[i] = (char) (j + '0');
			num[j] = true;
			// System.out.println(i + " " + j + " " + k + " " + charsToString(result));

		}
		return charsToString(result);
	}

	/*
	 * 康拓编码 给出一个全排列数字，求出这个数是第几个全排列。 规则： a[n]
	 * 代表比处在第n位的数字小，并且在第n位前面没有出现过的数字的个数。（个位是第1位） X 代表比这个全排列的数字小的数的个数，意味着这个全排列排在第 X+1
	 * 位。 例子： 集合{1,2,3,4,5}，按照字典序排好它的全排列，问 45231 这个数字在排列中的序号是多少？
	 * 
	 * 1、比数字4小的数有3个； 2、比数字5小的数有4个，但是4已经出现在前面了，所以只有3个； 3、比数字2小的数有1个；
	 * 4、比数字3小的数有2个，但是2已经出现在前面了，所以只有1个； 5、比数字1小的数有0个；
	 * 
	 * 因此 X = 3*4! + 3*3! + 1*2! + 1*1! + 0*0! = 72 + 18 + 2 + 1 +0 = 93 康托解码
	 * 给出一个序号y，求出对应这个序号的全排列是什么数字。 规则：
	 * 解码是编码的逆运算，假如这个数字的序号是y，那么比它小的数就有X=y-1个，然后分别求出每个位置的数字是多少。 例子：
	 * 集合{1,2,3,4,5}，按照字典序排好它的全排列，问第94个全排列是什么数？ 首先 X = 94 - 1 = 93 1、93 / 4! =
	 * 3，余21。有3个数比它小的数字是4，所以排在第5位的数字是4； 2、21 / 3! = 3，余 3
	 * 。有3个数比它小的数字是4，但4已经有了，因此排在第4位的数字是5； 3、 3 / 2! = 1，余 1
	 * 。有1个数比它小的数字是2，所以排在第3位的数字是2； 4、 1 / 1! = 1，余 0
	 * 。有1个数比它小的数字是2，但2已经有了，因此排在第2位的数字是3； 5、 0 / 0! = 0，余 0
	 * 。有0个数比它小的数字是1，所以排在第1位的数字是1；
	 * 
	 * 所以排在第94位的全排列是 45231 。
	 */

}
