package ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class SetZeros {

	public static void main(String[] args) {
		setZeroes(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } });

	}

	public static void setZeroes(int[][] matrix) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < matrix.length; i++) {   // 找到所有 0
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					if (!map.containsKey(i)) {
						map.put(i, String.valueOf(j));
					} else {
						map.put(i, map.get(i) + "-" + String.valueOf(j));
					}
				}
			}
		}
		for(int i:map.keySet()) {
			for(int j=0;j<matrix[i].length;j++) {
				matrix[i][j] = 0;
			}
			String value = map.get(i);
			for(String col:value.split("-")) {
				for(i=0;i<matrix.length;i++) {
					matrix[i][Integer.valueOf(col)] = 0;
				}
			}
		}
		
		for(int i=0;i<matrix.length;i++) {
			for(int j = 0; j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}

	}

}
