package ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class 括号匹配 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int i=0;
		in.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		while(i<n) {
			String line = in.nextLine();
			int count=0;
			for(char ch:line.toCharArray()) {
				if(ch=='(') {
					count++;
				}
			}
			list.add(line+"_"+count);
			System.out.println(list);
			i++;
		}

	}

}
