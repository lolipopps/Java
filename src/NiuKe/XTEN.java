package NiuKe;

import java.util.Scanner;

public class XTEN {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String six = in.nextLine();
		if (six.length() <= 2) {
			System.out.println(0);
			return;
		}
		int result = 0;
		char[]  chs = six.toCharArray();
		for (int i = chs.length-1; i >= 2; i--) {
			if ((chs[i] >= 'A' && chs[i] <= 'F') || (chs[i] >= '0' && chs[i] <= '9')) {
				if(chs[i]  > '9') {
					result = (int) ((chs[i] - 'A' + 10) * Math.pow(16,chs.length-1-i) + result);
				}else {
					result = (int) ((chs[i] - '0') * Math.pow(16,six.toCharArray().length-i-1) + result);
				}
			} else {
				System.out.println(0);
				return;
			}
		}
		System.out.println(result);
	}
}