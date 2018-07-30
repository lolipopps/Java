package ArrayUtils;

public class 超过一半的元素 {

	public static void main(String[] args) {
		System.out.println(moreThanHalfNum(new int[] { 1, 2, 3, 2, 4, 2, 5, 2, 3 }));
	}

	public static int moreThanHalfNum(int[] array) {
		if (array.length == 0) {
			return 0;
		}

		int num = array[0];
		int count = 1;
		for (int i = 1; i < array.length; i++) {
			if (count == 0) {
				num = array[i];
				count = 1;
				continue;
			}
			if (num == array[i]) {
				count++;
			} else {
				count--;
			}
		}

		if (count == 0) {
			return 0;
		}

		count = 0;
		for (int i = 0; i < array.length; i++) {
			if (num == array[i]) {
				count++;
			}
		}
		if (count * 2 > array.length) {
			return num;
		}
		return 0;

	}

	public static int moreThanHalfNum1(int[] array) {
		return 1;
	}
}
