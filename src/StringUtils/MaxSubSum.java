package StringUtils;

public class MaxSubSum {

	public static void main(String[] args) {

	}

	public static int maxSubsum1(int[] a) {
		int max = 0;
		// 选择一个点 遍历从这个点的开始到所有点的可能的 n^3 的复杂度
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				int tempSum = 0;

				for (int k = i; k <= j; k++) {
					tempSum += a[k];
				}

				if (tempSum > max) {
					max = tempSum;
				}

			}
		}
		return max;
	}

	public static int maxSubSum2(int[] a) {
		int maxSum = 0;

		for (int i = 0; i < a.length; i++) {
			int tempSum = 0; // 用一个 tempSum 记录每次的循环 可以少一重循环

			for (int j = i; j < a.length; j++) {
				tempSum += a[j];

				if (tempSum > maxSum)
					maxSum = tempSum;
			}
		}
		return maxSum;
	}

	public static int maxSubSum3(int[] a) {
		return subSum3(a, 0, a.length - 1);
	}

	private static int subSum3(int[] a, int left, int right) {
		if (left == right)
			if (a[left] > 0)
				return a[left];
			else
				return 0;

		int center = (left + right) / 2;
		int maxLeftSum = subSum3(a, left, center);
		int maxRightSum = subSum3(a, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++) {
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		return Math.max(Math.max(maxLeftSum, maxRightSum), maxLeftBorderSum + maxRightBorderSum);

	}
	
	
	/**
     * 求解思路：用sum(j)表示a1到aj的和，很容易求出动态规划的递归式：
     *  sum(j) = max(sum(j-1)+aj , aj)
     * 时间复杂度：O(N)
     * 动态规划的好处在于，能很清楚的返回最佳连续子序列和的起始位置和终点位置
     *
     */
    public static int maxSubSum5(int[] a) {
        int maxSum = 0;
        int tempSum = 0;
        int begin = 0;

        for (int i = 0; i < a.length; i++) {
            if (tempSum > 0)
                tempSum += a[i];
            else {
                tempSum = a[i];
                begin = i;  //标记
            }

            if (tempSum > maxSum) {
                maxSum = tempSum;
                //可以在这里获取最佳连续子序列和的起点位置begin和重点位置i
            }

        }
        return maxSum;
    }

}
