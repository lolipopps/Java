package Dp;

public class 积水问题 {
	/*
	 * Trapping Rain Water 使用两根指针：给定 n 个非负整数表示每个宽度为1的柱子的高度图，计算下雨之后能接多少水。 给定 n
	 * 个非负整数表示每个宽度为1的柱子的高度图，计算下雨之后能接多少水。 输入 [0,1,0,2,1,0,1,3,2,1,2,1]，返回 6。 思路
	 * 使用两根指针： 1. 一根从右往左，更新记录从位置i往右边的峰值; 2. 一根从左往右遍历。更新从位置i往左边峰值的同时，计算位置i处可以积水多少; 3.
	 * 水面高度h应为min(maxL,maxR)。积水应为max(0,h-height[I]);
	 */
	public static void main(String[] args) {
		trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
	}

	public static int trap(int[] height) {
		if (height == null || height.length <= 2)
			return 0;
		int maxL = height[0];
		int[] maxRs = new int[height.length];
		int waterSum = 0;// 计算总的水量
		int maxR = 0;
		// 两个循环 先用这个从右边开始记录每个点的右边峰值
		// 返回 
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] > maxR) {
				maxRs[i] = maxR = height[i];
			} else {
				maxRs[i] = maxR;
			}
		}
		//  3 3 3 3 3 3 3 3 2 2 2 1
		for (int i = 1; i < height.length - 1; i++) { // 左边开始遍历得到左高峰 取中间最小的 减去自身高度为融水量
			if (height[i] > maxL) {
				maxL = height[i];// 更新左边最大值
			}
			waterSum += Math.max(Math.min(maxL, maxRs[i]) - height[i], 0);
		}
		System.out.println(waterSum);
		return waterSum;

	}

}
