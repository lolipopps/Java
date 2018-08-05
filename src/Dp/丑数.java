package Dp;

public class 丑数 {

	public static void main(String[] args) {
		nthUglyNumber1(10);

	}

	public static int nthUglyNumber1(int index) {
		if (index < 0)
			return 0;
		int[] uglyArray = new int[index];
		uglyArray[0] = 1;
		int multiply2 = 0;  // 记录使用了几个 2 
		int multiply3 = 0;
		int multiply5 = 0;
		for (int i = 1; i < index; i++) { // [1,2,3,4,5,6]
			int min = min(uglyArray[multiply2] * 2, uglyArray[multiply3] * 3, uglyArray[multiply5] * 5);
			uglyArray[i] = min;
			while (uglyArray[multiply2] * 2 == uglyArray[i])
				multiply2++;
			while (uglyArray[multiply3] * 3 == uglyArray[i])
				multiply3++;
			while (uglyArray[multiply5] * 5 == uglyArray[i])
				multiply5++;
		}
		return uglyArray[index - 1];
	}

	public static int min(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		return min < number3 ? min : number3;
	}
}
