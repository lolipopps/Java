package ArrayUtils;

import java.util.ArrayList;

public class 数组两个元素组成的和 {

	public static void main(String[] args) {
		System.out.println(FindNumbersWithSum(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 9));

	}

	public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		int begin = 0; int end = array.length-1;
		ArrayList<Integer> res = new ArrayList<Integer>();
		while(begin<end) {
		    if(array[begin] + array[end] == sum) {
		    	res.add(array[begin]);
		    	res.add(array[end]);
		    	break;
		    }else if(array[begin] + array[end] > sum) {
		    	end--;
		    }else {
		    	begin++;
		    }
		}
		return res;

	}

}
