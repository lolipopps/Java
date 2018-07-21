package NiuKe;

import java.util.Scanner;

public class CompareABC {
// 给定区间[-2的31次方, 2的31次方]内的3个整数A、B和C，请判断A+B是否大于C。
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.nextLine();  // 剔除换行
		System.out.println(num);
		for(int i=1;i<=num;i++) {
			String line = in.nextLine();
			String[] strs = line.split(" ");
			System.out.println("Case #"+i+": "+comp(Integer.parseInt(strs[0]) , Integer.parseInt(strs[1]) , Integer.parseInt(strs[2])));
		}
		

	}
	public static boolean comp(int a,int b,int c) {
		System.out.println(a+" "+b+" "+c+" "+(a+b));
		if(a < 0 && b <0 && a+b>=0) {
			return false;
		}
		
		if(a >0 && b >0 && a+b <=0) {
			return true;
		}
		return a+b>c?true:false;
		
	}

}
