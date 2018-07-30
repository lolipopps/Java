package Sort;
import util.Common;

public class 插入排序 {
	public static void main(String[] args) {
		int[] number = Common.getNumberArray(10);
		Common.arraytoString(number);
		int key = 0; 
		int j = 0;
		for(int i = 1;i<number.length;i++) {
			key = number[i];
			j = i -1;
			while(j>=0 && number[j]>key) { // 想法是从最后一个往前面找 找到自己要小的数就替换 一个一个往后面挪
				number[j+1] = number[j];
				j = j-1;
			}
			number[j+1] = key;
		}
		Common.arraytoString(number);
	}

}
