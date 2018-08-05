package util;

import java.util.Scanner;

public class 比较幂次方 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();

		if(x*Math.log(y) > y*Math.log(x)) {
			System.out.println("<");
		}else if(x*Math.log(y) == y*Math.log(x)) {
			System.out.println("=");
		}else {
			System.out.println(">");
		}

	}

}
