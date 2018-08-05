package StringUtils;

public class 正则字符串匹配问题 {
	/*
	 * 解决：
	 * 
	 * 思路类似最长公共子序列，
	 * 
	 * dp[i][j] = dp[i - 1][j - 1], 如果s[i] == p[j] || p[j] == '.'
	 * 
	 * dp[i][j - 2], 如果p[j] == '*' && s[i] != p[j - 1] dp[i - 1][j] || dp[i][j - 1]
	 * || dp[i - 1][j - 1] || dp[i - 1][j - 2] || dp[i][j - 2], 如果p[j] == '*' &&
	 * s[i] == p[j - 1]
	 * 
	 * 稍稍解释下：
	 * 
	 * 对于s和p，设各个最后一个字符为x, y，p的倒数第二字符为z，除此外前面字符设为S,P，则：
	 * 
	 * s = Sx
	 * 
	 * p = Pzy
	 * 
	 * 如果x == y或y == '.'，则如果S和Pz匹配，则s和p匹配，因为最后两字字母是匹配的。这就缩减了问题规模。
	 * 
	 * 而对于y == '*'的情况，需要考虑z：
	 * 
	 * 如果x != z，则只有在s和P匹配的情况下，s和p才匹配。
	 * 
	 * 如果x == z，设匹配符号为~吧，方便，则如果S~P，S~Pz，S~Pzy，Sx~P，Sx~Pz，都可得出s和p匹配。
	 */
	public static void main(String[] args) {
		System.out.println(isMatch1("ababaa", "a.*a"));

	}

	public static boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();

		if (slen == 0 && plen == 0)
			return true;

		char c0 = getChar(s, 0);
		char p0 = getChar(p, 0), p1 = getChar(p, 1);

		if (match(c0, p0) || p1 == '*') { // 不是
			if (p1 != '*') {
				if (slen == 0)
					return false;
				return isMatch(s.substring(1), p.substring(1));
			}
			// if p1 is *, * means 0 ~ n
			int i = 0;
			boolean ret = isMatch(s.substring(0), p.substring(2)); // try 0
			if (ret)
				return ret;
			while (i < slen && match(getChar(s, i), p0)) {
				ret = isMatch(s.substring(i + 1), p.substring(2)); // try for every available position
				if (ret)
					return ret;
				i++;
			}
		}

		return false;
	}

	private static boolean match(char a, char b) {
		return a == b || b == '.';
	}

	private static char getChar(String s, int p) {
		if (s.length() > p) {
			return s.charAt(p);
		}
		return 0;
	}

	boolean cmatch(char s, char p) {
		return p == '*' || p == '.' || s == p;
	}

	static boolean isMatch1(String s, String p) {
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();
		boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
		dp[0][0] = true;
		for (int i = 1; i < dp[0].length; i++) {
			if (pattern[i - 1] == '*')
				dp[0][i] = dp[0][i - 2];
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1])
					dp[i][j] = dp[i - 1][j - 1];
				else if (pattern[j - 1] == '*') {
					if (pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.')
						dp[i][j] = dp[i][j - 2];
					else
						dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
				}
			}
		}
		return dp[str.length][pattern.length];
	}
}
