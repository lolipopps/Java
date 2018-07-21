package DivideConquer;

import java.util.Arrays;

import util.Common;

public class Fac {
	public static void main(String[] args) {
		// int sum = 0;
		// sum = fun1(5);
		// System.out.println(sum);
		int[] number = Common.getNumberArray(10);
		int[] temp = new int[number.length];
		Common.arraytoString(number);
		int[] number1 = new int[number.length];
		System.arraycopy(number, 0, number1, 0, number.length);
		Common.arraytoString(number1);

		Sort.Mergesort(number, 0, number.length - 1, temp);
		Sort.QuickSort(number1, 0, number.length - 1);

		Common.arraytoString(number);
		Common.arraytoString(number1);
	}

	// 递归实现
	public static int fun1(int n) {
		if (n == 1) {
			return 1;
		}
		return n * fun1(n - 1);
	}

}
