package ArrayUtils;

import java.util.ArrayList;

public class ReOrderArray {

	public static void main(String[] args) {
		reOrderArray(new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 11, 14 });

	}

	public static void reOrderArray(int[] array) {
		ArrayList<Integer> odds = new ArrayList<Integer>();
		ArrayList<Integer> enev = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				enev.add(array[i]);
			} else {
				odds.add(array[i]);
			}
		}
		odds.addAll(enev);
		for (int i = 0; i < array.length; i++) {
			array[i] = odds.get(i);
		}
		enev = null;

	}

}
