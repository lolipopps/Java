package ArrayUtils;

import java.util.Scanner;

public class  重复字符串并排序 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String string = in.nextLine();
		int[] number = new int[128];
		if(string == null || string.length()==0) {
			System.out.println("");
			return;
		}
		for (char ch : string.toCharArray()) {
			number[ch]++;
		}
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i=0;i<number.length;i++) {
			if(number[i] > max) {
				max = number[i];
				index = i;
			}
		}
		for(int i=1;i<=max;i++) {
			System.out.print((char)index);
		}
	}

}
