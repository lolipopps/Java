package ArrayUtils;

import java.util.ArrayList;

public class 回型打印矩阵 {

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(matrix);
 
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int num = 0;
		int i = 0;
		int j = 0;
		boolean flag = true;
		int plus = 1;
		System.out.println(((matrix.length) * (matrix[0].length)));
		while (num < (matrix.length) * (matrix[0].length)) {
			// ת i ����
			System.out.println(i+" "+j);
			if (flag) {
				result.add(matrix[i][j]);
				matrix[i][j] = 0;
				num++;
				j += plus;
				if (j >= matrix[0].length || j < 0 || matrix[i][j] == 0) {
					j += plus * -1;
					i += plus;
					flag = false;
					continue;
				}
				
			} else {
				result.add(matrix[i][j]);
				matrix[i][j] = 0;
				num++;
				i += plus;
				if(i >= matrix.length || i < 0 || matrix[i][j] == 0) {
					i += plus * -1;
					
					flag = true;
					plus = plus * -1;
					j += plus;
					continue;
				}
			}

			

		}
		return result;

	}

}
