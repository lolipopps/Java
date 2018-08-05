package ArrayUtils;

import java.util.ArrayList;


public class 只出现一次的数 {

	public static void main(String[] args) {
		int[] array = new int[] {1,2,3,4,4,4,4,2,1,5,5,6,6,8,8,8,8,7};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		FindNumsAppearOnce(array,num1,num2);
	}

	public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		for(int i=0;i<array.length;i++) {
			if(map.contains(array[i])) {
				Integer temp = new Integer(array[i]);
				map.remove(temp);
			}else {
				map.add(array[i]);
			}
		}
		num1[0] = map.get(0);
		num2[0] = map.get(1);
	}
}
