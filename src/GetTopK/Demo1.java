package GetTopK;

import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int[] result = new int[10001];
		while (cin.hasNextInt()) {//注意while处理多个case
          int n = cin.nextInt();
          int[][] number = new int[n][2];
          for(int i=0;i<n;i++) {
        	  number[i][0] = cin.nextInt();
        	  number[i][1] = cin.nextInt();
          }
          for(int i=0;i<n;i++) {
        	  for(int j=number[i][0];j<number[i][1];j++) {
        		  result[j]++;
        	  }
          }
        }
	}

}
