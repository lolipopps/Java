package StringUtils;

public class 字符串转整形 {

	public static void main(String[] args) {
		System.out.println(StrToInt("-1f33"));

	}

	public static int StrToInt(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chs = str.toCharArray();
		int num = 0;
		int flag = 1;
		int res = 0;
		for (char ch : chs) {
			if (num == 0) {
				if (ch == '+') {
					flag = 1;
					continue;
				} else if (ch == '-') {
					flag = -1;
					continue;
				}
			}
			num++;

			if (ch - '0' >= 0 && ch - '0' <= 9) {
				if(res>Integer.MAX_VALUE/10) {
					return 0;
				}
				res = res * 10 + (ch - '0');
			} else {
				return 0;
			}

		}

		return res * flag;

	}

}
