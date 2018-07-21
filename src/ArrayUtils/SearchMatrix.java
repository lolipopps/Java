package ArrayUtils;

public class SearchMatrix {

	public static void main(String[] args) {
		int[][] nums = new int[][] { { 1 } };
		System.out.println(searchMatrix(nums, 0));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		if(matrix.length==0 || matrix[0].length==0) {
			return false;
		}
		for(int i=0;i<matrix.length;i++) {
			if(target == matrix[i][0]) {
				return true;
			}
			if(target<matrix[i][0]) {
				if(i==0) {
					return false;
				}
				row = i-1;
				break;
			}
			if(i == matrix.length-1) {
				row = i;
			}
		}  // 找到所在行
		int low = 0;
		System.out.println(row);
		int high = matrix[row].length-1;
		if( matrix[row][high]<target) {
			return false;
		}else {
		while(low<=high) {
			int mid = (low + high) /2 ;
			if(target == matrix[row][mid]) {
				return true;
			}
			if(target<matrix[row][mid]) {
				high = mid - 1;
			}else {
				low = mid +1;
			}
		}
		}
		return false;

	}

}
