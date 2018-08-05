package ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class 循环剔除数最后一个值 {

	public static void main(String[] args) {
		LastRemaining1(5, 3);

	}

	public static int LastRemaining1(int n, int m) {
		ArrayList<Integer> index = new ArrayList<Integer>();
		if(n==0||m==0) {
			return -1;
		}
		for (int i = 0; i < n; i++) {
			index.add(i);
		}
		int now = 0;
		int temp =m;
		while(index.size() > 1) {
			temp = now + m -1 ;
			System.out.println("拿掉第 "+(temp)%n +" " + index.size()+" temp "+temp+" n "+n+" now "+now);
			System.out.println(index);
			
			index.remove((temp)%n); // 拿掉第每个
			now = temp%n;
			n=n-1;
		}
		System.out.println(index);
		return index.get(0);

	}

	public static int LastRemaining(int n, int m) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(i, i);
		}
		return m;

	}

}
