package ArrayUtils;

import java.util.LinkedHashMap;

public class 最早重复的元素 {

	public static void main(String[] args) {
		int[] number = new int[] { 2,4,2,1,4 };
		int length = number.length;
		int[] result = new int[length];
		System.out.println(duplicate(number, length, result));
	}

	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || numbers.length == 0 || length <= 0) {
			return false;
		}
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(numbers[i])) {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			} else {
				map.put(numbers[i], 1);
			}

		}
		int index = 0;
		boolean flag = false;
		for (Integer key : map.keySet()) {
			if (map.get(key) > 1) {
				duplication[index] = key;
				flag = true;
				return flag;
			}
		}
		
		return flag;

	}

}
