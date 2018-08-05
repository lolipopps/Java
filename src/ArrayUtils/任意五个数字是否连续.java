package ArrayUtils;

import java.util.Arrays;

public class 任意五个数字是否连续 {

	public static void main(String[] args) {
		System.out.println(isContinuous(new int[]{0,0,2,1,6}));

	}

	public static boolean isContinuous(int[] numbers) {
		if(numbers.length<5) {
			return false;
		}
		Arrays.sort(numbers);
		int count = 0;
		for (int i = 0; i < numbers.length-1; i++) {
			if (numbers[i] == 0) {
				count++;
				continue;
			}
			if(count>3) {
				return false;
			}
			if(numbers[i+1]-numbers[i] == 0) {
				return false;
			}
			if(numbers[i+1]-numbers[i]-1 > count) {
				return false;
			}else {
				count = count - (numbers[i+1] - numbers[i] -1);
			}
			
		}
		return true;

	}
}
