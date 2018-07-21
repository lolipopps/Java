package NiuKe.Arrays;

public class MinNumberInRotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int min = array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i] < min) {
				return array[i];
			}
		}
		return 0;

	}
}
