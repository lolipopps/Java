package ArrayUtils;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class 得糖最多 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String string = in.nextLine();

		String[] strs = string.split(" ");
		int[] num = new int[strs.length];

		Stack<Integer> map = new Stack<Integer>();
		for (int i = 0; i < strs.length; i++) {
			num[i] = Integer.parseInt(strs[i]);

			if (num[i] % 2 == 0) {
				map.add(num[i]);
			}
		}
		int now;
		int count = 0;
		while (!map.isEmpty()) {
			count++;
			now = map.pop() / 2;
			if (now % 2 == 0 && now != 0) {
				map.push(now);
			}
			
		}

		System.out.println(count);
	}

}
