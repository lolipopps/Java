package StringUtils;

import java.util.Scanner;

public class 最长的出现次数 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		int[] number = new int[128];

		char prex = string.charAt(0);
		int count = 0;
		char[] chs = string.toCharArray();
		for (int i = 0; i < chs.length; i++) {
			if (prex == chs[i] && i<chs.length-1) {
				count++;
			} else {
				if (count > number[chs[i]]) {
					number[chs[i]] = count;
				}
				count = 1;
			}
			prex = chs[i];
			
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] > max) {
				max = number[i];
				index = i;
			}
		}
		for (int i = 1; i <= max; i++) {
			System.out.print((char) index);
		}
	}

}
