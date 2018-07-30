package Base;

import java.util.ArrayList;

public class 丑数 {
	public static void main(String[] args) {
		GetUglyNumber_Solution(20);
	}

	private static int GetUglyNumber_Solution(int index) {
		if (index < 0)
			return 0;
		int[] uglyArray = new int[index];
		uglyArray[0] = 1;
		int multiply2 = 0;  // 记录以及用了多少个 2 
		int multiply3 = 0;  // 记录以及用了多少个 3
		int multiply5 = 0;  // 记录以及用了多少个 5 
		for (int i = 1; i < index; i++) {
			int min = min(uglyArray[multiply2] * 2, uglyArray[multiply3] * 3, uglyArray[multiply5] * 5);
			uglyArray[i] = min;
			while (uglyArray[multiply2] * 2 == uglyArray[i])
				multiply2++;
			while (uglyArray[multiply3] * 3 == uglyArray[i])
				multiply3++;
			while (uglyArray[multiply5] * 5 == uglyArray[i])
				multiply5++;
		}
		System.out.println(uglyArray[index - 1]);
		return uglyArray[index - 1];
	}

	public static int min(int number1, int number2, int number3) {
		int min = (number1 < number2) ? number1 : number2;
		return min < number3 ? min : number3;

	}

	public static int GetUglyNumber_Solution1(int index) { // 超时
		if (index < 0) {
			return 0;
		}
		ArrayList<Integer> dp = new ArrayList<Integer>();
		dp.add(1);
		dp.add(2);
		dp.add(3);
		dp.add(4);
		dp.add(5);
		if (index <= 5) {
			return dp.get(index - 1);
		}
		int num = 6;
		int now = 5;
		boolean flag = false;
		while (index > 5) {
			flag = false;
			for (int i = 1; i < now; i++) {
				if (num % dp.get(i) == 0) {
					flag = true;
					int temp = num / dp.get(i);
					if (!dp.contains(temp)) {
						num++;
						break;
					}
				}
				if (i == now - 1) {
					if (flag) {
						dp.add(num);
						num++;
						index--;
					} else {
						num++;
					}
				}
			}

		}
		return dp.get(dp.size() - 1);
	}
}
