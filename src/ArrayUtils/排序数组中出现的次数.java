package ArrayUtils;

import java.util.HashMap;

public class 排序数组中出现的次数 {

	public static void main(String[] args) {
		System.err.println(GetNumberOfK(new int[] { 1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 8, 8 }, 6));

	}

	public static int GetNumberOfK(int[] array, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				map.put(array[i], map.get(array[i]) + 1);
			} else {
				map.put(array[i], 1);
			}
		}
		if (map.get(k) == null) {
			return 0;
		} else {
			return map.get(k);
		}
	}

}
