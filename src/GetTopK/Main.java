package GetTopK;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int[] result = new int[100001];
		int num =0;
		while (cin.hasNextInt()) {
			int n = cin.nextInt(); // 代表 n 次跳跃
			int[][] number = new int[n][2];  // 存起点终点
			for (int i = 0; i < n; i++) {
				number[i][0] = cin.nextInt();
				number[i][1] = cin.nextInt();
			}
			int m = cin.nextInt();  // 存方案
			int[][] post = new int[n][4];  // 存方案位置
			for (int i = 0; i < m; i++) {
				post[i][0] = cin.nextInt();
				post[i][1] = cin.nextInt();
				post[i][2] = cin.nextInt();
				post[i][3] = cin.nextInt();
			}
			for(int i=0;i<m;i++) {  // 计算第一条的得分
				for(int j=0;j<n;j++) { //循环
					if(number[j][0]>=post[i][0] && number[j][0]<=post[i][1] && number[j][1]>=post[i][2] && number[j][1]<=post[i][3]) {
						result[num]++;
					}
				}
				num++;
			}
			cin.nextLine();
		}
		for(int i=0;i<num;i++) {
			System.out.println(result[i]);
		}

	}

}
