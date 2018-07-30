package ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class 前k个数 {

	public static void main(String[] args) {
		System.out.println(getLeastNumbers(new int[] {4,5,1,6,2,7,3,8},4));

	}

	public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {
		 ArrayList<Integer> res = new ArrayList<>();
	        if(k>input.length){
	            return res;
	        }
	        Arrays.sort(input);
			
			for(int i=0;i<k;i++) {
				res.add(input[i]);
			}
			return res;
	}
	
	public static ArrayList<Integer> getLeastNumbers1(int[] input, int k){
	return null;
	}

}
