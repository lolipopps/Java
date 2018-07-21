package ArrayUtils;

public class GenerateMatrix {

	public static void main(String[] args) {
		int[][] nums = generateMatrix(4);
		for(int i=0;i<nums.length;i++) {
			for(int j = 0; j<nums[i].length;j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] generateMatrix(int n) {
		 int[][] nums = new int[n][n];
			int[] post = { 0, 1, 0, -1 }; // 控制 x y 下一次加的方向
			int nowx = 0, nowy = 0, i = 1; // 开始 x y 的方向
			int x = 0, y = 0;
			boolean flag = false; // 可以通过 这个 控制 输出的顺序
			while (i <= n*n) {

				if (x + post[nowx] >= n || y + post[nowy] >= n || x + post[nowx] < 0 || y + post[nowy] < 0
						|| nums[x + post[nowx]][y + post[nowy]] != 0) { // 出现转弯的情况 x y 交替 转
					if (flag == true) { // x 转弯
						nowx = (nowx + 1) % 4;
						flag = false;
					} else {
						nowy = (nowy + 1) % 4;
						flag = true;
					}
				} else {
					x = x + post[nowx];
					y = y + post[nowy];
					nums[x][y] = i;
					i++;
				}
					
			}
			return nums;
	}
}
